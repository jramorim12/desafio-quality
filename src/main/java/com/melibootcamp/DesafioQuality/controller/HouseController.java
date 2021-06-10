package com.melibootcamp.DesafioQuality.controller;

import com.melibootcamp.DesafioQuality.dtos.HouseDTO;
import com.melibootcamp.DesafioQuality.dtos.RoomAreaDTO;
import com.melibootcamp.DesafioQuality.exceptionHandler.DistrictNotFoundException;
import com.melibootcamp.DesafioQuality.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HouseController {

    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping("/getHouseArea")
    public ResponseEntity getHouseArea(@Valid @RequestBody HouseDTO house){
        return new ResponseEntity<String>("This house has "+houseService.calcAreaHouse(house)+" m².", HttpStatus.OK);
    }

    @PostMapping("/getHousePrice")
    public ResponseEntity getHousePrice(@Valid @RequestBody HouseDTO house) throws DistrictNotFoundException {
        return new ResponseEntity<String>("The price of the house is R$"+houseService.priceHouse(house)+".",HttpStatus.OK);
    }

    @PostMapping("/getBiggestRoom")
    public ResponseEntity getBiggestRoom(@Valid @RequestBody HouseDTO house){
        return new ResponseEntity<String>(houseService.biggestRoom(house), HttpStatus.OK);
    }

    @PostMapping("/areaEachRoom")
    public ResponseEntity areaEachRoom(@Valid @RequestBody HouseDTO house){
        return new ResponseEntity<List<RoomAreaDTO>>(houseService.areaEachRoom(house), HttpStatus.OK);
    }


}
