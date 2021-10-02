package com.influence.influencerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.influence.influencerapp.Adapters.ImageDetailAdapter;
import com.influence.influencerapp.Models.ImageModel;
import com.influence.influencerapp.R;

import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends Fragment {

    private RecyclerView recyclerView;
    private ImageDetailAdapter imageDetailAdapter;
    private List<ImageModel> images = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.imageScreen, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_1);
        imageDetailAdapter = new ImageDetailAdapter(images);
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(imageAdapter);
        imagesData();

        return view;
    }

    private void imagesData() {
        ImageModel imageModel = new ImageModel("Video One", "https://i.stack.imgur.com/h6viz.jpg", 230, "Accepted", 345, 23, 6, 2014);
        images.add(imageModel);
        imageModel = new ImageModel("Video Two", "https://i.stack.imgur.com/h6viz.jpg", 0, "Declined", 0, 8, 5, 2019);
        images.add(imageModel);
        imageModel = new ImageModel("Video Three", "https://i.stack.imgur.com/h6viz.jpg", 3467, "Accepted",  3123, 11, 4, 2016);
        images.add(imageModel);
        imageModel = new ImageModel("Video Four", "https://i.stack.imgur.com/h6viz.jpg", 0, "Declined", 0, 16, 9, 2011);
        images.add(imageModel);
        imageModel = new ImageModel("Video Five", "https://i.stack.imgur.com/h6viz.jpg", 126, "Accepted", 542, 31, 1, 2017);
        images.add(imageModel);
        imageModel = new ImageModel("Video Six", "https://i.stack.imgur.com/h6viz.jpg", 3467, "Accepted", 876, 22, 8, 2010);
        images.add(imageModel);
        imageModel = new ImageModel("Video Seven", "https://i.stack.imgur.com/h6viz.jpg", 0, "Declined", 0, 12, 9, 2012);
        images.add(imageModel);
        imageModel = new ImageModel("Video Eight", "https://i.stack.imgur.com/h6viz.jpg", 265, "Accepted", 987, 9, 9, 2019);
        images.add(imageModel);
    }
}
