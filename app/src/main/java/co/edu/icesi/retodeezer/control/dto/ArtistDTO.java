package co.edu.icesi.retodeezer.control.dto;

import java.io.Serializable;

import co.edu.icesi.retodeezer.model.Artist;

public class ArtistDTO implements Serializable {

    private String id;

    private String name;

    public ArtistDTO() {
    }

    public static Artist parseDTO(ArtistDTO artistDTO) {
        Artist artist = new Artist();
        if (artistDTO != null) {
            artist.setId(Long.parseLong(artistDTO.id));
            artist.setName(artistDTO.name);
        }
        return artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
