package com.xeroxparc.materialcomponentsdemo.ui.component.snackbar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivitySnackbarBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class SnackbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {

        private ActivitySnackbarBinding binding;

        Holder(Activity activity) {
            binding = ActivitySnackbarBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.snackbar_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_snackbar);

            inflateSpanTextViewContent(binding, activity);

            binding.snackbarButton.setOnClickListener(l ->
                    Snackbar.make(binding.coordinator,
                            R.string.snackbar_text_visible,
                            BaseTransientBottomBar.LENGTH_LONG).show()
            );

            binding.snackbarButtonUndo.setOnClickListener(l ->
                    Snackbar.make(binding.coordinator,
                            R.string.snackbar_text_visible,
                            BaseTransientBottomBar.LENGTH_LONG).setAction(
                                    R.string.snackbar_undo,
                                    v -> Log.e("UNDO","Done")
                            ).show()
            );
        }
        View getRoot() {
            return binding.getRoot();
        }
    }

}
