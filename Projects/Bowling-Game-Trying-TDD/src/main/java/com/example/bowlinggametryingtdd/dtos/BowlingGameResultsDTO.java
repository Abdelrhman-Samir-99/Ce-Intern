package com.example.bowlinggametryingtdd.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Data
public class BowlingGameResultsDTO implements  Comparable <BowlingGameResultsDTO> {
    String name;
    Integer totalScore;
    Boolean hadPerfectGame;
    List<Integer> frameScores;

    @Override
    public int compareTo(BowlingGameResultsDTO rhs) {
        return rhs.getTotalScore() - this.totalScore;
    }
}
