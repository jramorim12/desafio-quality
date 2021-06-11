package com.melibootcamp.DesafioQuality.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class HouseDTO {

    @NotNull(message = "The field name must not be empty")
    @Size(max = 30, message = "The field name can not exceed 30 characters")
    @Pattern(regexp="^([A-Z])(([A-Za-z1-9\\s])*)", message = "The field name must start with a capital letter")
    private String name;

    @NotNull(message = "The field district must not be empty")
    @Size(max = 45, message = "The field name can not exceed 45 characters")
    private String district;

    @Valid
    @NotNull(message = "The field rooms must not be null")
    @NotEmpty(message = "The field rooms must not be empty")
    private List<RoomDTO> rooms;

    public HouseDTO(String name, String district, List<RoomDTO> rooms) {
        this.name = name;
        this.district = district;
        this.rooms = rooms;
    }

    public HouseDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }


}
