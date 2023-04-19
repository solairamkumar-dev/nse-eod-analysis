package com.eod.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eod.entities.EodBhavAnalysis;
import com.eod.entities.EodBhavData;
import com.eod.entities.EodTechData;
import com.eod.repo.EodBhavRepository;
import com.eod.repo.EodTechRepository;
import com.eod.spring.def.EodDefault;

@Service
public class EodBhavDataAnalysisServiceImpl implements EodBhavDataAnalysisService {

	@Autowired
	EodBhavRepository eodBhavRepository;
	
	@Autowired
	EodTechRepository eodTechRepository;

	@Override
	public Map<String, Double> getPriceVolumeIncreaseEod(EodBhavAnalysis eodBhavAnalysis) {
		Map<String, Double> result = new HashMap<>();
		List<EodBhavData> bhavBaseData = eodBhavRepository.getBhavData(eodBhavAnalysis.getBaseDate(),
				eodBhavAnalysis.getVolume(), eodBhavAnalysis.getSeries());
		List<EodBhavData> bhavCompareData = eodBhavRepository.getBhavData(eodBhavAnalysis.getCompareDate(),
				eodBhavAnalysis.getVolume(), eodBhavAnalysis.getSeries());

		// Iterator<EodBhavData> baseData = bhavBaseData.iterator();
		// Iterator<EodBhavData> compareData = bhavCompareData.iterator();
		System.out.println(bhavBaseData.size());
		System.out.println(bhavCompareData.size());
		bhavCompareData.forEach(System.out::println);

		for (int i = 0; i < bhavBaseData.size(); i++) {
			EodBhavData baseData = bhavBaseData.get(i);
			for (int j = 0; j < bhavCompareData.size(); j++) {
				EodBhavData compareData = bhavCompareData.get(j);
				{
					if (baseData.getSymbol().equals(compareData.getSymbol())) {
						if ((baseData.getClose() > compareData.getClose())
								&& (baseData.getTottrdqty() > compareData.getTottrdqty())) {
							// condition to check option only
							if (eodBhavAnalysis.getOptionOnly().equals(EodDefault.yesInd)) {
								if (EodDefault.getOptionStocksName().contains(baseData.getSymbol()))
									result.put(baseData.getSymbol(), baseData.getClose());
							} else if (eodBhavAnalysis.getOptionOnly().equals(EodDefault.noInd))
								if (!EodDefault.getOptionStocksName().contains(baseData.getSymbol()))
									result.put(baseData.getSymbol(), baseData.getClose());
						}
					}
				}
			}
		}

		return result;
	}

	@Override
	public Map<String, Double> getPriceDecreaseVolumeIncreaseEod(EodBhavAnalysis eodBhavAnalysis) {
		Map<String, Double> result = new HashMap<>();
		List<EodBhavData> bhavBaseData = eodBhavRepository.getBhavData(eodBhavAnalysis.getBaseDate(),
				eodBhavAnalysis.getVolume(), eodBhavAnalysis.getSeries());
		List<EodBhavData> bhavCompareData = eodBhavRepository.getBhavData(eodBhavAnalysis.getCompareDate(),
				eodBhavAnalysis.getVolume(), eodBhavAnalysis.getSeries());

		// Iterator<EodBhavData> baseData = bhavBaseData.iterator();
		// Iterator<EodBhavData> compareData = bhavCompareData.iterator();
		System.out.println(bhavBaseData.size());
		System.out.println(bhavCompareData.size());
		bhavCompareData.forEach(System.out::println);

		for (int i = 0; i < bhavBaseData.size(); i++) {
			EodBhavData baseData = bhavBaseData.get(i);
			for (int j = 0; j < bhavCompareData.size(); j++) {
				EodBhavData compareData = bhavCompareData.get(j);
				{
					if (baseData.getSymbol().equals(compareData.getSymbol())) {
						if ((baseData.getClose() < compareData.getClose())
								&& (baseData.getTottrdqty() > compareData.getTottrdqty())) {
							// condition to check option only
							if (eodBhavAnalysis.getOptionOnly().equals(EodDefault.yesInd)) {
								if (EodDefault.getOptionStocksName().contains(baseData.getSymbol()))
									result.put(baseData.getSymbol(), baseData.getClose());
							} else if (eodBhavAnalysis.getOptionOnly().equals(EodDefault.noInd))
								if (!EodDefault.getOptionStocksName().contains(baseData.getSymbol()))
									result.put(baseData.getSymbol(), baseData.getClose());
						}
					}
				}
			}
		}

		return result;
	}

	@Override
	public Map<String, Double> getInsideCandle(EodBhavAnalysis eodBhavAnalysis) {
		System.out.println("Rsi From : "+eodBhavAnalysis.getRsiFrom());
		Map<String, Double> result = new HashMap<>();
		List<EodBhavData> bhavBaseData = eodBhavRepository.getBhavData(eodBhavAnalysis.getBaseDate(),
				eodBhavAnalysis.getVolume(), eodBhavAnalysis.getSeries());
		List<EodBhavData> bhavCompareData = eodBhavRepository.getBhavData(eodBhavAnalysis.getCompareDate(),
				eodBhavAnalysis.getVolume(), eodBhavAnalysis.getSeries());
        List<EodTechData> rsiTechData = eodTechRepository.getRsiData(eodBhavAnalysis.getRsiFrom(),eodBhavAnalysis.getRsiTo(),
        		eodBhavAnalysis.getBaseDate());
		for (int i = 0; i < bhavBaseData.size(); i++) {
			EodBhavData baseData = bhavBaseData.get(i);
			for (int j = 0; j < bhavCompareData.size(); j++) {
				EodBhavData compareData = bhavCompareData.get(j);
				{
					if (baseData.getSymbol().equals(compareData.getSymbol())) {
						if (compareData.getHigh() > baseData.getHigh() && compareData.getLow() < baseData.getLow()) {
							// condition to check option only
							if (eodBhavAnalysis.getOptionOnly().equals(EodDefault.yesInd)) {
								if (EodDefault.getOptionStocksName().contains(baseData.getSymbol())) {
									if(!rsiTechData.isEmpty() && rsiTechData.size()>0) {
									rsiTechData.forEach(symbol -> {
										
										if(symbol.getP_symbol().contains(baseData.getSymbol())) {
										result.put(baseData.getSymbol(), baseData.getClose());}
									});
								}
									
								}	
									//result.put(baseData.getSymbol(), baseData.getClose());
							} else if (eodBhavAnalysis.getOptionOnly().equals(EodDefault.noInd))
								if (!EodDefault.getOptionStocksName().contains(baseData.getSymbol())) {
									if(!rsiTechData.isEmpty() && rsiTechData.size()>0) {
										rsiTechData.forEach(symbol -> {
											if(symbol.getP_symbol().contains(baseData.getSymbol())) {
											result.put(baseData.getSymbol(), baseData.getClose());}
										});
									}
								}
						}
					}
				}
			
		}
		
	}
		return result;
}
}