package com.xeroxparc.materialcomponentsdemo.ui.component.tab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * View class.
 * Handle lifecycle event, receives the user's interaction and it forwards the handling of these
 * to the view model via the data binding.
 * @author Fabio Buracchi
 *
 */
public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabBinder binder = new TabBinder(this);
        setContentView(binder.getRoot());
        binder.bind();
    }

}
