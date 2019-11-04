package co.edu.icesi.retodeezer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.icesi.retodeezer.R;
import co.edu.icesi.retodeezer.control.activity.MainActivityControl;
import co.edu.icesi.retodeezer.control.adapters.PlaylistsAdapter;
import co.edu.icesi.retodeezer.model.Playlist;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView activityTitleTextView;

    private ImageButton searchImgButton;

    private ListView playlistList;

    private PlaylistsAdapter playlistsAdapter;

    private EditText keywordsText;

    private ProgressBar fetchingPlaylistProgress;

    private MainActivityControl mainActivityControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        configureListeners();
    }

    private void initializeComponents() {
        mainActivityControl = new MainActivityControl(this);
        activityTitleTextView = findViewById(R.id.title_edit_text);
        activityTitleTextView.setText(R.string.activity1_title);
        searchImgButton = findViewById(R.id.search_img_button);
        keywordsText = findViewById(R.id.keywords_text);
        fetchingPlaylistProgress = findViewById(R.id.fetching_playlist_progress);

        playlistList = findViewById(R.id.playlist_list);
        playlistsAdapter = new PlaylistsAdapter(mainActivityControl);
        playlistList.setAdapter(playlistsAdapter);
        playlistList.setOnItemClickListener(this);

    }

    private void configureListeners() {
        searchImgButton.setOnClickListener(
                (View v) -> {
                    try {
                        String keywords = keywordsText.getText().toString();
                        playlistsAdapter.clearPlaylists();
                        fetchingPlaylistProgress.setVisibility(View.VISIBLE);
                        mainActivityControl.searchPlaylists(keywords);
                    } catch (Exception e) {
                        Toast.makeText(this, "An error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void refreshPlaylistsData(ArrayList<Playlist> playlists) {
        if (fetchingPlaylistProgress.getVisibility() == View.VISIBLE) {
            fetchingPlaylistProgress.setVisibility(View.GONE);
        }
        playlistsAdapter.setPlaylists(playlists);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long itemId) {
        Playlist playlist = mainActivityControl.findPlaylist(itemId);
        Intent intent = new Intent(this, ViewPlaylist.class);
        intent.putExtra(Constants.EXTRA_PLAYLIST_ID, itemId);
        startActivityForResult(intent, Constants.REQUEST_CODE_VIEW_PLAYLIST);
    }

}
