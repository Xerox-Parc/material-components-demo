package com.xeroxparc.materialcomponentsdemo.ui.component.appbartop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityAppBarTopBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

public class AppBarTopActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }
    class Holder {
        private ActivityAppBarTopBinding binding;
        Holder(Activity activity) {
            binding = ActivityAppBarTopBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.app_bar_top_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_appbartop);
            inflateSpanWebViewContent(binding, activity);
        }
        View getRoot() {
            return binding.getRoot();
        }
    }
}
