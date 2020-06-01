package com.xeroxparc.materialcomponentsdemo.ui.component.appbartop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityAppBarTopBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

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
            inflateSpanTextViewContent(binding, activity);
            binding.topAppBar.setOnMenuItemClickListener(l-> {
                if(l.getItemId()==R.id.blocked){
                    Toast.makeText(getApplicationContext(),"You have press blocked",Toast.LENGTH_SHORT).show();
                }
                if(l.getItemId()==R.id.notblocked){
                    Toast.makeText(getApplicationContext(),"You have press not blocked",Toast.LENGTH_SHORT).show();
                }
                if(l.getItemId()==R.id.position){
                    Toast.makeText(getApplicationContext(),"You have press position bottom",Toast.LENGTH_SHORT).show();
                }
                if(l.getItemId()==R.id.search){
                    Toast.makeText(getApplicationContext(),"You have press search bottom",Toast.LENGTH_SHORT).show();
                }
                return false;
            });
        }
        View getRoot() {
            return binding.getRoot();
        }
    }
}
