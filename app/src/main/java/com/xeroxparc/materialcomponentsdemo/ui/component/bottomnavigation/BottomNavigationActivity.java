package com.xeroxparc.materialcomponentsdemo.ui.component.bottomnavigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityBottomNavigationBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;


public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }
    class Holder {
        ActivityBottomNavigationBinding binding;
        Holder(Activity activity) {
            binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.bottom_navigation_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_bottomnavigation);
            inflateSpanTextViewContent(binding, activity);
            binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.page_favorite:
                        Toast.makeText(BottomNavigationActivity.this, R.string.bottom_navigation_span_page_home, Toast.LENGTH_SHORT).show();
                        selectedFragment = new Fragment();
                        break;
                    case R.id.page_music:
                        Toast.makeText(BottomNavigationActivity.this, R.string.bottom_navigation_span_page_music, Toast.LENGTH_SHORT).show();
                        selectedFragment = new BottomNavigationFragmentMusic();
                        break ;
                    case R.id.page_places:
                        Toast.makeText(BottomNavigationActivity.this, R.string.bottom_navigation_span_page_places, Toast.LENGTH_SHORT).show();
                        selectedFragment = new BottomNavigationFragmentPlaces();
                        break ;
                    case R.id.page_news:
                        Toast.makeText(BottomNavigationActivity.this, R.string.bottom_navigation_span_page_news, Toast.LENGTH_SHORT).show();
                        selectedFragment = new BottomNavigationFragmentNews();
                        break ;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
                return true;
            });
        }
        View getRoot () {
                return binding.getRoot();
            }
        }
}
