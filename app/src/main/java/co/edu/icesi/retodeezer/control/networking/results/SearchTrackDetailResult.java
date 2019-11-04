package co.edu.icesi.retodeezer.control.networking.results;

public class SearchTrackDetailResult implements NetworkResult {

    public SearchTrackDetailResult() {
    }

    @Override
    public NetworkResult getResult() {
        SearchTrackDetailResult playlistsResult = new SearchTrackDetailResult();
        if (this != null) {
            playlistsResult = this;
        }
        return playlistsResult;
    }
}
