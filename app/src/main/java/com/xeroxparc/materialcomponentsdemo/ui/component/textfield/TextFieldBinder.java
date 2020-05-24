package com.xeroxparc.materialcomponentsdemo.ui.component.textfield;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityTextFieldBinding;

import java.util.Objects;

class TextFieldBinder {

    private ActivityTextFieldBinding binding;
    private TextFieldActivity activity;

    TextFieldBinder(TextFieldActivity activity) {
        this.activity = activity;
        binding = ActivityTextFieldBinding.inflate(activity.getLayoutInflater());
    }

    View getRoot() { return binding.getRoot(); }

    void bind() {
        activity.setSupportActionBar((Toolbar) binding.appBar.getRoot());
        binding.textViewTitle.setText(Html.fromHtml(
                (String) activity.getText(R.string.text_field_text_tile),
                Html.FROM_HTML_MODE_COMPACT
        ));
        binding.textViewUsage.setText(Html.fromHtml(
                (String) activity.getText(R.string.text_field_text_usage),
                Html.FROM_HTML_MODE_COMPACT
        ));
        binding.textViewTypes.setText(Html.fromHtml(
                (String) activity.getText(R.string.text_field_text_types),
                Html.FROM_HTML_MODE_COMPACT
        ));
        binding.textViewFilled.setText(Html.fromHtml(
                (String) activity.getText(R.string.text_field_text_filled),
                Html.FROM_HTML_MODE_COMPACT
        ));
        binding.textViewOutlined.setText(Html.fromHtml(
                (String) activity.getText(R.string.text_field_text_outlined),
                Html.FROM_HTML_MODE_COMPACT
        ));
        binding.textViewIcon.setText(Html.fromHtml(
                (String) activity.getText(R.string.text_field_text_icon),
                Html.FROM_HTML_MODE_COMPACT
        ));
        binding.materialButton.setOnClickListener(l -> {
            if (Objects.requireNonNull(
                    binding.textFieldPassword.getEditText()).getText().toString().length() < 8) {
                binding.textFieldPassword.setError(activity.getString(R.string.text_field_error));
            } else {
                Toast.makeText(activity, activity.getString(R.string.text_field_toast), Toast.LENGTH_LONG).show();
            }
        });
        Objects.requireNonNull(binding.textFieldPassword.getEditText()).setOnClickListener(l -> {
            binding.textFieldPassword.setError(null);
        });
        Objects.requireNonNull(binding.textFieldPassword.getEditText()).addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        binding.textFieldPassword.setError(null);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );
    }

}
