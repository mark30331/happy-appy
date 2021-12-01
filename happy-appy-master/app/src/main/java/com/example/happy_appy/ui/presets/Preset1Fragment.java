package com.example.happy_appy.ui.presets;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happy_appy.R;

public class Preset1Fragment extends Fragment {

    private Preset1ViewModel mViewModel;

    public static Preset1Fragment newInstance() {
        return new Preset1Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.preset1_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Preset1ViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.onCreate();
    }

}
