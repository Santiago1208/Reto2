package co.edu.icesi.retodeezer.control.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.icesi.retodeezer.R;
import co.edu.icesi.retodeezer.control.activity.MainActivityControl;
import co.edu.icesi.retodeezer.model.Playlist;

public class PlaylistsAdapter extends BaseAdapter {

    private ArrayList<Playlist> playlists;

    private MainActivityControl mainActivityControl;

    public PlaylistsAdapter(MainActivityControl mainActivityControl) {
        this.playlists = new ArrayList<>();
        this.mainActivityControl = mainActivityControl;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        clearPlaylists();
        this.playlists.addAll(playlists);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return playlists.size();
    }

    @Override
    public Object getItem(int i) {
        return playlists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return playlists.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, null);

        TextView detail1 = view.findViewById(R.id.list_detail_1);
        TextView detail2 = view.findViewById(R.id.list_detail_2);
        TextView detail3 = view.findViewById(R.id.list_detail_3);
        ImageView thumbnail = view.findViewById(R.id.list_item_image);

        Playlist playlist = (Playlist) getItem(i);

        detail1.setText(playlist.getName());
        detail2.setText(playlist.getCreator().getName());
        detail3.setText(Integer.toString(playlist.getTrackNumber()));
        if (playlist.getThumbnail() != null) {
            thumbnail.setImageBitmap(playlist.getThumbnail());
        }
        return view;
    }

    public void clearPlaylists() {
        playlists.clear();
        notifyDataSetChanged();
    }
}
