package com.xeroxparc.materialcomponentsdemo.ui.component.textfield;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TextFieldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextFieldBinder binder = new TextFieldBinder(this);
        setContentView(binder.getRoot());
        binder.bind();
    }
}
