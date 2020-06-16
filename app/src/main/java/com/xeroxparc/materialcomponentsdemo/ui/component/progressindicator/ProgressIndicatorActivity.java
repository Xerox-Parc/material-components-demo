package com.xeroxparc.materialcomponentsdemo.ui.component.progressindicator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityProgressIndicatorBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

public class ProgressIndicatorActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Holder holder = new Holder(this);
            setContentView(holder.getRoot());
        }

        class Holder {
            private ActivityProgressIndicatorBinding binding;

            Holder(Activity activity) {
                binding = ActivityProgressIndicatorBinding.inflate(getLayoutInflater());
                binding.appBarContainer.toolbar.setTitle(R.string.progress_indicator_title);
                binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_progressindicator);

                inflateSpanWebViewContent(binding, activity);
            }

            View getRoot() {
                return binding.getRoot();
            }

        }
}