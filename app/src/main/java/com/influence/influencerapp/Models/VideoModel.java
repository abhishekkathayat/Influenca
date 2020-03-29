package com.influence.influencerapp.Models;

public class VideoModel {
    private String videoname;
    private String thumburl;
    private double likes;
    private String status;
    private int earning;

    public VideoModel(String videoname, String thumburl, double likes, String status, int earning) {
        this.videoname = videoname;
        this.thumburl = thumburl;
        this.likes = likes;
        this.status = status;
        this.earning = earning;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }
    public String getVideoname() {
        return videoname;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }
    public String getThumburl() {
        return thumburl;
    }

    public void setLikes(double likes) {
        this.likes = likes;
    }
    public double getLikes() {
        return likes;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }
    public int getEarning() {
        return earning;
    }
}
