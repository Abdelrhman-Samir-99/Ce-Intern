package com.example.bowlinggametryingtdd.dtos;

import com.example.bowlinggametryingtdd.utilities.BowlingGameStateUtility;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BowlingGameStateDTOTest {

    BowlingGameStateDTO bowlingGameState;

    @BeforeAll
    public void init() {
        Map<String, byte[]> players = new HashMap<>();
        players.put("Ahmed", new byte[]{9, 1,
            0, 10,
            10,
            10,
            6, 2,
            7, 3,
            8, 2,
            10,
            9, 0,
            10,
            10, 8});
        bowlingGameState = BowlingGameStateDTO.builder().players(players).build();
    }

    @Test
    public void validObjectTest() {
        for(Map.Entry<String, byte[]> player : bowlingGameState.players.entrySet()) {
            Assertions.assertThat(BowlingGameStateUtility.validateName(player.getKey()) &&
                    BowlingGameStateUtility.validateGameSate(player.getValue()))
                    .isEqualTo(true);
        }
    }

    @Test
    public void isSpareTest() {
        Assertions.assertThat(BowlingGameStateUtility.isSpare(new byte[] {5, 5})).isEqualTo(true);
        Assertions.assertThat(BowlingGameStateUtility.isSpare(new byte[] {1, 5})).isEqualTo(false);
    }

    @Test
    public void isStrikeTest() {
        Assertions.assertThat(BowlingGameStateUtility.isStrike(new byte[] {10, 1})).isEqualTo(true);
        Assertions.assertThat(BowlingGameStateUtility.isStrike(new byte[] {1, 2})).isEqualTo(false);
    }

    @Test
    public void totalGameScoreTest() {
        Assertions.assertThat(BowlingGameStateUtility
                        .calculateGameScore(BowlingGameStateUtility
                                .calculateGameFrames(bowlingGameState
                                        .players.get("Ahmed"))))
                .isEqualTo(176);
    }

    @Test
    public void getGameFramesTest() {
        Assertions.assertThat(BowlingGameStateUtility
                    .calculateGameFrames(bowlingGameState
                            .players.get("Ahmed")))
                .isEqualTo(List.of(10, 20, 26, 18, 8, 18, 20, 19, 9, 28));
    }
}
