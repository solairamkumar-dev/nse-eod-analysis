package com.eod.service;

import java.util.Map;

import com.eod.entities.EodBhavAnalysis;

public interface EodBhavDataAnalysisService {
	
	public Map<String,Double> getPriceVolumeIncreaseEod(EodBhavAnalysis eodBhavAnalysis);
	public Map<String,Double> getPriceDecreaseVolumeIncreaseEod(EodBhavAnalysis eodBhavAnalysis);

}
