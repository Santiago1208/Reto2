package co.edu.icesi.retodeezer.control.networking.results;

import android.graphics.Bitmap;

public class ImageResult implements NetworkResult {

    /**
     * The id of the element which owns the image
     */
    private long ownerId;

    private Bitmap image;

    private String type;

    public ImageResult() {
    }

    public ImageResult(long ownerId, Bitmap image, String type) {
        this.ownerId = ownerId;
        this.image = image;
        this.type = type;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public NetworkResult getResult() {
        ImageResult result = new ImageResult();
        if (this != null) {
            result = this;
        }
        return result;
    }
}
