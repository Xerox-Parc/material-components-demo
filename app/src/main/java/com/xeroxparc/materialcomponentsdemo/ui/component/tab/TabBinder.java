package com.xeroxparc.materialcomponentsdemo.ui.component.tab;

import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.material.tabs.TabLayoutMediator;
import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityTabBinding;

import java.util.Arrays;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

/**
 * Binder class, it synchronize the view model and the view.
 * It replace data binding and BindingAdapter classes providing similar results with actual testable
 * code instead of fill XML with logic and lambda expression.
 * @author Fabio Buracchi
 *
 */
class TabBinder {

    private final ActivityTabBinding binding;
    private final TabActivity activity;

    TabBinder(@NonNull TabActivity activity) {
        this.activity = activity;
        binding = ActivityTabBinding.inflate(activity.getLayoutInflater());
    }

    View getRoot() {
        return binding.getRoot();
    }

    void bind() {
        binding.appBarContainer.toolbar.setTitle(R.string.tab_title);
        binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_tab);

        inflateSpanTextViewContent(binding, activity);

        binding.viewPagerFixed.setAdapter(new TabViewPagerAdapter(Arrays.asList(
                activity.getDrawable(R.drawable.picture_cat),
                activity.getDrawable(R.drawable.picture_dog),
                activity.getDrawable(R.drawable.picture_bird)
        )));

        new TabLayoutMediator(binding.tabLayoutFixed, binding.viewPagerFixed,
                (tab, position) -> tab.setText("TAB" + (position + 1))
        ).attach();

        binding.viewPagerScrollable.setAdapter(new TabViewPagerAdapter(Arrays.asList(
                activity.getDrawable(R.drawable.picture_dolphin),
                activity.getDrawable(R.drawable.picture_bird),
                activity.getDrawable(R.drawable.picture_giraffe),
                activity.getDrawable(R.drawable.picture_dog),
                activity.getDrawable(R.drawable.picture_horse),
                activity.getDrawable(R.drawable.picture_cat)
        )));

        new TabLayoutMediator(binding.tabLayoutScrollable, binding.viewPagerScrollable,
                (tab, position) -> tab.setText("TAB" + (position + 1))
        ).attach();
    }

}
