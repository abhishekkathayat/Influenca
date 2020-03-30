package com.influence.influencerapp.Models;

public class VideoModel {
    private String videoname;
    private String thumburl;
    private double likes;
    private String status;
    private int earning;
    private int date;
    private int month;
    private int year;

    public VideoModel(String videoname, String thumburl, double likes, String status, int earning, int date, int month, int year) {
        this.videoname = videoname;
        this.thumburl = thumburl;
        this.likes = likes;
        this.status = status;
        this.earning = earning;
        this.date = date;
        this.month = month;
        this.year = year;
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

    public void setDate(int date) {
        this.date = date;
    }
    public int getDate() {
        return date;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }
}
