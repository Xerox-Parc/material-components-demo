package com.xeroxparc.materialcomponentsdemo.utils;

import java.lang.reflect.Field;

public class Utils {

    public static String toCamelCase(String string){
        StringBuilder result = new StringBuilder();
        for (String token : string.replace(":", "").split(" ")){
            if (token.endsWith("s") && !token.substring(0, token.length() - 1).endsWith("s")) {
                token = token.substring(0, token.length() - 1);
            }
            result.append(token.substring(0, 1).toUpperCase()).append(token.substring(1).toLowerCase());
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

}
