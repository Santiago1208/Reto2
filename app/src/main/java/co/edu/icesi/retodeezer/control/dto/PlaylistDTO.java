package co.edu.icesi.retodeezer.control.dto;

import java.io.Serializable;

import co.edu.icesi.retodeezer.model.Creator;
import co.edu.icesi.retodeezer.model.Playlist;

public class PlaylistDTO implements Serializable {

    private long id;

    private String title;

    private int nb_tracks;

    private String picture_medium;

    private String picture_xl;

    private CreatorDTO user;

    public PlaylistDTO() {
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

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }

    public String getPicture_xl() {
        return picture_xl;
    }

    public void setPicture_xl(String picture_xl) {
        this.picture_xl = picture_xl;
    }

    public CreatorDTO getUser() {
        return user;
    }

    public void setUser(CreatorDTO user) {
        this.user = user;
    }

    public static Playlist parseDTO(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist();
        if (playlistDTO != null) {
            long playlistId = playlistDTO.id;
            String playlistTitle = playlistDTO.title;
            int tracksNumber = playlistDTO.nb_tracks;
            Creator creator = CreatorDTO.parseDTO(playlistDTO.user);
            String thumbnailUrl = playlistDTO.picture_medium;
            String bannerUrl = playlistDTO.picture_xl;

            playlist.setId(playlistId);
            playlist.setName(playlistTitle);
            playlist.setTrackNumber(tracksNumber);
            playlist.setCreator(creator);
            playlist.setThumbnailUrl(thumbnailUrl);
            playlist.setBannerUrl(bannerUrl);
        }
        return playlist;
    }
}
