package com.xeroxparc.materialcomponentsdemo.ui.component.backdrop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityBackdropBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class BackdropActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityBackdropBinding binding;

        Holder(Activity activity) {
            binding = ActivityBackdropBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.backdrop_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_backdrop);
            inflateSpanTextViewContent(binding, activity);
        }

        View getRoot() {
            return binding.getRoot();
        }

    }
}
