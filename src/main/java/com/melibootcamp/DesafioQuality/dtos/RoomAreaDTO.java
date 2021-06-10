package com.melibootcamp.DesafioQuality.dtos;

public class RoomAreaDTO {
    String name;
    Double area;

    public RoomAreaDTO(String name, Double area) {
        this.name = name;
        this.area = area;
    }

    public RoomAreaDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

}
