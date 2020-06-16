package com.xeroxparc.materialcomponentsdemo.ui.component.bottomnavigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xeroxparc.materialcomponentsdemo.databinding.FragmentBottomNavigationPlacesBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanTextViewContent;

import java.util.Objects;

public class BottomNavigationPlacesFragment extends Fragment {
    private FragmentBottomNavigationPlacesBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        binding = FragmentBottomNavigationPlacesBinding.inflate(inflater, container, false);
        inflateSpanTextViewContent(binding, Objects.requireNonNull(getActivity()));
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}