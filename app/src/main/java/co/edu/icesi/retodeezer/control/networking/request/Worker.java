package co.edu.icesi.retodeezer.control.networking.request;

import co.edu.icesi.retodeezer.control.networking.results.NetworkResult;

public abstract class Worker {

    protected String url;

    protected NetworkTaskControl owner;

    protected NetworkResult result;

    public Worker(String url, NetworkTaskControl owner) {
        this.url = url;
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkTaskControl getOwner() {
        return owner;
    }

    public void setOwner(NetworkTaskControl owner) {
        this.owner = owner;
    }

    public NetworkResult getResult() {
        return result;
    }

}
