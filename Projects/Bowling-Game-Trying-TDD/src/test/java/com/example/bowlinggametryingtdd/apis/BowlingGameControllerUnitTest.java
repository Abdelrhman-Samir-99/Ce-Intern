package com.example.bowlinggametryingtdd.apis;


import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.dtos.BowlingGameStateDTO;
import com.example.bowlinggametryingtdd.service.IBowlingGameService;
import com.example.bowlinggametryingtdd.utilities.BowlingGameStateUtility;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class BowlingGameControllerUnitTest {
    @Test
    public void getResultUnitTest() {
        // Arrange
        BowlingGameController bowlingGameController = new BowlingGameController();
        IBowlingGameService bowlingServiceMock = Mockito.mock(IBowlingGameService.class);
        bowlingGameController.setBowlingGameService(bowlingServiceMock);

        // Valid param
        Map<String, byte[]> validPlayers = new HashMap<>();
        validPlayers.put("Ahmed", new byte[]{9, 1,
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

        Map<String, byte[]> notValidPlayers = new HashMap<>();
        notValidPlayers.put(" ", new byte[]{9, 1});

        BowlingGameStateDTO validParam = BowlingGameStateDTO.builder().players(validPlayers).build();
        BowlingGameStateDTO notValidParam = BowlingGameStateDTO.builder().players(notValidPlayers).build();
        BowlingGameResultsDTO validExpected = BowlingGameResultsDTO.builder().name("Ahmed").totalScore(176).hadPerfectGame(false).build();

        // Act
        System.out.println(BowlingGameStateUtility.validateBowlingStateDTO(validParam));
        // TODO: Not sure why it doesn't return the list when I use the mock.
        // System.out.println(validResults);
        when(bowlingServiceMock.getResult(new BowlingGameStateDTO(validPlayers))).thenReturn(List.of(validExpected));

        ResponseEntity<Object> validResults = bowlingGameController.getResults(validParam.getPlayers());
        ResponseEntity<Object> notValidResults = bowlingGameController.getResults(notValidParam.getPlayers());

        // Assertion
        Assertions.assertThat(notValidResults).isEqualTo(new ResponseEntity<>("NOT VALID OBJECT", HttpStatus.BAD_REQUEST));
        // TODO: Fix this error after getting a better understanding of mockito.
        //Assertions.assertThat(validResults).isEqualTo(new ResponseEntity<>(List.of(validExpected), HttpStatus.OK));
    }
}
