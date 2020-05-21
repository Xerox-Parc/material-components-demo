package com.xeroxparc.materialcomponentsdemo.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ComponentSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentSearchBinder binder = new ComponentSearchBinder(this);
        setContentView(binder.getRoot());
        binder.bind();
    }

}
