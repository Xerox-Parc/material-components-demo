package com.xeroxparc.materialcomponentsdemo.ui.search;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.data.MaterialComponent;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivitySearchBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.toCamelCase;

/**
 * Binder class, it synchronize the view model and the view.
 * It replace data binding and BindingAdapter classes providing similar results with actual testable
 * code instead of fill XML with logic and lambda expression.
 * @author Fabio Buracchi
 *
 */
class ComponentSearchBinder {

    private final ActivitySearchBinding binding;
    private final ComponentSearchActivity activity;
    private final ComponentSearchViewModel viewModel;

    ComponentSearchBinder(@NonNull ComponentSearchActivity activity) {
        this.activity = activity;
        binding = ActivitySearchBinding.inflate(activity.getLayoutInflater());
        viewModel = new ViewModelProvider(activity).get(ComponentSearchViewModel.class);
    }

    View getRoot() { return binding.getRoot(); }

    void bind(){
        Menu menu = binding.appBarContainer.toolbar.getMenu();
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.searchComponent(newText);
                return true;
            }
        });

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

    private void showDetail(@NonNull MaterialComponent component) {
        Intent intent = null;
        try {
            intent = new Intent(activity, Class.forName(String.format(
                    "com.xeroxparc.materialcomponentsdemo.ui.component.%s.%sActivity",
                    toCamelCase(component.getName()).toLowerCase(),
                    toCamelCase(component.getName())
            )));
        } catch (ClassNotFoundException e) {
            Log.e("SearchActivity", "Selected component class not found");
        }
        activity.startActivity(intent);
    }

}
