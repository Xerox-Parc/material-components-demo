package com.xeroxparc.materialcomponentsdemo.utils;

import android.app.Activity;
import android.text.Html;
import android.text.Spanned;

import com.xeroxparc.materialcomponentsdemo.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class Utils {

    public static String toCamelCase(String string){
        StringBuilder result = new StringBuilder();
        for (String token : string.replaceAll("[^A-Za-z0-9 ]", "").split(" ")){
            if (token.endsWith("s") && !token.substring(0, token.length() - 1).endsWith("s")) {
                token = token.substring(0, token.length() - 1);
            }
            if (!token.isEmpty()) {
                result.append(token.substring(0, 1).toUpperCase()).append(token.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    public static String toSnakeCase(String string){
        StringBuilder result = new StringBuilder();
        for (char c : string.replaceAll("[^A-Za-z0-9 ]", "").toCharArray()) {
            result.append(c < 'a' ? "_" + (char) (c - 'A' + 'a') : c);
        }
        return result.toString();
    }

    public static int getResourceId(String resourceName, Class<?> resourceClass) {
        try {
            Field field = resourceClass.getField(resourceName);
            return field.getInt(field);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void inflateSpanTextViewContent(Object binding, Activity activity)
            throws IllegalAccessException, InvocationTargetException {

        String component;
        Spanned content;

        component = activity.getClass().getName();
        component = component.substring(
                component.lastIndexOf(".") + 1,
                component.length() - "Activity".length()
        );
        component = toSnakeCase(component).substring(1);

        for (Field field : binding.getClass().getFields()) {
            if (field.getName().contains("Span")) {
                field.setAccessible(true);
                Object fieldObject = field.get(binding);
                Method setFieldText = null;
                for (Method method : Objects.requireNonNull(fieldObject).getClass().getMethods()) {
                    if (method.getName().equals("setText") &&
                            method.getParameterTypes().length == 1 &&
                            method.getParameterTypes()[0].equals(CharSequence.class)) {
                        setFieldText = method;
                        break;
                    }
                }
                String resourceName = component + "_span_" +
                        toSnakeCase(field.getName()).substring("text_view_span_".length()
                );
                content = Html.fromHtml(
                        (String) activity.getText(getResourceId(resourceName, R.string.class)),
                        Html.FROM_HTML_MODE_COMPACT
                );
                Objects.requireNonNull(setFieldText).invoke(fieldObject, content);
            }
        }
    }

}
