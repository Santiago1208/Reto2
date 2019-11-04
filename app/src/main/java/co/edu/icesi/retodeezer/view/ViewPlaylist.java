package co.edu.icesi.retodeezer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.icesi.retodeezer.R;
import co.edu.icesi.retodeezer.control.activity.ViewPlaylistControl;
import co.edu.icesi.retodeezer.control.adapters.TracksListAdapter;
import co.edu.icesi.retodeezer.model.Playlist;
import co.edu.icesi.retodeezer.model.Track;

public class ViewPlaylist extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView activityTitleTextView;

    private ImageView playlistImage;

    private TextView playlistTitle;

    private TextView playlistDescription;

    private TextView playlistTracksNumber;

    private TextView playlistFansNumber;

    private ProgressBar searchingTracksProgress;

    private ListView tracksList;

    private TracksListAdapter tracksListAdapter;

    private ViewPlaylistControl viewPlaylistControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_playlist);

        initializeComponents();
        searchRemainingPlaylistDetails();
    }

    private void initializeComponents() {
        long playlistId = getIntent().getExtras().getLong(Constants.EXTRA_PLAYLIST_ID);
        viewPlaylistControl = new ViewPlaylistControl(this, tracksListAdapter, playlistId);

        activityTitleTextView = findViewById(R.id.title_edit_text);
        activityTitleTextView.setText(R.string.activity2_title);
        playlistImage = findViewById(R.id.playlist_image);
        playlistTitle = findViewById(R.id.playlist_title);
        playlistDescription = findViewById(R.id.playlist_description);
        playlistTracksNumber = findViewById(R.id.playlist_tracks_number);
        playlistFansNumber = findViewById(R.id.playlist_fans_number);
        searchingTracksProgress = findViewById(R.id.searching_tracks_progress);
        tracksList = findViewById(R.id.tracks_list);

        tracksListAdapter = new TracksListAdapter();
        tracksList.setAdapter(tracksListAdapter);

        Playlist controlledPlaylist = viewPlaylistControl.getPlaylist();
        playlistTitle.setText(controlledPlaylist.getName());
        playlistTracksNumber.setText(Integer.toString(controlledPlaylist.getTrackNumber()));
        playlistImage.setImageBitmap(controlledPlaylist.getBanner());
        Log.e("View playlist", controlledPlaylist.getBanner().getWidth() + "");

        searchingTracksProgress.setVisibility(View.VISIBLE);
    }

    private void searchRemainingPlaylistDetails() {
        viewPlaylistControl.searchTracks();
    }

    public void renderError(Exception e) {
        searchingTracksProgress.setVisibility(View.GONE);
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("View Playlist", e.getMessage(), e);

    }

    public void renderTracks(Playlist playlist) {
        searchingTracksProgress.setVisibility(View.GONE);
        playlistDescription.setText(playlist.getDescription());
        playlistFansNumber.setText(Integer.toString(playlist.getFansNumber()));
        tracksListAdapter.setTracks(playlist.getTracksList());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
