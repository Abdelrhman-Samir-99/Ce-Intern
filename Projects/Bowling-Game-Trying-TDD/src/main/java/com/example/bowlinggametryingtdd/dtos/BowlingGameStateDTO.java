package com.example.bowlinggametryingtdd.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class BowlingGameStateDTO {
    Map<String, byte[]> players;

    public BowlingGameStateDTO(Map<String, byte[]> players) {
        this.players = players;
    }
}
