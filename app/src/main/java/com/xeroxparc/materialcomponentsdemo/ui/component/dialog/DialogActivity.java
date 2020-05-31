package com.xeroxparc.materialcomponentsdemo.ui.component.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityDialogBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class DialogActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }


    class Holder {


        private ActivityDialogBinding binding;


        Holder(Activity activity) {
            binding = ActivityDialogBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.dialog_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_dialog);


            inflateSpanTextViewContent(binding, activity);


            //TODO
        }


        View getRoot() {
            return binding.getRoot();
        }
    }
}
