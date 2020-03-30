package com.influence.influencerapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.influence.influencerapp.R;
import com.influence.influencerapp.VideoDetailActivity;

public class ProfileFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.profilescreen, container, false);

        Button detailsbutton = view.findViewById(R.id.vddetail);
        detailsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
