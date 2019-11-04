package co.edu.icesi.retodeezer.control.networking.request;

import android.util.Log;

import com.google.gson.Gson;

import co.edu.icesi.retodeezer.control.networking.results.SearchPlaylistsResult;
import co.edu.icesi.retodeezer.util.HTTPSWebUtilDomi;

public class SearchPlaylists extends Worker implements Runnable {

    public SearchPlaylists(String url, NetworkTaskControl owner) {
        super(url, owner);
    }

    @Override
    public void run() {
        try {
            HTTPSWebUtilDomi httpsManager = new HTTPSWebUtilDomi();
            Gson gson = new Gson();
            String json = httpsManager.GETrequest(url);
            SearchPlaylistsResult result = gson.fromJson(json, SearchPlaylistsResult.class);
            owner.onTaskFinished(result);
        } catch (Exception e) {
            Log.e("[SearchPlaylists]", e.getMessage(), e);
        }
    }
}
