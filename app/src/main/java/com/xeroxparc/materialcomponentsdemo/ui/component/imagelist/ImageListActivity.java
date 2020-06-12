package com.xeroxparc.materialcomponentsdemo.ui.component.imagelist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityImageListBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class ImageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityImageListBinding binding;

        Holder(Activity activity) {
            binding = ActivityImageListBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.image_list_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_imagelist);

            inflateSpanTextViewContent(binding, activity);
        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}