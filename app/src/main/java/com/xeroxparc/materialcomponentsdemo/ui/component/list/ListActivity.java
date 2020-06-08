package com.xeroxparc.materialcomponentsdemo.ui.component.list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xeroxparc.materialcomponentsdemo.R;
import com.xeroxparc.materialcomponentsdemo.databinding.ActivityListBinding;

import java.util.Collections;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Holder holder = new Holder(this);
        setContentView(holder.getRoot());
    }

    class Holder {
        private ActivityListBinding binding;

        Holder(Activity activity) {
            binding = ActivityListBinding.inflate(getLayoutInflater());
            binding.appBarContainer.toolbar.setTitle(R.string.list_title);
            binding.appBarContainer.imageViewBanner.setImageResource(R.drawable.banner_list);

            inflateSpanTextViewContent(binding, activity);


            RecyclerView rvSingleLineList = binding.listViewSingleLineList;
            RecyclerView rvTwoLineList = binding.listViewTwoLineList;
            RecyclerView rvThreeLineList = binding.listViewThreeLineList;

            RecyclerView rvCheckboxList = binding.listViewCheckboxList;
            RecyclerView rvSwitchList = binding.listViewSwitchList;
            RecyclerView rvReorderList = binding.listViewReorderList;

            rvSingleLineList.setHasFixedSize(true);
            rvTwoLineList.setHasFixedSize(true);
            rvThreeLineList.setHasFixedSize(true);

            rvCheckboxList.setHasFixedSize(true);
            rvSwitchList.setHasFixedSize(true);
            rvReorderList.setHasFixedSize(true);

            RecyclerView.LayoutManager singleLineListLayoutManager = new LinearLayoutManager(getApplicationContext());
            RecyclerView.LayoutManager twoLineListLayoutManager = new LinearLayoutManager(getApplicationContext());
            RecyclerView.LayoutManager threeLineListLayoutManager = new LinearLayoutManager(getApplicationContext());

            RecyclerView.LayoutManager checkboxListLayoutManager = new LinearLayoutManager(getApplicationContext());
            RecyclerView.LayoutManager switchListLayoutManager = new LinearLayoutManager(getApplicationContext());
            RecyclerView.LayoutManager reorderListLayoutManager = new LinearLayoutManager(getApplicationContext());

            rvSingleLineList.setLayoutManager(singleLineListLayoutManager);
            rvTwoLineList.setLayoutManager(twoLineListLayoutManager);
            rvThreeLineList.setLayoutManager(threeLineListLayoutManager);

            rvCheckboxList.setLayoutManager(checkboxListLayoutManager);
            rvSwitchList.setLayoutManager(switchListLayoutManager);
            rvReorderList.setLayoutManager(reorderListLayoutManager);

            String[] listFirstLineOptions = new String[] {
                    getString(R.string.list_first_line_option_1),
                    getString(R.string.list_first_line_option_2),
                    getString(R.string.list_first_line_option_3),
                    getString(R.string.list_first_line_option_4)
            };

            String[] listSecondLineOptions = new String[] {
                    getString(R.string.list_second_line_option_1),
                    getString(R.string.list_second_line_option_2),
                    getString(R.string.list_second_line_option_3),
                    getString(R.string.list_second_line_option_4)
            };

            String[] listThirdLineOptions = new String[] {
                    getString(R.string.list_third_line_option_1),
                    getString(R.string.list_third_line_option_2),
                    getString(R.string.list_third_line_option_3),
                    getString(R.string.list_third_line_option_4)
            };

            int[] listImageOptions = new int[] {
                    R.drawable.ic_looks_one_24dp,
                    R.drawable.ic_looks_two_24dp,
                    R.drawable.ic_looks_three_24dp,
                    R.drawable.ic_looks_four_24dp
            };

            RecyclerView.Adapter mSingleLineListAdapter = new SingleLineListAdapter(listFirstLineOptions, listImageOptions);
            RecyclerView.Adapter mTwoLineListAdapter = new TwoLineListAdapter(listFirstLineOptions, listSecondLineOptions, listImageOptions);
            RecyclerView.Adapter mThreeLineListAdapter = new ThreeLineListAdapter(listFirstLineOptions, listSecondLineOptions, listThirdLineOptions, listImageOptions);

            RecyclerView.Adapter mCheckboxListAdapter = new CheckboxListAdapter(listFirstLineOptions, listImageOptions);
            RecyclerView.Adapter mSwitchListAdapter = new SwitchListAdapter(listFirstLineOptions, listImageOptions);
            RecyclerView.Adapter mReorderListAdapter = new ReorderListAdapter(listFirstLineOptions, listImageOptions);

            rvSingleLineList.setAdapter(mSingleLineListAdapter);
            rvTwoLineList.setAdapter(mTwoLineListAdapter);
            rvThreeLineList.setAdapter(mThreeLineListAdapter);

            rvCheckboxList.setAdapter(mCheckboxListAdapter);
            rvSwitchList.setAdapter(mSwitchListAdapter);
            rvReorderList.setAdapter(mReorderListAdapter);


            ItemTouchHelper.Callback callback = new ItemMoveCallback(mReorderListAdapter);
            ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
            touchHelper.attachToRecyclerView(binding.listViewReorderList);
        }

        public class ItemMoveCallback extends ItemTouchHelper.Callback {

            private final ReorderListAdapter mAdapter;

            public ItemMoveCallback(RecyclerView.Adapter adapter) {
                mAdapter = (ReorderListAdapter) adapter;
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                return makeMovementFlags(dragFlags, 0);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                mAdapter.onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
            }

            @Override
            public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
            }
        }

        public class SingleLineListAdapter extends RecyclerView.Adapter<SingleLineListAdapter.SingleLineListViewHolder>{
            private String[] listFirstLineOptions;
            private int[] listImageOptions;

            class SingleLineListViewHolder extends RecyclerView.ViewHolder {
                TextView singleLineListText;
                ImageView singleLineListIcon;

                SingleLineListViewHolder(ConstraintLayout cL) {
                    super(cL);
                    singleLineListIcon = cL.findViewById(R.id.single_line_list_item_icon);
                    singleLineListText = cL.findViewById(R.id.single_line_list_item_text);
                }
            }

            SingleLineListAdapter(String[] listFirstLineOptions, int[] listImageOptions){
                this.listFirstLineOptions = listFirstLineOptions;
                this.listImageOptions = listImageOptions;
            }

            @NonNull
            @Override
            public SingleLineListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ConstraintLayout constraintLayout;

                constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_line_item, parent, false);
                return new SingleLineListViewHolder(constraintLayout);
            }

            @Override
            public void onBindViewHolder(@NonNull SingleLineListViewHolder holder, int position) {
                holder.singleLineListText.setText(listFirstLineOptions[position]);
                holder.singleLineListIcon.setImageResource(listImageOptions[position]);
            }

            @Override
            public int getItemCount() {
                return listFirstLineOptions.length;
            }
        }

        public class TwoLineListAdapter extends RecyclerView.Adapter<TwoLineListAdapter.TwoLineListViewHolder>{
            private String[] listFirstLineOptions;
            private String[] listSecondLineOptions;
            private int[] listImageOptions;

            class TwoLineListViewHolder extends RecyclerView.ViewHolder {
                TextView twoLineListText;
                TextView twoLineListSecondaryText;
                ImageView twoLineListIcon;

                TwoLineListViewHolder(ConstraintLayout cL) {
                    super(cL);
                    twoLineListIcon = cL.findViewById(R.id.two_line_list_item_icon);
                    twoLineListText = cL.findViewById(R.id.two_line_list_item_text);
                    twoLineListSecondaryText = cL.findViewById(R.id.two_line_list_item_secondary_text);
                }
            }

            TwoLineListAdapter(String[] listFirstLineOptions, String[] listSecondLineOptions, int[] listImageOptions){
                this.listFirstLineOptions = listFirstLineOptions;
                this.listSecondLineOptions = listSecondLineOptions;
                this.listImageOptions = listImageOptions;
            }

            @NonNull
            @Override
            public TwoLineListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ConstraintLayout constraintLayout;

                constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_two_line_item, parent, false);
                return new TwoLineListViewHolder(constraintLayout);
            }

            @Override
            public void onBindViewHolder(@NonNull TwoLineListViewHolder holder, int position) {
                holder.twoLineListText.setText(listFirstLineOptions[position]);
                holder.twoLineListSecondaryText.setText(listSecondLineOptions[position]);
                holder.twoLineListIcon.setImageResource(listImageOptions[position]);
            }

            @Override
            public int getItemCount() {
                return listFirstLineOptions.length;
            }
        }

        public class ThreeLineListAdapter extends RecyclerView.Adapter<ThreeLineListAdapter.ThreeLineListViewHolder>{
            private String[] listFirstLineOptions;
            private String[] listSecondLineOptions;
            private String[] listThirdLineOptions;
            private int[] listImageOptions;

            class ThreeLineListViewHolder extends RecyclerView.ViewHolder {
                TextView threeLineListText;
                TextView threeLineListSecondaryText;
                TextView threeLineListTertiaryText;
                ImageView threeLineListIcon;

                ThreeLineListViewHolder(ConstraintLayout cL) {
                    super(cL);
                    threeLineListIcon = cL.findViewById(R.id.three_line_list_item_icon);
                    threeLineListText = cL.findViewById(R.id.three_line_list_text);
                    threeLineListSecondaryText = cL.findViewById(R.id.three_line_list_item_secondary_text);
                    threeLineListTertiaryText = cL.findViewById(R.id.three_line_list_item_tertiary_text);
                }
            }

            ThreeLineListAdapter(String[] listFirstLineOptions, String[] listSecondLineOptions, String[] listThirdLineOptions, int[] listImageOptions){
                this.listFirstLineOptions = listFirstLineOptions;
                this.listSecondLineOptions = listSecondLineOptions;
                this.listThirdLineOptions = listThirdLineOptions;
                this.listImageOptions = listImageOptions;
            }

            @NonNull
            @Override
            public ThreeLineListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ConstraintLayout constraintLayout;

                constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_three_line_item, parent, false);
                return new ThreeLineListViewHolder(constraintLayout);
            }

            @Override
            public void onBindViewHolder(@NonNull ThreeLineListViewHolder holder, int position) {
                holder.threeLineListText.setText(listFirstLineOptions[position]);
                holder.threeLineListSecondaryText.setText(listSecondLineOptions[position]);
                holder.threeLineListTertiaryText.setText(listThirdLineOptions[position]);
                holder.threeLineListIcon.setImageResource(listImageOptions[position]);
            }

            @Override
            public int getItemCount() {
                return listFirstLineOptions.length;
            }
        }

        public class CheckboxListAdapter extends RecyclerView.Adapter<CheckboxListAdapter.CheckboxListViewHolder>{
            private String[] listFirstLineOptions;
            private int[] listImageOptions;

            class CheckboxListViewHolder extends RecyclerView.ViewHolder {
                TextView checkboxListText;
                ImageView checkboxListIcon;

                CheckboxListViewHolder(ConstraintLayout cL) {
                    super(cL);
                    checkboxListIcon = cL.findViewById(R.id.checkbox_list_item_icon);
                    checkboxListText = cL.findViewById(R.id.checkbox_list_item_text);
                }
            }

            CheckboxListAdapter(String[] listFirstLineOptions, int[] listImageOptions){
                this.listFirstLineOptions = listFirstLineOptions;
                this.listImageOptions = listImageOptions;
            }

            @NonNull
            @Override
            public CheckboxListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ConstraintLayout constraintLayout;

                constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_checkbox_item, parent, false);
                return new CheckboxListViewHolder(constraintLayout);
            }

            @Override
            public void onBindViewHolder(@NonNull CheckboxListViewHolder holder, int position) {
                holder.checkboxListText.setText(listFirstLineOptions[position]);
                holder.checkboxListIcon.setImageResource(listImageOptions[position]);
            }

            @Override
            public int getItemCount() {
                return listFirstLineOptions.length;
            }
        }

        public class SwitchListAdapter extends RecyclerView.Adapter<SwitchListAdapter.SwitchListViewHolder>{
            private String[] listFirstLineOptions;
            private int[] listImageOptions;

            class SwitchListViewHolder extends RecyclerView.ViewHolder {
                TextView switchListText;
                ImageView switchListIcon;

                SwitchListViewHolder(ConstraintLayout cL) {
                    super(cL);
                    switchListIcon = cL.findViewById(R.id.switch_list_item_icon);
                    switchListText = cL.findViewById(R.id.switch_list_item_text);
                }
            }

            SwitchListAdapter(String[] listFirstLineOptions, int[] listImageOptions){
                this.listFirstLineOptions = listFirstLineOptions;
                this.listImageOptions = listImageOptions;
            }

            @NonNull
            @Override
            public SwitchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ConstraintLayout constraintLayout;

                constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_switch_item, parent, false);
                return new SwitchListViewHolder(constraintLayout);
            }

            @Override
            public void onBindViewHolder(@NonNull SwitchListViewHolder holder, int position) {
                holder.switchListText.setText(listFirstLineOptions[position]);
                holder.switchListIcon.setImageResource(listImageOptions[position]);
            }

            @Override
            public int getItemCount() {
                return listFirstLineOptions.length;
            }
        }

        public class ReorderListAdapter extends RecyclerView.Adapter<ReorderListAdapter.ReorderListViewHolder>{
            private String[] listFirstLineOptions;
            private int[] listImageOptions;

            class ReorderListViewHolder extends RecyclerView.ViewHolder {
                TextView reorderListText;
                ImageView reorderListIcon;

                ReorderListViewHolder(ConstraintLayout cL) {
                    super(cL);
                    reorderListIcon = cL.findViewById(R.id.reorder_list_item_icon);
                    reorderListText = cL.findViewById(R.id.reorder_list_item_text);
                }
            }

            ReorderListAdapter(String[] listFirstLineOptions, int[] listImageOptions){
                this.listFirstLineOptions = listFirstLineOptions;
                this.listImageOptions = listImageOptions;
            }

            @NonNull
            @Override
            public ReorderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ConstraintLayout constraintLayout;

                constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_reorder_item, parent, false);
                return new ReorderListViewHolder(constraintLayout);
            }

            @Override
            public void onBindViewHolder(@NonNull ReorderListViewHolder holder, int position) {
                holder.reorderListText.setText(listFirstLineOptions[position]);
                holder.reorderListIcon.setImageResource(listImageOptions[position]);
            }

            @Override
            public int getItemCount() {
                return listFirstLineOptions.length;
            }

            public void onItemMoved(int fromPosition, int toPosition) {

                String tempString = listFirstLineOptions[fromPosition];
                int tempIcon = listImageOptions[fromPosition];

                listFirstLineOptions[fromPosition] = listFirstLineOptions[toPosition];
                listImageOptions[fromPosition] = listImageOptions[toPosition];

                listFirstLineOptions[toPosition] = tempString;
                listImageOptions[toPosition] = tempIcon;

                notifyItemMoved(fromPosition, toPosition);
            }
        }

        View getRoot() {
            return binding.getRoot();
        }
    }
}
