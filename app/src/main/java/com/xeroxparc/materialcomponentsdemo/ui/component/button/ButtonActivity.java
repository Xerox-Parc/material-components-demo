package com.xeroxparc.materialcomponentsdemo.ui.component.button;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityButtonBinding;
import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class ButtonActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }
    class Holder implements View.OnClickListener {
        private ActivityButtonBinding binding;

        Holder(Activity activity) {
            binding = ActivityButtonBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.button_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_button);
            inflateSpanTextViewContent(binding, activity);
            //TODO
            binding.textButton.setOnClickListener(this);
            binding.containedButton.setOnClickListener(this);
            binding.outlinedButton.setOnClickListener(this);
        }
        View getRoot() {
            return binding.getRoot();
        }
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.outlinedButton) {
                Toast.makeText(getApplicationContext(), "Have press outlined button", Toast.LENGTH_LONG).show();
            }
            if (v.getId() == R.id.textButton) {
                Toast.makeText(getApplicationContext(), "Have press text buttons", Toast.LENGTH_LONG).show();
            }
            if (v.getId() == R.id.containedButton) {
                Toast.makeText(getApplicationContext(), "Have press contained button", Toast.LENGTH_LONG).show();
            }
        }
    }
}
