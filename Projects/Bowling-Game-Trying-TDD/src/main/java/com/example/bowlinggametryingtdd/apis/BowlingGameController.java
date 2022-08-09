package com.example.bowlinggametryingtdd.apis;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.service.IBowlingGameService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class BowlingGameController implements IBowlingGame {
    @Autowired
    IBowlingGameService bowlingGameService;

    @Override
    public BowlingGameResultsDTO getResults(Map<String, byte[]> players) {
        // add some validation on the input before sending it to the service.
        return bowlingGameService.getResult(players);
    }
}
