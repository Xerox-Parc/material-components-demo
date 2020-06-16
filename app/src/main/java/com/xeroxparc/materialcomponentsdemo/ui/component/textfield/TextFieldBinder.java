package com.xeroxparc.materialcomponentsdemo.ui.component.textfield;

import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityTextFieldBinding;

import java.util.Objects;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

/**
 * Binder class, it synchronize the view model and the view.
 * It replace data binding and BindingAdapter classes providing similar results with actual testable
 * code instead of fill XML with logic and lambda expression.
 * @author Fabio Buracchi
 *
 */
class TextFieldBinder {

    private final ActivityTextFieldBinding binding;
    private final TextFieldActivity activity;

    TextFieldBinder(@NonNull TextFieldActivity activity) {
        this.activity = activity;
        binding = ActivityTextFieldBinding.inflate(activity.getLayoutInflater());
    }

    View getRoot() {
        return binding.getRoot();
    }

    void bind() {
        binding.appBarContainer.toolbar.setTitle(R.string.text_field_title);
        binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_textfield);

        inflateSpanTextViewContent(binding, activity);

        this.binding.materialButton.setOnClickListener(l -> {
            if (Objects.requireNonNull(this.binding.textFieldPasswordEditText.getText()).toString().length() < 8) {
                this.binding.textFieldPassword.setError(activity.getString(R.string.text_field_error));
            } else {
                Toast.makeText(activity, activity.getString(R.string.text_field_toast), Toast.LENGTH_LONG).show();
            }
        });
        this.binding.textFieldPasswordEditText.setOnClickListener(
                l -> this.binding.textFieldPassword.setError(null)
        );
    }

}
