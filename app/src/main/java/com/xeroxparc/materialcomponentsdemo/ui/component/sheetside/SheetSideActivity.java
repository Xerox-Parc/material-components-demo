package com.xeroxparc.materialcomponentsdemo.ui.component.sheetside;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivitySheetSideBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class SheetSideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {

        private ActivitySheetSideBinding binding;

        Holder(Activity activity) {
            binding = ActivitySheetSideBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.sheet_side_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_sheetside);

            inflateSpanTextViewContent(binding, activity);


        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}
