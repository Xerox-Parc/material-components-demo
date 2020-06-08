package com.xeroxparc.materialcomponentsdemo.ui.component.fab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityFabBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class FabActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }


    class Holder {


        private ActivityFabBinding binding;


        Holder(Activity activity) {
            binding = ActivityFabBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.fab_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_fab);


            inflateSpanTextViewContent(binding, activity);

            if(this.binding.extendedFab.isExtended()) {
                this.binding.extendedFab.shrink();
            }

            this.binding.extendedFab.setOnClickListener(l -> {
                if(this.binding.extendedFab.isExtended())
                {
                    this.binding.extendedFab.shrink();
                }
                else{
                    this.binding.extendedFab.extend();
                }
            });
        }


        View getRoot() {
            return binding.getRoot();
        }
    }
}
