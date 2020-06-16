package com.xeroxparc.materialcomponentsdemo.ui.component.tab;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * ViewPager2's adapter class.
 * It initialize list item objects and it maintains coherency with the model.
 * @author Fabio Buracchi
 *
 */
public class TabViewPagerAdapter extends RecyclerView.Adapter<TabViewPagerAdapter.ViewPagerViewHolder> {

    private List<Drawable> imageList;

    TabViewPagerAdapter(List<Drawable> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder(new TabViewPagerBinder(parent.getContext(), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        holder.binder.bind(imageList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    static class ViewPagerViewHolder extends RecyclerView.ViewHolder {

        final TabViewPagerBinder binder;

        ViewPagerViewHolder(@NonNull TabViewPagerBinder binder) {
            super(binder.getRoot());
            this.binder = binder;
        }
    }
}
