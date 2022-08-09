package com.example.bowlinggametryingtdd.utilities;


import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Map;

public class BowlingGameStateUtility {

    public static Boolean validateBowlingStateDTO(Map<String, byte[]> players) {
        Boolean flag = true;
        for(Map.Entry<String, byte[]> player : players.entrySet()) {
            flag &= validateName(player.getKey()) && BowlingGameStateUtility.validateGameSate(player.getValue());
        }
        return flag;
    }
    public static Boolean validateName(String name) {
        return !StringUtils.isBlank(name);
    }

    public static Boolean validateGameSate(byte[] rolls) {
        return checkRollsRange(rolls) && checkRollsNumber(rolls);
    }

    public static boolean isStrike(byte[] frame) {
        return frame[0] == 10;
    }

    public static boolean isSpare(byte[] frame) {
        return frame[0] + frame[1] == 10;
    }

    private static Boolean checkRollsRange(byte[] rolls) {
        for(int i = 0; i < rolls.length; ++i) {
            if(rolls[i] < 0 || rolls[i] > 10) {
                return false;
            }
        }
        return true;
    }

    private static Boolean checkRollsNumber(byte[] rolls) {
        return rolls.length < 22;
    }

    public static Integer calculateGameScore(ArrayList <Integer> frames) {
        int totalScore = 0;
        for(Integer frameScore : frames) {
            totalScore += frameScore;
        }
        return totalScore;
    }

    public static ArrayList<Integer> calculateGameFrames(byte[] rolls) {
        ArrayList <Integer> frames = new ArrayList<Integer>();
        int ptr = 0;
        while(ptr < rolls.length) {
            int totalScore = 0;
            if(rolls[ptr] == 10) {
                // this is a strike
                totalScore = 10 + rolls[ptr + 1] + rolls[ptr + 2];
                if(ptr == rolls.length - 3) {
                    frames.add(totalScore);
                    break; // This was the last bowl
                }
                ++ptr;
            }
            else if(rolls[ptr] + rolls[ptr + 1] == 10) {
                // this is a spare
                totalScore = 10 + rolls[ptr + 2];
                if(ptr == rolls.length - 3) {
                    frames.add(totalScore);
                    break; // these were the last 2 bowls
                }
                ptr += 2;

            }
            else {
                totalScore = rolls[ptr] + rolls[ptr + 1];
                ptr += 2;
            }
            frames.add(totalScore);
        }
        return frames;
    }

    public static Boolean isPerfectGame(Integer score, Integer framesCount) {
        return score == framesCount * 30;
    }
}
