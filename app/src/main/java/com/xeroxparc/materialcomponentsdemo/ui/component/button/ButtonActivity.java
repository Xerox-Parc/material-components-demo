package com.xeroxparc.materialcomponentsdemo.ui.component.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
            binding.textButton.setOnClickListener(this);
            binding.containedButton.setOnClickListener(this);
            binding.outlinedButton.setOnClickListener(this);
        }
        View getRoot() {
            return binding.getRoot();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.outlinedButton:
                    Toast.makeText(getApplicationContext(), R.string.button_have_press_outlined_button, Toast.LENGTH_LONG).show();
                    break;
                case R.id.textButton:
                Toast.makeText(getApplicationContext(), R.string.button_have_press_text_button, Toast.LENGTH_LONG).show();
                    break;
                case R.id.containedButton:
                Toast.makeText(getApplicationContext(), R.string.button_have_press_contained_button, Toast.LENGTH_LONG).show();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());

            }
        }
    }
}
