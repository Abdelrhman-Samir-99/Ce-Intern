package com.example.bowlinggametryingtdd.service;

import com.example.bowlinggametryingtdd.dtos.BowlingGameResultsDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
public interface IBowlingGameService {
    public BowlingGameResultsDTO getResult(@RequestParam Map<String, byte[]> Players);
}