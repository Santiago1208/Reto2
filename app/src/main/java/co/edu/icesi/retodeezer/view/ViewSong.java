package co.edu.icesi.retodeezer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import co.edu.icesi.retodeezer.R;

public class ViewSong extends AppCompatActivity {

    private TextView activityTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_song);

        initializeComponents();
    }

    private void initializeComponents() {
        activityTitleTextView = findViewById(R.id.title_edit_text);
        activityTitleTextView.setText(R.string.activity3_title);
    }
}
