package com.example.bowlinggametryingtdd.apis;


import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.service.IBowlingGameService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class BowlingGameControllerUnitTest {
    @Test
    public void getResultTest() {
        BowlingGameController bowlingGameController = new BowlingGameController();
        IBowlingGameService bowlingServiceMock = Mockito.mock(IBowlingGameService.class);
        bowlingGameController.setBowlingGameService(bowlingServiceMock);

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

        BowlingGameResultsDTO test = BowlingGameResultsDTO.builder().name("Ahmed").totalScore(176).hadPerfectGame(false).build();
        when(bowlingServiceMock.getResult(players)).thenReturn(test);
        ResponseEntity<Object> response = bowlingGameController.getResults(players);
        Assertions.assertNull(response.getClass());
    }
}
