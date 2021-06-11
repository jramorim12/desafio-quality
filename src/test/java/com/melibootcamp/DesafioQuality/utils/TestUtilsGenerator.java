package com.melibootcamp.DesafioQuality.utils;

import com.melibootcamp.DesafioQuality.dtos.HouseDTO;
import com.melibootcamp.DesafioQuality.dtos.RoomAreaDTO;
import com.melibootcamp.DesafioQuality.dtos.RoomDTO;
import com.melibootcamp.DesafioQuality.service.HouseService;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {

    public static String getBiggestRoomExpectedReturn = "The biggest room is Cozinha, it has 48.0 m².";

    public static List<RoomAreaDTO> getAreaEachRoomExpectedReturn = new ArrayList<>();

    static {
        getAreaEachRoomExpectedReturn.add(new RoomAreaDTO("Quarto", 15.0));
        getAreaEachRoomExpectedReturn.add(new RoomAreaDTO("Cozinha", 48.0));
        getAreaEachRoomExpectedReturn.add(new RoomAreaDTO("Garagem", 20.0));
        getAreaEachRoomExpectedReturn.add(new RoomAreaDTO("Banheiro", 8.0));

    }

    public static HouseDTO getHouseWithRooms(String name, String district){

        RoomDTO room1 = new RoomDTO("Quarto", 5.0, 3.0);
        RoomDTO room2 = new RoomDTO("Cozinha", 8.0,6.0);
        RoomDTO room3 = new RoomDTO("Garagem", 4.0, 5.0);
        RoomDTO room4 = new RoomDTO("Banheiro", 2.0, 4.0);

        List<RoomDTO> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        roomList.add(room4);

        HouseDTO house = new HouseDTO(name, district, roomList);

        return house;
    }

    public static String houseToString(HouseDTO h) {
        String houseString = "{ \"name\" : \"" + h.getName() + "\", " +
                "\"district\" : \"" + h.getDistrict() + "\", "+
                "\"rooms\" : [ ";

        for (RoomDTO room : h.getRooms()){
            houseString += roomToString(room) + ",";
        }

        houseString = houseString.substring(0, houseString.length() - 1);

        houseString+= "]}";

        return houseString;

    }

    public static String roomToString(RoomDTO room){

        return "{ \"name\" : \"" + room.getName() + "\", " +
                "\"width\" : \"" + room.getWidth() + "\", " +
                "\"length\" : \"" + room.getLength() + "\"}";

    }

}
