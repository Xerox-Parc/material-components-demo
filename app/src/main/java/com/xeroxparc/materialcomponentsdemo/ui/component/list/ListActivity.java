package com.xeroxparc.materialcomponentsdemo.ui.component.list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityListBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityListBinding binding;

        Holder(Activity activity) {
            binding = ActivityListBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.list_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_list);

            inflateSpanTextViewContent(binding, activity);
        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}