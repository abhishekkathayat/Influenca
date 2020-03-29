package com.influence.influencerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.influence.influencerapp.R;

public class ProfileFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.profilescreen, container, false);
        return view;
    }
}
