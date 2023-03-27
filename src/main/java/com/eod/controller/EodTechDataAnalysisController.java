package com.eod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eod.entities.EodTechData;
import com.eod.service.EodTechDataAnalysisServiceImpl;

@RestController
@RequestMapping("/eod")
public class EodTechDataAnalysisController {

	@Autowired
	EodTechDataAnalysisServiceImpl eodTechDataAnalysisServiceImpl;

	@GetMapping(value = "/getAllEodData")
	public List<EodTechData> getAllEodData() {
		return eodTechDataAnalysisServiceImpl.getAllEodTechData();
	}
}
