package com.xeroxparc.materialcomponentsdemo.ui.component.selectioncontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivitySelectionControlBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class SelectionControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {

        private ActivitySelectionControlBinding binding;

        Holder(Activity activity) {
            binding = ActivitySelectionControlBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.selection_control_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_selectioncontrol);
            inflateSpanTextViewContent(binding, activity);

            binding.radioOne.setOnClickListener(l -> Toast.makeText(
                    getBaseContext(),
                    binding.radioOne.getText(),
                    Toast.LENGTH_SHORT
            ).show());
            binding.radioTwo.setOnClickListener(l -> Toast.makeText(
                    getBaseContext(),
                    binding.radioTwo.getText(),
                    Toast.LENGTH_SHORT
            ).show());
            binding.radioThree.setOnClickListener(l -> Toast.makeText(
                    getBaseContext(),
                    binding.radioThree.getText(),
                    Toast.LENGTH_SHORT
            ).show());

        }
        View getRoot() {
            return binding.getRoot();
        }


    }

}
