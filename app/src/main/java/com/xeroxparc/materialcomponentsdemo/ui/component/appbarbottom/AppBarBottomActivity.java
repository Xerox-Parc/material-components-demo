package com.xeroxparc.materialcomponentsdemo.ui.component.appbarbottom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityAppBarBottomBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class AppBarBottomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }
    class Holder {
        private ActivityAppBarBottomBinding binding;
        Holder(Activity activity) {
            binding = ActivityAppBarBottomBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.app_bar_bottom_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_appbarbottom);
            inflateSpanTextViewContent(binding, activity);
            binding.bottomAppBar.setNavigationOnClickListener(v -> {
                finish();
            });
            binding.fab.setOnClickListener(l->{
                Toast.makeText(activity, "A floating action button (FAB) performs the primary," +
                        " or most common, action on a screen. It appears in front of all screen content," +
                        " typically as a circular shape with an icon in its center. FABs come in three types: " +
                        "regular, mini, and extended.", Toast.LENGTH_LONG).show();
            });
        }
        View getRoot() {
            return binding.getRoot();
        }
    }
}
