package com.example.bowlinggametryingtdd.dtos;

import lombok.Builder;

import java.util.Map;

@Builder
public class BowlingGameStateDTO {
    Map<String, byte[]> players;
}
