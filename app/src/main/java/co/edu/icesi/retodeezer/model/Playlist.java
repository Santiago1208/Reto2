package co.edu.icesi.retodeezer.model;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Playlist {

    private long id;

    private String name;

    private String description;

    private int fansNumber;

    private Bitmap banner;

    private String bannerUrl;

    private Creator creator;

    private int trackNumber;

    private Bitmap thumbnail;

    private String thumbnailUrl;

    private HashMap<Long, Track> tracks;

    public Playlist() {
        tracks = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(int fansNumber) {
        this.fansNumber = fansNumber;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Bitmap getBanner() {
        return banner;
    }

    public void setBanner(Bitmap banner) {
        this.banner = banner;
    }

    public HashMap<Long, Track> getTracks() {
        return tracks;
    }

    public ArrayList<Track> getTracksList() {
        ArrayList<Track> tracksList = new ArrayList<>();
        Iterator<Long> iterator = tracks.keySet().iterator();
        while(iterator.hasNext()) {
            long trackId = iterator.next();
            Track track = tracks.get(trackId);
            tracksList.add(track);
        }
        return tracksList;
    }

    public void setTracks(HashMap<Long, Track> tracks) {
        this.tracks = tracks;
    }

    public void setTracks(ArrayList<Track> tracksList) {
        for (Track track: tracksList) {
            long trackId = track.getId();
            this.tracks.put(trackId, track);
        }
    }
}
