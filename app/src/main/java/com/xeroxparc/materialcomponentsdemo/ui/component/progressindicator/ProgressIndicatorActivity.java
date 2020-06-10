package com.xeroxparc.materialcomponentsdemo.ui.component.progressindicator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityProgressIndicatorBinding;

import java.util.Timer;
import java.util.TimerTask;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class ProgressIndicatorActivity extends AppCompatActivity {
    Timer timer;
    Handler handler;
    Runnable runnableCircular;
    Runnable runnableLinear;
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

            inflateSpanTextViewContent(binding, activity);
            binding.buttonCircular.setOnClickListener(l ->
                    binding.progressIndicatorCircular.setVisibility(View.VISIBLE));
            binding.buttonLinear.setOnClickListener(l ->
                    binding.progressIndicatorLinear.setVisibility(View.VISIBLE));
            handler= new Handler();
            runnableCircular = () -> binding.progressIndicatorCircular.setVisibility(View.GONE);
            runnableLinear = () -> binding.progressIndicatorLinear.setVisibility(View.GONE);
            timer = new Timer();
            timer.schedule(new TimerTask(){

                @Override
                public void run() {
                        handler.post(runnableCircular);
                        handler.post(runnableLinear);
                }
            },1000,10000);
        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}