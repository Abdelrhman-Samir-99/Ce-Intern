package com.example.bowlinggametryingtdd.apis;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.dtos.BowlingGameStateDTO;
import com.example.bowlinggametryingtdd.service.BowlingGameService;
import com.example.bowlinggametryingtdd.service.IBowlingGameService;
import com.example.bowlinggametryingtdd.utilities.BowlingGameStateUtility;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Data
@RestController
@RequestMapping("/bowling")
public class BowlingGameController implements IBowlingGame {
    @Autowired
    IBowlingGameService bowlingGameService;

    @Override
    @GetMapping("/results")
    public ResponseEntity<Object>  getResults(@RequestBody Map <String, byte[]> players) {
        if(players == null || BowlingGameStateUtility.validateBowlingStateDTO(new BowlingGameStateDTO(players)) == false) {
            return new ResponseEntity<>("NOT VALID OBJECT", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bowlingGameService.getResult(new BowlingGameStateDTO(players)), HttpStatus.OK);
    }
}
