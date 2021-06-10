package com.melibootcamp.DesafioQuality.service;

import com.melibootcamp.DesafioQuality.dtos.HouseDTO;
import com.melibootcamp.DesafioQuality.dtos.RoomAreaDTO;
import com.melibootcamp.DesafioQuality.exceptionHandler.DistrictNotFoundException;

import java.util.List;

public interface HouseService {
    double calcAreaHouse(HouseDTO house);
    double priceHouse(HouseDTO house) throws DistrictNotFoundException;
    String biggestRoom(HouseDTO house);
    List<RoomAreaDTO> areaEachRoom(HouseDTO house);

}
