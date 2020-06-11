package com.xeroxparc.materialcomponentsdemo.ui.component.divider;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityDividerBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;


public class DividerActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }


    class Holder {


        private ActivityDividerBinding binding;


        Holder(Activity activity) {
            binding = ActivityDividerBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.divider_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_divider);


            inflateSpanTextViewContent(binding, activity);

        }


        View getRoot() {
            return binding.getRoot();
        }


    }
}