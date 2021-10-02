package com.influence.influencerapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.influence.influencerapp.Models.ImageModel;
import com.influence.influencerapp.R;

import java.util.List;

public class ImageDetailAdapter extends RecyclerView.Adapter<ImageDetailAdapter.ImageHolder> {
private List<ImageModel> images;

public class ImageHolder extends RecyclerView.ViewHolder {
    public TextView imageName, imageDescription, likes, comments, date;
    public ImageView urlImageHolder;
    public ImageHolder(View view) {
        super(view);
        imageName = view.findViewById(R.id.imageNameHolder);
        imageDescription = view.findViewById(R.id.imageDescriptionHolder);
        likes = view.findViewById(R.id.likesHolder);
        comments = view.findViewById(R.id.commentsHolder);
        date = view.findViewById(R.id.dateHolder);
    }
}
    public ImageDetailAdapter(List<ImageMode> image) {
        this.image = image;
    }
    @Override
    public ImageDetailAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentview = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagelayout, parent, false);
        return new ImageHolder(contentview);
    }
    @Override
    public void onBindViewHolder(ImageDetailAdapter.ImageHolder holder, int position) {
        final ImageModel imageModel = images.get(position);
        holder.imageName.setText(imageModel.getImageName());
        holder.imageDescription.setText(imageModel.getImageDescription());
        String finallikes = imageModel.getLikes() / 1000 + "k";
        holder.likes.setText(finallikes);
        Glide.with(holder.urlImageHolder.getContext()).asGif().load(imageModel.getImageUrl()).into(holder.urlImageHolder);
        String datecmp = "Uploaded On : " + imageModel.getDate() + "/" + imageModel.getMonth() + "/" + imageModel.getYear();
        holder.date.setText(datecmp);
    }
    @Override
    public int getItemCount() {
        return images.size();
    }
}
