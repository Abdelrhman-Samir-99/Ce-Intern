package com.example.bowlinggametryingtdd.apis;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.service.IBowlingGameService;
import com.example.bowlinggametryingtdd.utilities.BowlingGameStateUtility;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Data
public class BowlingGameController implements IBowlingGame {
    @Autowired
    IBowlingGameService bowlingGameService;

    @Override
    public ResponseEntity<Object>  getResults(Map<String, byte[]> players) {
        if(BowlingGameStateUtility.validateBowlingStateDTO(players) == false) {
            return new ResponseEntity<>("NOT VALID OBJECT", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bowlingGameService.getResult(players), HttpStatus.OK);
    }


}
