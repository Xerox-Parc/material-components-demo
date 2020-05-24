package com.xeroxparc.materialcomponentsdemo.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

public class ComponentSearchActivity extends AppCompatActivity {

    ComponentSearchBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = new ComponentSearchBinder(this);
        setContentView(binder.getRoot());
        binder.bind();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        binder.bindMenu(menu);
        return true;
    }
}
