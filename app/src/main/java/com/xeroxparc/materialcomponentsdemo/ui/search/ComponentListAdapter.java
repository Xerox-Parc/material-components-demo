package com.xeroxparc.materialcomponentsdemo.ui.search;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xeroxparc.materialcomponentsdemo.data.MaterialComponent;

import java.util.List;

public abstract class ComponentListAdapter extends RecyclerView.Adapter<ComponentListAdapter.ComponentViewHolder> {

    private List<MaterialComponent> componentList;

    abstract void onClickCallback(MaterialComponent component);

    @NonNull
    @Override
    public ComponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ComponentViewHolder(new ComponentListItemBinder(parent.getContext(), parent, false));
    }

    @Override
    public int getItemCount() { return (componentList != null) ? componentList.size(): 0; }

    @Override
    public void onBindViewHolder(@NonNull ComponentViewHolder holder, int position) {
        if (componentList != null){
            MaterialComponent component = componentList.get(position);
            holder.binder.bind(component);
            holder.binder.getRoot().setOnClickListener(c -> onClickCallback(component));
        }
    }

    void setComponentList(List<MaterialComponent> componentList) {
        this.componentList = componentList;
        notifyDataSetChanged();
    }

    static class ComponentViewHolder extends RecyclerView.ViewHolder {

        ComponentListItemBinder binder;

        ComponentViewHolder(@NonNull ComponentListItemBinder binder) {
            super(binder.getRoot());
            this.binder = binder;
        }
    }

}
