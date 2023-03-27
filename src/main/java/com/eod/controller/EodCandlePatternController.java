package com.eod.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eod.entities.CandleStick;
import com.eod.pattern.CandleStickAnalysis;
import com.eod.spring.def.EodDefault;

@RestController
@RequestMapping("/candleStick")
public class EodCandlePatternController {

	@Autowired
	CandleStickAnalysis candleStickAnalysis;

	List<String> result = new ArrayList<>();

	@PostMapping("/pattern")
	public List<String> getHammerPattern(@RequestBody CandleStick candleStick) {
		try {
			if (candleStick.getPatternName().equals(EodDefault.hammerPattern))
				result = candleStickAnalysis.getHammerPattern(candleStick);
			else if (candleStick.getPatternName().equals(EodDefault.shootingStarpattern))
				result = candleStickAnalysis.getShootingStarPattern(candleStick);
			else if (candleStick.getPatternName().equals(EodDefault.bullishMarubozuPattern))
				result = candleStickAnalysis.getBullishMarubozu(candleStick);
			else if (candleStick.getPatternName().equals(EodDefault.bearishMarubozuPattern))
				result = candleStickAnalysis.getBearishMarubozu(candleStick);

			if (!result.isEmpty()) {
				Collections.sort(result, Comparator.comparingInt(String::length).reversed());
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Arrays.asList("No Data Found");

	}


}
