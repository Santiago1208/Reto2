package co.edu.icesi.retodeezer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Deezer {

    private static Deezer instance;

    private HashMap<Long, Playlist> playlists;

    private Deezer () {
        playlists = new HashMap<>();
    }

    public static Deezer getInstance() {
        if (instance == null) {
            instance = new Deezer();
        }
        return instance;
    }

    public HashMap<Long, Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(HashMap<Long, Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Playlist> getPlaylistsList() {
        ArrayList<Playlist> playlists = new ArrayList<>();
        Iterator<Long> iterator = this.playlists.keySet().iterator();
        while (iterator.hasNext()) {
            Long playlistId = iterator.next();
            Playlist playlist = this.playlists.get(playlistId);
            playlists.add(playlist);
        }
        return playlists;
    }
}
