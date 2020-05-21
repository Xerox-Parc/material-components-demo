package com.xeroxparc.materialcomponentsdemo.ui.search;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xeroxparc.materialcomponentsdemo.data.MaterialComponent;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivitySearchBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.toCamelCase;

class ComponentSearchBinder {

    private ActivitySearchBinding binding;
    private ComponentSearchActivity activity;
    private ComponentSearchViewModel viewModel;

    ComponentSearchBinder(ComponentSearchActivity activity) {
        this.activity = activity;
        binding = ActivitySearchBinding.inflate(activity.getLayoutInflater());
        viewModel = new ViewModelProvider(activity).get(ComponentSearchViewModel.class);
    }

    View getRoot() { return binding.getRoot(); }

    void bind(){
        final ComponentListAdapter componentListAdapter = new ComponentListAdapter() {
            @Override
            void onClickCallback(MaterialComponent component) {
                showDetail(component);
            }
        };
        binding.recyclerView.setAdapter(componentListAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        //Update cache in the adapter
        viewModel.getListComponent().observe(activity, componentListAdapter::setComponentList);
    }

    private void showDetail(MaterialComponent component) {
        Intent intent = null;
        try {
            intent = new Intent(activity, Class.forName(String.format(
                    "com.xeroxparc.materialcomponentsdemo.ui.component.%s.%sActivity",
                    toCamelCase(component.getName()).toLowerCase(),
                    toCamelCase(component.getName())
            )));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        activity.startActivity(intent);
    }

}
