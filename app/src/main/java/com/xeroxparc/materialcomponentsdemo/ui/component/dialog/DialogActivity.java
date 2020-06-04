package com.xeroxparc.materialcomponentsdemo.ui.component.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
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
            binding.appBarContainer.toolbar.setTitle(R.string.dialog_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_dialog);


            inflateSpanTextViewContent(binding, activity);

            binding.materialButtonAlertDialog.setOnClickListener(l -> {
                new MaterialAlertDialogBuilder(DialogActivity.this)
                        .setMessage("Discard Draft?")
                        .setPositiveButton("DISCARD", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { }
                        })
                        .show();
            });

            binding.materialButtonSimpleDialog.setOnClickListener(l -> {
                String[] singleChoiceItems = getResources().getStringArray(R.array.simple_dialog_array);
                int itemSelected = 0;
                new MaterialAlertDialogBuilder(DialogActivity.this)
                        .setTitle("View options")
                        .setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedIndex) {

                            }
                        })
                        .setPositiveButton("ACCEPT", null)
                        .show();
            });

            binding.materialButtonConfirmationDialog.setOnClickListener(l -> {
                String[] singleChoiceItems = getResources().getStringArray(R.array.confirmation_dialog_array);
                int itemSelected = 0;
                new MaterialAlertDialogBuilder(DialogActivity.this)
                        .setTitle("Phone Ringtone")
                        .setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int selectedIndex) {

                            }
                        })
                        .setPositiveButton("OK", null)
                        .setNegativeButton("CANCEL", null)
                        .show();
            });

        }


        View getRoot() {
            return binding.getRoot();
        }
    }
}
