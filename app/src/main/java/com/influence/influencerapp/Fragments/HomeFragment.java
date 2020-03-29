package com.influence.influencerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.influence.influencerapp.Adapters.HomeAdapter;
import com.influence.influencerapp.Models.VideoModel;
import com.influence.influencerapp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private List<VideoModel> videos = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homescreen, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_1);
        homeAdapter = new HomeAdapter(videos);
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(homeAdapter);
        videosData();

        return view;
    }

    private void videosData() {
        VideoModel videoModel = new VideoModel("Video One", "https://i.stack.imgur.com/h6viz.gif", 230, "Accepted", 345);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Two", "https://i.stack.imgur.com/h6viz.gif", 0, "Declined", 0);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Three", "https://i.stack.imgur.com/h6viz.gif", 3467, "Accepted",  3123);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Four", "https://i.stack.imgur.com/h6viz.gif", 0, "Declined", 0);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Five", "https://i.stack.imgur.com/h6viz.gif", 126, "Accepted", 542);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Six", "https://i.stack.imgur.com/h6viz.gif", 3467, "Accepted", 876);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Seven", "https://i.stack.imgur.com/h6viz.gif", 0, "Declined", 0);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Eight", "https://i.stack.imgur.com/h6viz.gif", 265, "Accepted", 987);
        videos.add(videoModel);
    }
}
