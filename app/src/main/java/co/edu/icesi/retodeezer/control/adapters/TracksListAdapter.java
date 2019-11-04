package co.edu.icesi.retodeezer.control.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.icesi.retodeezer.R;
import co.edu.icesi.retodeezer.model.Playlist;
import co.edu.icesi.retodeezer.model.Track;

public class TracksListAdapter extends BaseAdapter {

    private ArrayList<Track> tracks;

    public TracksListAdapter() {
        tracks = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int i) {
        return tracks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tracks.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, null);

        ImageView imageView = view.findViewById(R.id.list_item_image);
        TextView detail1 = view.findViewById(R.id.list_detail_1);
        TextView detail2 = view.findViewById(R.id.list_detail_2);
        TextView detail3 = view.findViewById(R.id.list_detail_3);

        Track track = (Track) getItem(i);
        detail1.setText(track.getName());
        detail2.setText(track.getArtist().getName());

        return view;
    }

    public void clearTracksList() {
        tracks.clear();
        notifyDataSetChanged();
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks.addAll(tracks);
        notifyDataSetChanged();
    }
}
