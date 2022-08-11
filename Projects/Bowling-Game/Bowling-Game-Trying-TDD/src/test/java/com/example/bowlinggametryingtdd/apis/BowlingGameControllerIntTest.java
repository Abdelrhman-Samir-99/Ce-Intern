package com.example.bowlinggametryingtdd.apis;


import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BowlingGameControllerIntTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper; // Mapping JSON to object and objects to JSON (has its own dependency)

    int port = 8080;
    @Test
    public void validPlayersIntTest() throws Exception {
        // Arrange
        Map<String, byte[]> players = new HashMap<>();
        players.put("Ahmed", new byte[]{9, 1,
                0, 10,
                10,
                10,
                6, 2,
                7, 3,
                8, 2,
                10,
                9, 0,
                10,
                10, 8});

        // https://www.sportspectator.com/fancentral/bowling/bowlscoreboard.jpg
        players.put("Mohamed", new byte[]{6, 3,
                6, 2,
                9, 0,
                7, 2,
                0, 0,
                0, 6,
                5, 4,
                2, 5,
                8, 1,
                5, 2
        });

        players.put("Magdy", new byte[]{10,
                6, 2,
                10,
                10,
                10,
                8, 2,
                0, 5,
                0, 0,
                3, 4,
                10,
                2, 7});

        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriterw = objectMapper.writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(players);

        // Act
        final ResultActions result = this.mvc
                .perform(MockMvcRequestBuilders.get(createUrl("/bowling/results"))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON_VALUE));
        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void notValidPlayersIntTest() throws Exception {
        // Arrange
        Map<String, byte[]> players = new HashMap<>();
        players.put(" ", new byte[]{9, 1,
                0, 10,
                10,
                10,
                6, 2,
                7, 3,
                8, 2,
                10,
                9, 0,
                10,
                10, 8});

        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriterw = objectMapper.writer().withDefaultPrettyPrinter();
        String requestBody = objectMapper.writeValueAsString(players);

        // Act
        final ResultActions result = this.mvc
                .perform(MockMvcRequestBuilders.get(createUrl("/bowling/results"))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON_VALUE));
        // Assert
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    public String createUrl(String s) {
        return "http://localhost:" + port + s;
    }
}
