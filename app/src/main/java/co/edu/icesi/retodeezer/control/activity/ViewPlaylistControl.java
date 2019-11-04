package co.edu.icesi.retodeezer.control.activity;

import co.edu.icesi.retodeezer.control.adapters.TracksListAdapter;
import co.edu.icesi.retodeezer.control.dto.TrackListDTO;
import co.edu.icesi.retodeezer.control.networking.Constants;
import co.edu.icesi.retodeezer.control.networking.request.NetworkTaskControl;
import co.edu.icesi.retodeezer.control.networking.request.SearchPlaylistDetail;
import co.edu.icesi.retodeezer.control.networking.results.ImageResult;
import co.edu.icesi.retodeezer.control.networking.results.NetworkResult;
import co.edu.icesi.retodeezer.control.networking.results.SearchPlaylistDetailResult;
import co.edu.icesi.retodeezer.model.Deezer;
import co.edu.icesi.retodeezer.model.Playlist;
import co.edu.icesi.retodeezer.view.ViewPlaylist;

public class ViewPlaylistControl implements NetworkTaskControl {

    private ViewPlaylist context;

    /**
     *
     */
    private Playlist playlist;

    /**
     *
     */
    private Deezer deezer;

    /**
     *
     */
    private TracksListAdapter listAdapter;

    public ViewPlaylistControl(ViewPlaylist context, TracksListAdapter listAdapter, long playlistId) {
        this.context = context;
        this.listAdapter = listAdapter;
        deezer = Deezer.getInstance();
        playlist = deezer.getPlaylists().get(playlistId);
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     * Searches the tracks of the playlist which id is configured in this control
     * entity.
     */
    public void searchTracks() {
        String requestUrl = Constants.SEARCH_PLAYLIST_DETAIL_REQUEST + playlist.getId();
        SearchPlaylistDetail searcher = new SearchPlaylistDetail(requestUrl, this);
        Thread networkingThread = new Thread(searcher);
        networkingThread.start();
    }

    @Override
    public void onTaskFinished(NetworkResult results) {
        if (results instanceof SearchPlaylistDetailResult) {
            SearchPlaylistDetailResult playlistDetailResult = (SearchPlaylistDetailResult) results;
            playlist.setDescription(playlistDetailResult.getDescription());
            playlist.setFansNumber(playlistDetailResult.getFans());
            playlist.setTracks(TrackListDTO.parseDTO(playlistDetailResult.getTracks().getData()));
            context.runOnUiThread(() -> {
                searchImages();
            });
        } else if (results instanceof ImageResult) {

        }
    }

    @Override
    public void notifyExceptionOccurred(Exception e) {
        context.runOnUiThread(() -> context.renderError(e));
    }

    private void searchImages() {

    }
}
