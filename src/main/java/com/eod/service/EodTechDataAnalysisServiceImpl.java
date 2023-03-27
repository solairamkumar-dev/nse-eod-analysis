package com.eod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eod.entities.EodTechData;
import com.eod.repo.EodTechRepository;

@Service
public class EodTechDataAnalysisServiceImpl implements EodTechDataAnalysisService {

	@Autowired
	EodTechRepository eodTechRepository;

	@Override
	public List<EodTechData> getAllEodTechData() {
		List<EodTechData> allEodData = eodTechRepository.getAllEodTechData();
		return allEodData;
	}

}
