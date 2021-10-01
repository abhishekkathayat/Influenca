package com.influence.influencerapp.Models;

public class ImageModel {
    private String imageName;
    private String imageUrl;
    private String imageDescription;
    private double likes;
    private int date;
    private int month;
    private int year;
    private int noOfComments;

    public VideoModel(String imageName, String imageUrl, String imageDescription, double likes, int date, int month, int year, int noOfComments) {
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.imageDescription = imageDescription;
        this.likes = likes;
        this.noOfComments = noOfComments;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getImageName() {
        return imageName;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
    public String getImageDescription() {
        return imageDescription;
    }

    public void setLikes(double likes) {
        this.likes = likes;
    }
    public double getLikes() {
        return likes;
    }

    public void setNoOfComments(String noOfComments) {
        this.noOfComments = noOfComments;
    }
    public String getNoOfComments() {
        return noOfComments;
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
    
    @Override
    public String toString() {
        return imageName + " " + imageUrl + " " + imageDescription + " " + likes + " "
            + date + " " + month + " " + year + " " + noOfComments;
    }
}
