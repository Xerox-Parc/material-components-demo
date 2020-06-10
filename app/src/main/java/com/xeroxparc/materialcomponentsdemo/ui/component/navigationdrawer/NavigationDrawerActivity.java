package com.xeroxparc.materialcomponentsdemo.ui.component.navigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationView;
import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityNavigationDrawerBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
        init();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.navigation_home:{
                Navigation.findNavController(this, R.id.navigation_host_fragment).navigate(R.id.navigation_home);
                break;
            }
            case R.id.navigation_standard_drawer:{
                Navigation.findNavController(this, R.id.navigation_host_fragment).navigate(R.id.navigation_standard_drawer);
                break;
            }
            case R.id.navigation_bottom_drawer:{
                Navigation.findNavController(this, R.id.navigation_host_fragment).navigate(R.id.navigation_bottom_drawer);
                break;
            }
        }

        item.setChecked(true);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void init(){
        NavigationView navigationView = findViewById(R.id.navigation_drawer_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
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