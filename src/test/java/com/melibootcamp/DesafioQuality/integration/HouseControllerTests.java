package com.melibootcamp.DesafioQuality.integration;

import com.melibootcamp.DesafioQuality.dtos.HouseDTO;
import com.melibootcamp.DesafioQuality.utils.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.melibootcamp.DesafioQuality.utils.TestUtilsGenerator.houseToString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HouseControllerTests {

    @Autowired
    private MockMvc mvc;

    public static HouseDTO house;

    @BeforeAll
    static void setup(){
        house = TestUtilsGenerator.getHouseWithRooms("Nome da Casa", "Bairro 01");
    }

    @Test
    public void testGetHouseArea() throws Exception {
        MvcResult result = mvc.perform(post("/getHouseArea")
                .content(houseToString(house))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("This house has 91.0 mÂ².", content);
    }


    @Test
    public void testGetHousePrice() throws Exception {
        MvcResult result = mvc.perform(post("/getHousePrice")
                .content(houseToString(house))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("The price of the house is R$491400.0.", content);
    }

    @Test
    public void testGetBiggestRoom() throws Exception {
        MvcResult result = mvc.perform(post("/getBiggestRoom")
                .content(houseToString(house))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("The biggest room is Cozinha, it has 48.0 mÂ².", content);
    }

    @Test
    public void testGetAreaEachRoom() throws Exception {
        MvcResult result = mvc.perform(post("/areaEachRoom")
                .content(houseToString(house))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        assertEquals("[{\"name\":\"Quarto\",\"area\":15.0},{\"name\":\"Cozinha\",\"area\":48.0},{\"name\":\"Garagem\",\"area\":20.0},{\"name\":\"Banheiro\",\"area\":8.0}]", content);
    }











}
