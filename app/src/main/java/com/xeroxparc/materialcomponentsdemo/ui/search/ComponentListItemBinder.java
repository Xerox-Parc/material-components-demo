package com.xeroxparc.materialcomponentsdemo.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.data.MaterialComponent;
import com.xeroxparc.materialcomponentsdemo.databinding.ItemComponentBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.getResourceId;
import static com.xeroxparc.materialcomponentsdemo.utils.Utils.toCamelCase;

class ComponentListItemBinder {

    private ItemComponentBinding binding;

    ComponentListItemBinder(Context context, ViewGroup root, Boolean attachToRoot){
        binding = ItemComponentBinding.inflate(LayoutInflater.from(context), root, attachToRoot);
    }

    View getRoot(){
        return binding.getRoot();
    }

    void bind(MaterialComponent component) {
        binding.textView.setText(component.getName());
        binding.imageView.setImageResource(getResourceId(
                toCamelCase("banner_" + component.getName()).toLowerCase(),
                R.drawable.class
        ));
    }

}
