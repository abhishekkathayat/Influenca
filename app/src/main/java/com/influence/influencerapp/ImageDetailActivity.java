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
import com.influence.influencerapp.Models.ImageModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByDate implements Comparator<ImageModel> {
    public int compare(ImageModel a, ImageModel b) {
        return a.getDate() - b.getDate();
    }
}
class SortByMonth implements Comparator<ImageModel> {
    public int compare(ImageModel a, ImageModel b) {
        return a.getMonth() - b.getMonth();
    }
}
class SortByYear implements Comparator<ImageModel> {
    public int compare(ImageModel a, ImageModel b) {
        return a.getYear() - b.getYear();
    }
}

public class VideoDetailActivity extends AppCompatActivity {

    private List<ImageModel> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videodetails);

        TextView textView = findViewById(R.id.TextView_1);
        Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(), new int[]{Color.BLUE, Color.RED}, new float[]{0, 1}, Shader.TileMode.MIRROR);
        textView.getPaint().setShader(textShader);

        final ImageButton imageButton = findViewById(R.id.sort_images);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_2);
        final VideoDetailAdapter videoDetailAdapter = new VideoDetailAdapter(images);
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(rLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(videoDetailAdapter);
        imagesData();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(VideoDetailActivity.this, imageButton);
                popupMenu.getMenuInflater().inflate(R.menu.sort_drawer, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().toString().equals("Sort by Date")) {
                            Collections.sort(images, new SortByDate());
                        }
                        else if(item.getTitle().toString().equals("Sort by Month")) {
                            Collections.sort(images, new SortByMonth());
                        }
                        else {
                            Collections.sort(images, new SortByYear());
                        }
                        videoDetailAdapter.notifyDataSetChanged();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private void imagesData() {
        ImageModel ImageModel = new ImageModel("Video One", "https://i.stack.imgur.com/h6viz.jpg", 230, "Accepted", 345, 23, 6, 2014);
        images.add(ImageModel);
        ImageModel = new ImageModel("Video Two", "https://i.stack.imgur.com/h6viz.jpg", 0, "Declined", 0, 8, 5, 2019);
        images.add(ImageModel);
        ImageModel = new ImageModel("Video Three", "https://i.stack.imgur.com/h6viz.jpg", 3467, "Accepted",  3123, 11, 4, 2016);
        images.add(ImageModel);
        ImageModel = new ImageModel("Video Four", "https://i.stack.imgur.com/h6viz.jpg", 0, "Declined", 0, 16, 9, 2011);
        images.add(ImageModel);
        ImageModel = new ImageModel("Video Five", "https://i.stack.imgur.com/h6viz.jpg", 126, "Accepted", 542, 31, 1, 2017);
        images.add(ImageModel);
        ImageModel = new ImageModel("Video Six", "https://i.stack.imgur.com/h6viz.jpg", 3467, "Accepted", 876, 22, 8, 2010);
        images.add(ImageModel);
        ImageModel = new ImageModel("Video Seven", "https://i.stack.imgur.com/h6viz.jpg", 0, "Declined", 0, 12, 9, 2012);
        images.add(ImageModel);
        ImageModel = new ImageModel("Video Eight", "https://i.stack.imgur.com/h6viz.jpg", 265, "Accepted", 987, 9, 9, 2019);
        images.add(ImageModel);
    }
}