package co.edu.icesi.retodeezer.control.networking.request;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import co.edu.icesi.retodeezer.control.networking.Constants;
import co.edu.icesi.retodeezer.control.networking.results.ImageResult;
import co.edu.icesi.retodeezer.control.networking.results.NetworkResult;

public class SearchImage extends Worker implements Runnable {

    /**
     * The id of the owner of the image.
     */
    private long ownerId;

    private String imageType;

    public SearchImage(String url, NetworkTaskControl owner, long ownerId, String imageType) {
        super(url, owner);
        this.ownerId = ownerId;
        this.imageType = imageType;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Bitmap image = BitmapFactory.decodeStream(inputStream);
            NetworkResult result = new ImageResult(this.ownerId, image, imageType);
            this.owner.onTaskFinished(result);
        } catch (Exception e) {
            Log.e("[SEARCH_IMAGE]", e.getMessage(), e.getCause());
        }
    }
}
