package com.melibootcamp.DesafioQuality.dtos;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "RoomAreaDTO{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomAreaDTO that = (RoomAreaDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area);
    }
}
