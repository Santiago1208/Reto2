package co.edu.icesi.retodeezer.control.networking.results;

import java.util.ArrayList;

import co.edu.icesi.retodeezer.control.dto.PlaylistDTO;

public class SearchPlaylistsResult implements NetworkResult {

    private ArrayList<PlaylistDTO> data;

    private int total;

    private String next;

    public SearchPlaylistsResult() {

    }

    public SearchPlaylistsResult(ArrayList<PlaylistDTO> data, int results) {
        this.data = data;
        this.total = results;
    }

    public ArrayList<PlaylistDTO> getData() {
        return data;
    }

    public void setData(ArrayList<PlaylistDTO> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public NetworkResult getResult() {
        SearchPlaylistsResult playlistsResult = new SearchPlaylistsResult();
        if (this != null) {
            playlistsResult = this;
        }
        return playlistsResult;
    }
}
