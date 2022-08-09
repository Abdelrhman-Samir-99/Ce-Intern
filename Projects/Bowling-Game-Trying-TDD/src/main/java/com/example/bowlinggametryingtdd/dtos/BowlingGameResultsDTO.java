package com.example.bowlinggametryingtdd.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BowlingGameResultsDTO {
    String name;
    Integer totalScore;
    Boolean hadPerfectGame;
    List<Integer> frameScores;
}
