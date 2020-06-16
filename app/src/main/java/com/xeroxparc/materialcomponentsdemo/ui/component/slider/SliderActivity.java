package com.xeroxparc.materialcomponentsdemo.ui.component.slider;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivitySliderBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

public class SliderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {

        private ActivitySliderBinding binding;

        Holder(Activity activity) {
            binding = ActivitySliderBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.slider_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_slider);

            inflateSpanWebViewContent(binding, activity);

        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}