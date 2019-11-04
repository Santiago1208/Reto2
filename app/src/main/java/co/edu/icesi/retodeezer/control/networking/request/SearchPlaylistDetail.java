package co.edu.icesi.retodeezer.control.networking.request;

import com.google.gson.Gson;

import co.edu.icesi.retodeezer.control.networking.results.SearchPlaylistDetailResult;
import co.edu.icesi.retodeezer.util.HTTPSWebUtilDomi;

public class SearchPlaylistDetail extends Worker implements Runnable {

    public SearchPlaylistDetail(String url, NetworkTaskControl owner) {
        super(url, owner);
    }

    @Override
    public void run() {
        try {
            HTTPSWebUtilDomi httpsManager = new HTTPSWebUtilDomi();
            Gson gson = new Gson();
            String json = httpsManager.GETrequest(url);
            SearchPlaylistDetailResult playlistDetailResult = gson.fromJson(json, SearchPlaylistDetailResult.class);
            owner.onTaskFinished(playlistDetailResult);
        } catch (Exception e) {
            owner.notifyExceptionOccurred(e);
        }
    }
}
