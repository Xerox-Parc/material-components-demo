package com.xeroxparc.materialcomponentsdemo.ui.component.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityMenuBinding;
import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_overflow_menu, menu);
        return true;
    }

    // popup menu inflater
    public void showPopupMenu(View anchor) {
        PopupMenu popup = new PopupMenu(this, anchor);
        popup.getMenuInflater().inflate(R.menu.menu_dropdown_menu, popup.getMenu());
        popup.show();
    }

    class Holder {

        private ActivityMenuBinding binding;

        Holder(Activity activity) {
            binding = ActivityMenuBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.menu_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_menu);
            inflateSpanTextViewContent(binding, activity);

            binding.appBarContainer.toolbar.inflateMenu(R.menu.menu_overflow_menu);
            new Adapter();
        }

        View getRoot() {
            return binding.getRoot();
        }

        // exposed menu adapter
        class Adapter {

            Adapter(){
                String[] exposedDropdownMenuOptions = new String[] {
                        getString(R.string.menu_headset),
                        getString(R.string.menu_star),
                        getString(R.string.menu_music_note),
                        getString(R.string.menu_info)
                };

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getApplicationContext(),
                        R.layout.menu_exposed_menu_item,
                        exposedDropdownMenuOptions
                );

                binding.filledExposedDropdown.setAdapter(adapter);
            }
        }

    }
}