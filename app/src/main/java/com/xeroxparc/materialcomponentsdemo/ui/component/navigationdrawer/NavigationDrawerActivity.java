package com.xeroxparc.materialcomponentsdemo.ui.component.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityNavigationDrawerBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class NavigationDrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityNavigationDrawerBinding binding;

        Holder(Activity activity) {
            binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.navigation_drawer_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_navigationdrawer);

            inflateSpanTextViewContent(binding, activity);
        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}