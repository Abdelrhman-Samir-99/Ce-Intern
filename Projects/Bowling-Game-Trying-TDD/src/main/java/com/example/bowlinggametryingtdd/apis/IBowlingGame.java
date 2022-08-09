package com.example.bowlinggametryingtdd.apis;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/bowling")
public interface IBowlingGame {
    @GetMapping("/results")
    public ResponseEntity<Object> getResults(Map<String, byte[]> players);
}
