package com.xeroxparc.materialcomponentsdemo.ui.component.picker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import com.xeroxparc.materialcomponentsdemo.R;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

import com.google.android.material.datepicker.MaterialDatePicker;

import com.xeroxparc.materialcomponentsdemo.databinding.ActivityPickerBinding;

public class PickerActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder implements View.OnClickListener {
        private ActivityPickerBinding binding;

        Holder(Activity activity) {
            binding = ActivityPickerBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.picker_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_picker);

            inflateSpanWebViewContent(binding, activity);

            binding.buttonMobileDateRangePickerButton.setOnClickListener(this);
            binding.buttonMobileCalendarPicker.setOnClickListener(this);
        }

        View getRoot() {
            return binding.getRoot();
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button_mobile_date_range_picker_button) {
                MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
                builder.setTitleText(R.string.picker_date_range_picker);
                try {
                    final MaterialDatePicker<androidx.core.util.Pair<Long, Long>> materialDatePicker = builder.build();
                    materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
                } catch (IllegalArgumentException e){
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.picker_launch_failure,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
            if (v.getId() == R.id.button_mobile_calendar_picker){
                MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
                builder.setTitleText(R.string.picker_calendar_picker);
                builder.setSelection(MaterialDatePicker.todayInUtcMilliseconds());
                try {
                    final MaterialDatePicker<Long> materialDatePicker = builder.build();
                    materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
                } catch (IllegalArgumentException e){
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.picker_launch_failure,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        }
    }
}