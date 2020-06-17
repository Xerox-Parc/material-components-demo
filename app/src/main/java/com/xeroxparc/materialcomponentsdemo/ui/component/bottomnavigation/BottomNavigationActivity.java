package com.xeroxparc.materialcomponentsdemo.ui.component.bottomnavigation;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityBottomNavigationBinding;

import java.util.Objects;


public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder();
        setContentView(holder.getRoot());
    }

    class Holder {
        ActivityBottomNavigationBinding binding;

        Holder() {
            binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.bottom_navigation_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_bottomnavigation);

            binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
                ((NavHostFragment) (Objects.requireNonNull(getSupportFragmentManager()
                        .findFragmentById(binding.navigationHostFragment.getId()))))
                        .getNavController()
                        .navigate(item.getItemId());
                item.setChecked(true);
                return true;
            });
        }

        View getRoot() {
            return binding.getRoot();
        }
    }

}
