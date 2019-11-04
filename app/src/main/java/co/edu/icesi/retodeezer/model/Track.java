package co.edu.icesi.retodeezer.model;

public class Track {

    private long id;

    private String name;

    private Artist artist;

    private int releaseYear;

    private Album album;

    private int duration;

    public Track() {
    }

    public Track(long id, String name, Artist artist, int releaseYear, Album album, int duration) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.album = album;
        this.duration = duration;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
