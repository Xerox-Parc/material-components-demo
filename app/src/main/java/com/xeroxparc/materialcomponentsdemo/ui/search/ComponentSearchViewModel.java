package com.xeroxparc.materialcomponentsdemo.ui.search;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.xeroxparc.materialcomponentsdemo.data.ComponentRepository;
import com.xeroxparc.materialcomponentsdemo.data.MaterialComponent;

import java.util.List;

public class ComponentSearchViewModel extends AndroidViewModel {

    private ComponentRepository repository;

    private LiveData<List<MaterialComponent>> listComponent;

    public ComponentSearchViewModel(@NonNull Application application) {
        super(application);
        repository = new ComponentRepository(application);
        listComponent = repository.getComponentList();
    }

    LiveData<List<MaterialComponent>> getListComponent() { return listComponent; }

}
