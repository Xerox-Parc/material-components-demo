package com.xeroxparc.materialcomponentsdemo.ui.component.navigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.fragment.NavHostFragment;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityNavigationDrawerBinding;

import java.util.Objects;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class NavigationDrawerActivity extends AppCompatActivity {

    Holder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityNavigationDrawerBinding binding;

        Holder(Activity activity) {
            binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.navigation_drawer_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_navigationdrawer);

            inflateSpanTextViewContent(binding, activity);

            binding.navigationView.setNavigationItemSelectedListener(item -> {
                ((NavHostFragment) (Objects.requireNonNull(getSupportFragmentManager()
                        .findFragmentById(binding.navigationHostFragment.getId()))))
                        .getNavController()
                        .navigate(item.getItemId());
                item.setChecked(true);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            });
        }

        View getRoot() {
            return binding.getRoot();
        }

    }
}