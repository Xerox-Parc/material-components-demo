package com.xeroxparc.materialcomponentsdemo.ui.component.banner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityBannerBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

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
            binding.appBarContainer.toolbar.setTitle(R.string.banner_title);
            binding = ActivityBannerBinding.inflate(getLayoutInflater());
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_banner);
            inflateSpanTextViewContent(binding, activity);
            //TODO
        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}
