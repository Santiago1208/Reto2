package co.edu.icesi.retodeezer.control.dto;

import java.io.Serializable;

import co.edu.icesi.retodeezer.model.Album;

public class AlbumDTO implements Serializable {

    private String id;

    private String cover_medium;

    private String title;

    public AlbumDTO() {
    }

    public static Album parseDTO(AlbumDTO albumDTO) {
        Album album = new Album();
        if (albumDTO != null) {
            album.setId(Long.parseLong(albumDTO.id));
            album.setTitle(albumDTO.title);
        }
        return album;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCover_medium() {
        return cover_medium;
    }

    public void setCover_medium(String cover_medium) {
        this.cover_medium = cover_medium;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
