package com.melibootcamp.DesafioQuality.dtos;

import javax.validation.constraints.*;

public class RoomDTO {

    @NotNull(message = "The field 'name' in rooms must not be empty")
    @Size(max = 30, message = "The field 'name' in rooms can not exceed 30 characters")
    @Pattern(regexp="^([A-Z])(([A-Za-z1-9\\s])*)", message = "The field 'name' in rooms must start with a capital letter")
    private String name;

    @NotNull(message = "The field 'width' in rooms must not be empty")
    @Max(value = 25, message = "The field 'width' in rooms must not exceed 25 meters")
    @Min(value = 1, message = "The field 'width' in rooms must have, at least, 1 meter")
    private Double width;

    @NotNull(message = "The field 'width' in rooms must not be null")
    @Max(value = 33, message = "The field 'length' in rooms must not exceed 33 meters")
    @Min(value = 1, message = "The field 'length' in rooms must have, at least, 1 meter")
    private Double length;

    public RoomDTO(String name, Double width, Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public RoomDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
