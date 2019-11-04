package co.edu.icesi.retodeezer.model;

import android.graphics.Bitmap;

public class Album {

    private long id;

    private String title;

    private Bitmap cover;

    public Album() {
    }

    public Album(long id, String title, Bitmap cover) {
        this.id = id;
        this.title = title;
        this.cover = cover;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getCover() {
        return cover;
    }

    public void setCover(Bitmap cover) {
        this.cover = cover;
    }
}
