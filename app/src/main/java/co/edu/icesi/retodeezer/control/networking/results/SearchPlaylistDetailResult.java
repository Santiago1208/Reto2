package co.edu.icesi.retodeezer.control.networking.results;

import co.edu.icesi.retodeezer.control.dto.TrackListDTO;

public class SearchPlaylistDetailResult implements NetworkResult {

    private String description;

    private int fans;

    private String picture_big;

    private TrackListDTO tracks;

    public SearchPlaylistDetailResult() {
    }

    public SearchPlaylistDetailResult(String description, int fans, String picture_big,
                                      TrackListDTO tracks) {
        this.description = description;
        this.fans = fans;
        this.picture_big = picture_big;
        this.tracks = tracks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_big() {
        return picture_big;
    }

    public void setPicture_big(String picture_big) {
        this.picture_big = picture_big;
    }

    public TrackListDTO getTracks() {
        return tracks;
    }

    public void setTracks(TrackListDTO tracks) {
        this.tracks = tracks;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    @Override
    public NetworkResult getResult() {
        SearchPlaylistDetailResult playlistsResult = new SearchPlaylistDetailResult();
        if (this != null) {
            playlistsResult = this;
        }
        return playlistsResult;
    }
}
