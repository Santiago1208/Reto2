package co.edu.icesi.retodeezer.control.dto;

import java.io.Serializable;

import co.edu.icesi.retodeezer.model.Album;
import co.edu.icesi.retodeezer.model.Artist;
import co.edu.icesi.retodeezer.model.Track;

public class TrackDTO implements Serializable {

    private String id;

    private String title;

    private ArtistDTO artist;

    private AlbumDTO album;

    public TrackDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public static Track parseDTO(TrackDTO trackDTO) {
        Track track = new Track();
        if (trackDTO != null) {
            track.setId(Long.parseLong(trackDTO.id));

            Artist artist = ArtistDTO.parseDTO(trackDTO.getArtist());
            Album album = AlbumDTO.parseDTO(trackDTO.getAlbum());

            track.setName(trackDTO.title);
            track.setAlbum(album);
            track.setArtist(artist);

        }
        return track;
    }
}
