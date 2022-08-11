package com.example.bowlinggametryingtdd.service;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.dtos.BowlingGameStateDTO;
import com.example.bowlinggametryingtdd.utilities.BowlingGameStateUtility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class BowlingGameService implements IBowlingGameService {

    @Override
    public List<BowlingGameResultsDTO> getResult(BowlingGameStateDTO Players) {
        Map <String, byte[]> players = Players.getPlayers();
        BowlingGameResultsDTO[] results = new BowlingGameResultsDTO[players.size()];

        int ptr = 0;
        for(Map.Entry<String, byte[]> player : players.entrySet()) {
            List <Integer> framesScore = BowlingGameStateUtility.calculateGameFrames(player.getValue());
            int totalScore = BowlingGameStateUtility.calculateGameScore((ArrayList)framesScore);
            BowlingGameResultsDTO result = BowlingGameResultsDTO.builder().name(player.getKey())
                    .totalScore(totalScore)
                    .frameScores(framesScore)
                    .hadPerfectGame(BowlingGameStateUtility.isPerfectGame(totalScore, framesScore.size()))
                    .build();
            results[ptr++] = result;
        }

        Arrays.sort(results);
        return List.of(results);
    }
}
