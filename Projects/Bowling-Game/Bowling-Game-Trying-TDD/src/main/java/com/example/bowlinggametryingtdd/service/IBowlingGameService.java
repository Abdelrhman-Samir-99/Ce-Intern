package com.example.bowlinggametryingtdd.service;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import com.example.bowlinggametryingtdd.dtos.BowlingGameStateDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface IBowlingGameService {
    public List<BowlingGameResultsDTO> getResult(BowlingGameStateDTO Players);
}