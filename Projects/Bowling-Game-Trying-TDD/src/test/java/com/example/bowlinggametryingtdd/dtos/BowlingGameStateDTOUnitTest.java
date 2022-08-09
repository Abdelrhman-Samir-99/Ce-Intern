package com.example.bowlinggametryingtdd.dtos;

import com.example.bowlinggametryingtdd.utilities.BowlingGameStateUtility;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BowlingGameStateDTOUnitTest {

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

        // https://www.sportspectator.com/fancentral/bowling/bowlscoreboard.jpg
        players.put("Mohamed", new byte[]{6, 3,
                6, 2,
                9, 0,
                7, 2,
                0, 0,
                0, 6,
                5, 4,
                2, 5,
                8, 1,
                5, 2
                });

        players.put("Magdy", new byte[]{10,
                6, 2,
                10,
                10,
                10,
                8, 2,
                0, 5,
                0, 0,
                3, 4,
                10,
                2, 7});

        bowlingGameState = BowlingGameStateDTO.builder().players(players).build();
    }

    @Test
    public void validObjectTest() {
        // Assert
        Assertions.assertThat(BowlingGameStateUtility.validateBowlingStateDTO(bowlingGameState.players)).isEqualTo(true);
    }

    @Test
    public void isSpareTest() {
        // Assert
        Assertions.assertThat(BowlingGameStateUtility.isSpare(new byte[] {5, 5})).isEqualTo(true);
        Assertions.assertThat(BowlingGameStateUtility.isSpare(new byte[] {1, 5})).isEqualTo(false);
    }

    @Test
    public void isStrikeTest() {
        // Assert
        Assertions.assertThat(BowlingGameStateUtility.isStrike(new byte[] {10, 1})).isEqualTo(true);
        Assertions.assertThat(BowlingGameStateUtility.isStrike(new byte[] {1, 2})).isEqualTo(false);
    }

    @Test
    public void totalGameScoreTest() {
        // Arrange, Assert
        Assertions.assertThat(BowlingGameStateUtility
                        .calculateGameScore(BowlingGameStateUtility
                                .calculateGameFrames(bowlingGameState
                                        .players.get("Ahmed"))))
                .isEqualTo(176);

        Assertions.assertThat(BowlingGameStateUtility
                        .calculateGameScore(BowlingGameStateUtility
                                .calculateGameFrames(bowlingGameState
                                        .players.get("Mohamed"))))
                .isEqualTo(73);

        Assertions.assertThat(BowlingGameStateUtility
                        .calculateGameScore(BowlingGameStateUtility
                                .calculateGameFrames(bowlingGameState
                                        .players.get("Magdy"))))
                .isEqualTo(145);
    }

    @Test
    public void getGameFramesTest() {
        // Arrange, Assert
        Assertions.assertThat(BowlingGameStateUtility
                    .calculateGameFrames(bowlingGameState
                            .players.get("Ahmed")))
                .isEqualTo(List.of(10, 20, 26, 18, 8, 18, 20, 19, 9, 28));
    }

    @Test
    public void sortedBowlingGameResultsByTotalScoreTest() {
        // Arrange
        BowlingGameResultsDTO player1 = BowlingGameResultsDTO.builder().name("Ahmed").totalScore(1).hadPerfectGame(false).frameScores(List.of(1)).build();
        BowlingGameResultsDTO player2 = BowlingGameResultsDTO.builder().name("Mohamed").totalScore(5).hadPerfectGame(false).frameScores(List.of(2)).build();
        BowlingGameResultsDTO player3 = BowlingGameResultsDTO.builder().name("Maged").totalScore(2).hadPerfectGame(false).frameScores(List.of(3)).build();
        BowlingGameResultsDTO player4 = BowlingGameResultsDTO.builder().name("Ahmed").totalScore(7).hadPerfectGame(false).frameScores(List.of(1)).build();
        BowlingGameResultsDTO player5 = BowlingGameResultsDTO.builder().name("Mohamed").totalScore(10).hadPerfectGame(false).frameScores(List.of(2)).build();
        BowlingGameResultsDTO player6 = BowlingGameResultsDTO.builder().name("Maged").totalScore(-1).hadPerfectGame(false).frameScores(List.of(3)).build();

        BowlingGameResultsDTO[] result = new BowlingGameResultsDTO[] {player1, player2, player3, player4, player5, player6};

        //Act
        Arrays.sort(result);

        // Assert
        for(int i = 1; i < result.length; ++i) {
            System.out.println(result[i].getTotalScore());
            Assertions.assertThat(result[i].getTotalScore() <= result[i - 1].getTotalScore()).isEqualTo(true);
        }
    }
}
