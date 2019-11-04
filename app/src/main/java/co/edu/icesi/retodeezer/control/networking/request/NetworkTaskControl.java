package co.edu.icesi.retodeezer.control.networking.request;

import co.edu.icesi.retodeezer.control.networking.results.NetworkResult;

public interface NetworkTaskControl {

    public void onTaskFinished(NetworkResult results);

    public void notifyExceptionOccurred(Exception e);

}
