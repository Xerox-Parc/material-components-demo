package com.xeroxparc.materialcomponentsdemo.ui.component.picker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;

import com.xeroxparc.materialcomponentsdemo.R;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

import com.google.android.material.datepicker.MaterialDatePicker;

import com.xeroxparc.materialcomponentsdemo.databinding.ActivityPickerBinding;

import java.util.Calendar;
import java.util.TimeZone;

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

            inflateSpanTextViewContent(binding, activity);

            binding.btnMobileDateRangePickerButton.setOnClickListener(this);
            binding.btnMobileCalendarPicker.setOnClickListener(this);
        }

        View getRoot() {
            return binding.getRoot();
        }

        @Override
        public void onClick(View v) {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
            calendar.clear();
            if (v.getId() == R.id.btn_mobile_date_range_picker_button) {
                MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();
                builder.setTitleText(R.string.date_range_picker);
                final MaterialDatePicker materialDatePicker = builder.build();
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
            if (v.getId() == R.id.btn_mobile_calendar_picker){
                MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
                builder.setTitleText(R.string.calendar_picker);
                final MaterialDatePicker materialDatePicker = builder.build();
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        }
    }
}