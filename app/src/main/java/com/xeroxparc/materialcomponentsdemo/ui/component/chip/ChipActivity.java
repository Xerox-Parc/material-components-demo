package com.xeroxparc.materialcomponentsdemo.ui.component.chip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityChipBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

public class ChipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {

        private ActivityChipBinding binding;


        Holder(Activity activity) {
            binding = ActivityChipBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.chip_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_chip);


            inflateSpanWebViewContent(binding, activity);

            this.binding.chipInput1.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_input1_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );
            this.binding.chipInput2.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_input2_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );

            this.binding.chipFilter1.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_filter1_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );
            this.binding.chipFilter2.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_filter2_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );
            this.binding.chipFilter3.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_filter3_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );

            this.binding.chipAction1.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_action1_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );
            this.binding.chipAction2.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_action2_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );

            this.binding.chipChoice1.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_choice1_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );
            this.binding.chipChoice2.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_choice2_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );
            this.binding.chipChoice3.setOnClickListener(l ->
                    Toast.makeText(
                            ChipActivity.this,
                            getString(R.string.chip_choice3_toast),
                            Toast.LENGTH_SHORT
                    ).show()
            );
        }


        View getRoot() {
            return binding.getRoot();
        }


    }
}
