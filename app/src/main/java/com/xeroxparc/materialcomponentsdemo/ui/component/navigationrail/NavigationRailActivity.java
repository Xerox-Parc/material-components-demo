package com.xeroxparc.materialcomponentsdemo.ui.component.navigationrail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityNavigationRailBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

public class NavigationRailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityNavigationRailBinding binding;

        Holder(Activity activity) {
            binding = ActivityNavigationRailBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.navigation_rail_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_navigationrail);

            inflateSpanWebViewContent(binding, activity);
        }

        View getRoot() {
            return binding.getRoot();
        }



    }
}
