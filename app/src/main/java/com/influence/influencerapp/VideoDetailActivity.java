package com.influence.influencerapp;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.influence.influencerapp.Adapters.VideoDetailAdapter;
import com.influence.influencerapp.Models.VideoModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByDate implements Comparator<VideoModel> {
    public int compare(VideoModel a, VideoModel b) {
        return a.getDate() - b.getDate();
    }
}
class SortByMonth implements Comparator<VideoModel> {
    public int compare(VideoModel a, VideoModel b) {
        return a.getMonth() - b.getMonth();
    }
}
class SortByYear implements Comparator<VideoModel> {
    public int compare(VideoModel a, VideoModel b) {
        return a.getYear() - b.getYear();
    }
}

public class VideoDetailActivity extends AppCompatActivity {

    private List<VideoModel> videos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videodetails);

        TextView textView = findViewById(R.id.TextView_1);
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(), new int[]{Color.BLUE, Color.RED}, new float[]{0, 1}, Shader.TileMode.MIRROR);
        textView.getPaint().setShader(textShader);

        final ImageButton imageButton = findViewById(R.id.sort_videos);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_2);
        final VideoDetailAdapter videoDetailAdapter = new VideoDetailAdapter(videos);
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(rLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(videoDetailAdapter);
        videosData();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(VideoDetailActivity.this, imageButton);
                popupMenu.getMenuInflater().inflate(R.menu.sort_drawer, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().toString().equals("Sort by Date")) {
                            Collections.sort(videos, new SortByDate());
                        }
                        else if(item.getTitle().toString().equals("Sort by Month")) {
                            Collections.sort(videos, new SortByMonth());
                        }
                        else {
                            Collections.sort(videos, new SortByYear());
                        }
                        videoDetailAdapter.notifyDataSetChanged();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void videosData() {
        VideoModel videoModel = new VideoModel("Video One", "https://i.stack.imgur.com/h6viz.gif", 230, "Accepted", 345, 23, 6, 2014);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Two", "https://i.stack.imgur.com/h6viz.gif", 0, "Declined", 0, 8, 5, 2019);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Three", "https://i.stack.imgur.com/h6viz.gif", 3467, "Accepted",  3123, 11, 4, 2016);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Four", "https://i.stack.imgur.com/h6viz.gif", 0, "Declined", 0, 16, 9, 2011);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Five", "https://i.stack.imgur.com/h6viz.gif", 126, "Accepted", 542, 31, 1, 2017);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Six", "https://i.stack.imgur.com/h6viz.gif", 3467, "Accepted", 876, 22, 8, 2010);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Seven", "https://i.stack.imgur.com/h6viz.gif", 0, "Declined", 0, 12, 9, 2012);
        videos.add(videoModel);
        videoModel = new VideoModel("Video Eight", "https://i.stack.imgur.com/h6viz.gif", 265, "Accepted", 987, 9, 9, 2019);
        videos.add(videoModel);
    }
}