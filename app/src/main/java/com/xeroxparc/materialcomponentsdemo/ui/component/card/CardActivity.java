package com.xeroxparc.materialcomponentsdemo.ui.component.card;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityCardBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class CardActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }


    class Holder {


        private ActivityCardBinding binding;


        Holder(Activity activity) {
            binding = ActivityCardBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(getString(R.string.card_title));
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_card);


            inflateSpanTextViewContent(binding, activity);

            this.binding.cardSampleButton1.setOnClickListener(l -> Toast.makeText(
                    CardActivity.this,
                    getString(R.string.card_sample_clicked_button1),
                    Toast.LENGTH_LONG
            ).show());
            this.binding.cardSampleButton2.setOnClickListener(l -> Toast.makeText(
                    CardActivity.this,
                    getString(R.string.card_sample_clicked_button2),
                    Toast.LENGTH_LONG
            ).show());
        }


        View getRoot() {
            return binding.getRoot();
        }
    }
}
