package com.xeroxparc.materialcomponentsdemo.ui.component.tooltip;

import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityTooltipBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

/**
 * Binder class, it synchronize the view model and the view.
 * It replace data binding and BindingAdapter classes providing similar results with actual testable
 * code instead of fill XML with logic and lambda expression.
 * @author Fabio Buracchi
 *
 */
class TooltipBinder {

    private final ActivityTooltipBinding binding;
    private final TooltipActivity activity;

    TooltipBinder(@NonNull TooltipActivity activity) {
        this.activity = activity;
        binding = ActivityTooltipBinding.inflate(activity.getLayoutInflater());
    }

    View getRoot() {
        return binding.getRoot();
    }

    void bind() {
        binding.appBarContainer.toolbar.setTitle(R.string.tooltip_title);
        binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_tooltip);

        inflateSpanTextViewContent(binding, activity);
    }

}
