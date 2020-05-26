package com.xeroxparc.materialcomponentsdemo.ui.component.textfield;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * View class.
 * Handle lifecycle event, receives the user's interaction and it forwards the handling of these
 * to the view model via the data binding.
 * @author Fabio Buracchi
 *
 */
public class TextFieldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextFieldBinder binder = new TextFieldBinder(this);
        setContentView(binder.getRoot());
        binder.bind();
    }
}
