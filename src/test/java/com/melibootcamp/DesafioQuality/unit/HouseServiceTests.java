package com.melibootcamp.DesafioQuality.unit;

import com.melibootcamp.DesafioQuality.dtos.HouseDTO;
import com.melibootcamp.DesafioQuality.dtos.RoomAreaDTO;
import com.melibootcamp.DesafioQuality.exceptionHandler.DistrictNotFoundException;
import com.melibootcamp.DesafioQuality.service.HouseService;
import com.melibootcamp.DesafioQuality.utils.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HouseServiceTests {

    @Autowired
    HouseService houseService;

    public static HouseDTO house;

    @BeforeAll
    static void setup(){
        house = TestUtilsGenerator.getHouseWithRooms("Nome da Casa", "Bairro 01");
    }

    @Test
    public void testGetArea() {

        double area = houseService.calcAreaHouse(house);

        assertEquals(91, area);
    }

    @Test
    public void testGetPriceWithExistingDistrict() throws DistrictNotFoundException {

        double price = houseService.priceHouse(house);

        assertEquals(491400, price);
    }

    @Test
    public void testGetPriceWithoutExistingDistrict(){
        HouseDTO houseWrongDistrict = TestUtilsGenerator.getHouseWithRooms("Nome da Casa", "Bairro 1");

        assertThrows(DistrictNotFoundException.class, () -> houseService.priceHouse(houseWrongDistrict));
    }

    @Test
    public void testGetBiggestRoom(){

        String biggestRoom = houseService.biggestRoom(house);

        assertEquals(TestUtilsGenerator.getBiggestRoomExpectedReturn, biggestRoom);
    }

    @Test
    public void testGetAreaEachRoom(){

        List<RoomAreaDTO> roomList = houseService.areaEachRoom(house);

        assertArrayEquals(TestUtilsGenerator.getAreaEachRoomExpectedReturn.toArray(), roomList.toArray());
    }
}
