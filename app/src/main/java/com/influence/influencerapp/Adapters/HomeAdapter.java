package com.influence.influencerapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.influence.influencerapp.Models.VideoModel;
import com.influence.influencerapp.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.VideoHolder> {
    private List<VideoModel> videos;

    public class VideoHolder extends RecyclerView.ViewHolder {
        public TextView vdname, vdearnhldr, lkholder, statushldr;
        public ImageView vdhldr;
        public VideoHolder(View view) {
            super(view);
            vdname = view.findViewById(R.id.vdname_hldr);
            vdearnhldr = view.findViewById(R.id.vdearn_hldr);
            lkholder = view.findViewById(R.id.like_holder);
            statushldr = view.findViewById(R.id.statustext_hldr);
            vdhldr = view.findViewById(R.id.GIF_holder);
        }
    }
    public HomeAdapter(List<VideoModel> videos) {
        this.videos = videos;
    }
    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentview = LayoutInflater.from(parent.getContext()).inflate(R.layout.videolayout, parent, false);
        return new VideoHolder(contentview);
    }
    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        final VideoModel videoModel = videos.get(position);
        holder.vdname.setText(videoModel.getVideoname());
        String finalvalues = "Rs. " + videoModel.getEarning();
        holder.vdearnhldr.setText(finalvalues);
        String finallikes = videoModel.getLikes() / 1000 + "k";
        holder.lkholder.setText(finallikes);
        holder.statushldr.setText(videoModel.getStatus());
        if(videoModel.getStatus().equals("Accepted")) {
            holder.statushldr.setTextColor(ContextCompat.getColor(holder.statushldr.getContext(), R.color.colorGreen));
        }
        else {
            holder.statushldr.setTextColor(ContextCompat.getColor(holder.statushldr.getContext(), R.color.colorRed));
        }
        Glide.with(holder.vdhldr.getContext()).asGif().load(videoModel.getThumburl()).into(holder.vdhldr);
    }
    @Override
    public int getItemCount() {
        return videos.size();
    }
}