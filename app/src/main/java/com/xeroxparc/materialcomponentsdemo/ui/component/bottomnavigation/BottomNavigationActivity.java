package com.xeroxparc.materialcomponentsdemo.ui.component.bottomnavigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        private ActivityBottomNavigationBinding binding;
        Holder(Activity activity) {
            binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.bottom_navigation_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_bottomnavigation);
            inflateSpanTextViewContent(binding, activity);
            binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        Toast.makeText(BottomNavigationActivity.this, "Page favorite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.page_2:
                        Toast.makeText(BottomNavigationActivity.this, "Page music", Toast.LENGTH_SHORT).show();
                        break ;
                    case R.id.page_3:
                        Toast.makeText(BottomNavigationActivity.this, "Page places", Toast.LENGTH_SHORT).show();
                        break ;
                    case R.id.page_4:
                        Toast.makeText(BottomNavigationActivity.this, "Page news", Toast.LENGTH_SHORT).show();
                        break ;
                }
                return true;
            });
        }
        View getRoot () {
                return binding.getRoot();
            }
        }
}
