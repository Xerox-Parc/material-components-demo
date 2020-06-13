package com.xeroxparc.materialcomponentsdemo.ui.component.sheetbottom;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivitySheetBottomBinding;
import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;
public class SheetBottomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {

        private ActivitySheetBottomBinding binding;

        Holder(Activity activity) {
            binding = ActivitySheetBottomBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.sheet_bottom_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_sheetbottom);
            inflateSpanTextViewContent(binding, activity);
            
            binding.sheetBottomVisible.sheetBottomShareLayout.setOnClickListener(l -> Toast.makeText(
                    getBaseContext(),
                    binding.sheetBottomVisible.sheetBottomTextAddToFavourites.getText(),
                    Toast.LENGTH_SHORT).show());
            binding.sheetBottomVisible.sheetBottomSaveLayout.setOnClickListener(l -> Toast.makeText(
                    getBaseContext(),
                    binding.sheetBottomVisible.sheetBottomTextSave.getText(),
                    Toast.LENGTH_SHORT).show());
            binding.sheetBottomVisible.sheetBottomUploadLayout.setOnClickListener(l -> Toast.makeText(
                    getBaseContext(),
                    binding.sheetBottomVisible.sheetBottomTextUploadToDrive.getText(),
                    Toast.LENGTH_SHORT).show());
        }
        View getRoot() {

            return binding.getRoot();
        }
    }

}