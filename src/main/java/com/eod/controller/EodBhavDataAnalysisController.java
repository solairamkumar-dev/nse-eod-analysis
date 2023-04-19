package com.eod.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eod.entities.EodBhavAnalysis;
import com.eod.service.EodBhavDataAnalysisService;

@RestController
@RequestMapping("/analysis/bhav")
public class EodBhavDataAnalysisController {

	@Autowired
	EodBhavDataAnalysisService eodBhavDataAnalysisService;

	@PostMapping(value = "/priceVolIncrease")
	public Map<String, Double> getPriceVolumeIncreaseEod(@RequestBody EodBhavAnalysis eodBhavAnalysis) {
		return eodBhavDataAnalysisService.getPriceVolumeIncreaseEod(eodBhavAnalysis);
	}

	@PostMapping(value = "/priceDecVolIncrease")
	public Map<String, Double> getPriceDecreaseVolIncrease(@RequestBody EodBhavAnalysis eodBhavAnalysis) {
		return eodBhavDataAnalysisService.getPriceDecreaseVolumeIncreaseEod(eodBhavAnalysis);
	}
	
	@PostMapping(value = "/insideCanlde")
	public Map<String,Double> getInsideCandle(@RequestBody EodBhavAnalysis eodBhavAnalysis) {
		return eodBhavDataAnalysisService.getInsideCandle(eodBhavAnalysis);
	}
}
