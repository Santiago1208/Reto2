package co.edu.icesi.retodeezer.control.dto;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.icesi.retodeezer.model.Track;

public class TrackListDTO implements Serializable {

    private ArrayList<TrackDTO> data;

    public TrackListDTO() {
    }

    public ArrayList<TrackDTO> getData() {
        return data;
    }

    public void setData(ArrayList<TrackDTO> data) {
        this.data = data;
    }

    public static ArrayList<Track> parseDTO(ArrayList<TrackDTO> trackDTOList) {
        ArrayList<Track> tracksList = new ArrayList<>();
        if (trackDTOList != null) {
            for (TrackDTO dto: trackDTOList) {
                Track track = TrackDTO.parseDTO(dto);
                tracksList.add(track);
            }
        }
        return tracksList;
    }
}
