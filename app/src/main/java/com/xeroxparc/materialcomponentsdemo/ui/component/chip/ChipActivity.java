package com.xeroxparc.materialcomponentsdemo.ui.component.chip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityChipBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

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


            inflateSpanTextViewContent(binding, activity);


            //TODO
        }


        View getRoot() {
            return binding.getRoot();
        }


    }
}
