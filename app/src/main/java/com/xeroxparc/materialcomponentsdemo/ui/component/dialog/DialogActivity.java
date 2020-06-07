package com.xeroxparc.materialcomponentsdemo.ui.component.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityDialogBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class DialogActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }


    class Holder {


        private ActivityDialogBinding binding;


        Holder(Activity activity) {
            binding = ActivityDialogBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(getString(R.string.dialog_title));
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_dialog);


            inflateSpanTextViewContent(binding, activity);

            binding.materialButtonAlertDialog.setOnClickListener(l -> new MaterialAlertDialogBuilder(DialogActivity.this)
                        .setMessage(getString(R.string.dialog_alert_draft))
                        .setPositiveButton(getString(R.string.dialog_alert_discard), (dialog, which) -> {})
                        .setNegativeButton(getString(R.string.dialog_text_cancel), (dialog, which) -> {})
                        .show()
            );

            binding.materialButtonSimpleDialog.setOnClickListener(l -> {
                String[] singleChoiceItems = getResources().getStringArray(R.array.dialog_array_simple);
                int itemSelected = 0;
                new MaterialAlertDialogBuilder(DialogActivity.this)
                        .setTitle(getString(R.string.dialog_simple_option))
                        .setSingleChoiceItems(
                                singleChoiceItems,
                                itemSelected,
                                (dialogInterface, selectedIndex) -> {}
                                )
                        .setPositiveButton(getString(R.string.dialog_simple_accept), null)
                        .show();
            });

            binding.materialButtonConfirmationDialog.setOnClickListener(l -> {
                String[] singleChoiceItems = getResources().getStringArray(R.array.dialog_array_confirmation);
                int itemSelected = 0;
                new MaterialAlertDialogBuilder(DialogActivity.this)
                        .setTitle(getString(R.string.dialog_confirmation_ringtone))
                        .setSingleChoiceItems(
                                singleChoiceItems,
                                itemSelected,
                                (dialogInterface, selectedIndex) -> {}
                                )
                        .setPositiveButton(getString(R.string.dialog_confirmation_ok), null)
                        .setNegativeButton(getString(R.string.dialog_text_cancel), null)
                        .show();
            });

        }


        View getRoot() {
            return binding.getRoot();
        }
    }
}
