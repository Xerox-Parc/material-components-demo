package com.xeroxparc.materialcomponentsdemo.ui.component.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityTextFieldBinding;

import java.util.Objects;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

class TextFieldBinder {

    private ActivityTextFieldBinding binding;
    private TextFieldActivity activity;

    TextFieldBinder(TextFieldActivity activity) {
        this.activity = activity;
        binding = ActivityTextFieldBinding.inflate(activity.getLayoutInflater());
    }

    View getRoot() {
        return binding.getRoot();
    }

    void bind() {
        activity.setSupportActionBar((Toolbar) binding.appBar.getRoot());
        inflateSpanTextViewContent(binding, activity);

        this.binding.materialButton.setOnClickListener(l -> {
            if (Objects.requireNonNull(
                    this.binding.textFieldPassword.getEditText()).getText().toString().length() < 8) {
                this.binding.textFieldPassword.setError(activity.getString(R.string.text_field_error));
            } else {
                Toast.makeText(activity, activity.getString(R.string.text_field_toast), Toast.LENGTH_LONG).show();
            }
        });
        this.binding.textFieldPasswordEditText.setOnClickListener(l -> this.binding.textFieldPassword.setError(null));
        this.binding.textFieldPasswordEditText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        TextFieldBinder.this.binding.textFieldPassword.setError(null);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );
    }

}
