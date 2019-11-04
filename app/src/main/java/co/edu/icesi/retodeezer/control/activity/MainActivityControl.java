package co.edu.icesi.retodeezer.control.activity;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;

import co.edu.icesi.retodeezer.control.dto.PlaylistDTO;
import co.edu.icesi.retodeezer.control.networking.Constants;
import co.edu.icesi.retodeezer.control.networking.request.NetworkTaskControl;
import co.edu.icesi.retodeezer.control.networking.request.SearchImage;
import co.edu.icesi.retodeezer.control.networking.request.SearchPlaylists;
import co.edu.icesi.retodeezer.control.networking.results.ImageResult;
import co.edu.icesi.retodeezer.control.networking.results.NetworkResult;
import co.edu.icesi.retodeezer.control.networking.results.SearchPlaylistsResult;
import co.edu.icesi.retodeezer.model.Deezer;
import co.edu.icesi.retodeezer.model.Playlist;
import co.edu.icesi.retodeezer.view.MainActivity;

public class MainActivityControl implements NetworkTaskControl {

    private MainActivity mainActivity;

    private Deezer deezer;

    public MainActivityControl(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        deezer = Deezer.getInstance();
    }

    public void searchPlaylists(String keywords) throws Exception {
        if (keywords == null) {
            throw new Exception("Undefined keywords to search playlists");
        }
        keywords = keywords.trim();
        if (keywords.isEmpty()) {
            throw new Exception("Unable to search playlists. Please provide some keywords");
        }
        String urlRequest = Constants.SEARCH_PLAYLISTS_REQUEST + keywords;
        SearchPlaylists playlistSearcher = new SearchPlaylists(urlRequest,this);
        Thread networkingThread = new Thread(playlistSearcher);
        networkingThread.start();
    }

    public void findPlaylistsImage(String imageType) {
        HashMap<Long, Playlist> playlists = deezer.getPlaylists();
        for (long playlistId : playlists.keySet()) {
            Playlist playlist = playlists.get(playlistId);
            String url = (imageType.equals(Constants.BANNER_IMAGE_TYPE)) ? playlist.getBannerUrl() : playlist.getThumbnailUrl();
            SearchImage imageSearcher = new SearchImage(url, this, playlistId, imageType);
            Thread networkingThread = new Thread(imageSearcher);
            networkingThread.start();
        }
    }

    @Override
    public synchronized void onTaskFinished(NetworkResult results) {
        if (results instanceof SearchPlaylistsResult) {
            SearchPlaylistsResult playlistsResult = (SearchPlaylistsResult) results;
            ArrayList<PlaylistDTO> data = playlistsResult.getData();
            HashMap<Long, Playlist> modelPlaylists = new HashMap<>();
            for (PlaylistDTO dto : data) {
                Playlist playlist = PlaylistDTO.parseDTO(dto);
                long playlistId = playlist.getId();
                modelPlaylists.put(playlistId, playlist);
            }
            deezer.setPlaylists(modelPlaylists);
            mainActivity.runOnUiThread(
                    () -> {
                        findPlaylistsImage(Constants.THUMBNAIL_IMAGE_TYPE);
                        findPlaylistsImage(Constants.BANNER_IMAGE_TYPE);
                        ArrayList<Playlist> playlists = deezer.getPlaylistsList();
                        mainActivity.refreshPlaylistsData(playlists);
                    }
            );
        } else if (results instanceof ImageResult) {
            ImageResult imageResult = (ImageResult) results;
            Bitmap image = imageResult.getImage();
            String imageType = imageResult.getType();
            Deezer deezer = Deezer.getInstance();
            long playlistId = imageResult.getOwnerId();
            Playlist playlist = deezer.getPlaylists().get(playlistId);
            if (imageType.equals(Constants.THUMBNAIL_IMAGE_TYPE)) {
                playlist.setThumbnail(image);
                mainActivity.runOnUiThread(
                        () -> {
                            ArrayList<Playlist> playlists = deezer.getPlaylistsList();
                            mainActivity.refreshPlaylistsData(playlists);
                        }
                );
            } else if (imageType.equals(Constants.BANNER_IMAGE_TYPE)) {
                playlist.setBanner(image);
            }
        }
    }

    @Override
    public void notifyExceptionOccurred(Exception e) {

    }

    /**
     * Finds a playlist in the model layer.
     * @param itemId is the playlist ID to find
     * @return the playlist which have the specified ID.
     */
    public Playlist findPlaylist(long itemId) {
        return Deezer.getInstance().getPlaylists().get(itemId);
    }
}
