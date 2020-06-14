package com.xeroxparc.materialcomponentsdemo.ui.component.datatable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityDataTableBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class DataTableActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }


    class Holder {


        private ActivityDataTableBinding binding;


        Holder(Activity activity) {
            binding = ActivityDataTableBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.data_table_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_datatable);


            inflateSpanTextViewContent(binding, activity);


        }


        View getRoot() {
            return binding.getRoot();
        }


    }
}
