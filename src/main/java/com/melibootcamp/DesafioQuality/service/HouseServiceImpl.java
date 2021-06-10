package com.melibootcamp.DesafioQuality.service;

import com.melibootcamp.DesafioQuality.dtos.HouseDTO;
import com.melibootcamp.DesafioQuality.dtos.RoomAreaDTO;
import com.melibootcamp.DesafioQuality.dtos.RoomDTO;
import com.melibootcamp.DesafioQuality.exceptionHandler.DistrictNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HouseServiceImpl implements HouseService{

    public static final Map<String, Double> districtMap = new HashMap<>();

    static {
        districtMap.put("Bairro 01", 5400.0);
        districtMap.put("Bairro 02", 3000.0);
        districtMap.put("Bairro 03", 2500.0);
        districtMap.put("Bairro 04", 2200.0);
        districtMap.put("Bairro 05", 2000.0);
    }

    @Override
    public double calcAreaHouse(HouseDTO house){
        return house.getRooms().stream().mapToDouble(o -> o.getLength()*o.getWidth()).sum();
    }

    @Override
    public double priceHouse(HouseDTO house) throws DistrictNotFoundException {
        districtExists(house.getDistrict());
        return districtMap.get(house.getDistrict()) * calcAreaHouse(house);
    }

    @Override
    public String biggestRoom(HouseDTO house) {
        RoomDTO biggestRoom = Collections.max(house.getRooms(), Comparator.comparing(r -> r.getWidth()*r.getLength()));
        return "The biggest room is "+biggestRoom.getName()+", it has "+getAreaOfRoom(biggestRoom)+" m².";
    }

    @Override
    public List<RoomAreaDTO> areaEachRoom(HouseDTO house) {
        List<RoomAreaDTO> roomList = new ArrayList<>();
        for(RoomDTO room : house.getRooms()){
            roomList.add(new RoomAreaDTO(room.getName(), getAreaOfRoom(room)));
        }
        return roomList;
    }

    private double getAreaOfRoom(RoomDTO room){
        return room.getLength() * room.getWidth();
    }

    private void districtExists(String district) throws DistrictNotFoundException {
       if(!districtMap.containsKey(district)){
           throw new DistrictNotFoundException("Could not find district with name: " + district +".");
       }
    }
}
