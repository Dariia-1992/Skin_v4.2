package com.example.skin_v42.model;


import android.net.Uri;

public class Mod {
    private int id;
    private String title;
    private Uri [] images;

    // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    public Mod(){}

    public Mod(int id, String title, Uri[] images) {
        this.id = id;
        this.title = title;
        this.images = images;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Uri[] getImages() { return images; }
    public void setImages(Uri[] images) { this.images = images; }
}
