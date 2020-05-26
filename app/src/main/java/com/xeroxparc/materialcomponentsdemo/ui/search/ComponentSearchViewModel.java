package com.xeroxparc.materialcomponentsdemo.ui.search;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.xeroxparc.materialcomponentsdemo.data.ComponentRepository;
import com.xeroxparc.materialcomponentsdemo.data.MaterialComponent;

import java.util.List;

/**
 * View model class.
 * Maintains state of the model data.
 * Implement the business logic.
 * @author Fabio Buracchi
 *
 */
public class ComponentSearchViewModel extends AndroidViewModel {

    private final ComponentRepository repository;

    private final MutableLiveData<String> filterComponentName;

    private final LiveData<List<MaterialComponent>> listComponent;

    public ComponentSearchViewModel(@NonNull Application application) {
        super(application);
        repository = new ComponentRepository(application);
        filterComponentName = new MutableLiveData<>("");
        listComponent = Transformations.switchMap(filterComponentName, name -> name.isEmpty()?
                repository.getAllComponentList() :
                repository.getComponentListByName(name));
    }

    LiveData<List<MaterialComponent>> getListComponent() { return listComponent; }

    void searchComponent(String name) {
        filterComponentName.setValue(name);
    }

}
