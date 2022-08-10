package com.example.bowlinggametryingtdd.apis;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.dtos.BowlingGameStateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface IBowlingGame {
    public ResponseEntity<Object> getResults(@RequestBody Map<String, byte[]> players);
}
