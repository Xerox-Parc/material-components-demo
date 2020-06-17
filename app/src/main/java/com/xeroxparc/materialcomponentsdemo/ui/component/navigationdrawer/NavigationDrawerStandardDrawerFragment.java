package com.xeroxparc.materialcomponentsdemo.ui.component.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xeroxparc.materialcomponentsdemo.databinding.FragmentNavigationDrawerStandardDrawerBinding;

import static com.xeroxparc.materialcomponentsdemo.utils.Utils.inflateSpanWebViewContent;

public class NavigationDrawerStandardDrawerFragment extends Fragment {
    private FragmentNavigationDrawerStandardDrawerBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        binding = FragmentNavigationDrawerStandardDrawerBinding.inflate(inflater, container, false);
        inflateSpanWebViewContent(binding, requireActivity());
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}