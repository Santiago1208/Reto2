package co.edu.icesi.retodeezer.control.dto;

import java.io.Serializable;

import co.edu.icesi.retodeezer.model.Creator;

public class CreatorDTO implements Serializable {

    private long id;

    private String name;

    public CreatorDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Creator parseDTO(CreatorDTO creatorDTO) {
        Creator creator = new Creator();
        if (creatorDTO != null) {
            long creatorId = creatorDTO.id;
            String creatorName = creatorDTO.name;

            creator.setId(creatorId);
            creator.setName(creatorName);
        }
        return creator;
    }
}
