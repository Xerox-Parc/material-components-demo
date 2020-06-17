package com.xeroxparc.materialcomponentsdemo.ui.component.banner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityBannerBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityBannerBinding binding;

        Holder(Activity activity) {
            binding = ActivityBannerBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.banner_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_banner);
            inflateSpanWebViewContent(binding, activity);
        }

        View getRoot() {
            return binding.getRoot();
        }
    }

}
