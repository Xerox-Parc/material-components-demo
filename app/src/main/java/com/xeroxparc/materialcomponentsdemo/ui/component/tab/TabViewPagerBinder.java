package com.xeroxparc.materialcomponentsdemo.ui.component.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.xeroxparc.materialcomponentsdemo.databinding.ItemTabViewPagerBinding;

/**
 * Binder class, it synchronize the view model and the view.
 * It replace data binding and BindingAdapter classes providing similar results with actual testable
 * code instead of fill XML with logic and lambda expression.
 * @author Fabio Buracchi
 *
 */
public class TabViewPagerBinder {

    private final ItemTabViewPagerBinding binding;

    TabViewPagerBinder(Context context, ViewGroup root, Boolean attachToRoot){
        binding = ItemTabViewPagerBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
    }

    View getRoot(){
        return binding.getRoot();
    }

    void bind(@NonNull Drawable image) {
        binding.imageView.setImageDrawable(image);
    }
}
