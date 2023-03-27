package com.eod.service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.eod.entities.SpurtsOi;
import com.eod.spring.utilities.GenUtils;
import com.opencsv.bean.CsvToBeanBuilder;

public class SpurtsAnalysis {
	static String filePath = "C:\\Users\\Ram\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\spring-batch-example-main\\spring-batch-example-main\\Spurts-in-OI-By-Underlying-18122022.csv";

	// storing CSV data's in to an object list
	@SuppressWarnings("rawtypes")
	public static List<SpurtsOi> addCsvToObject() {
		List<SpurtsOi> spurts = new ArrayList<>();
		try {
			@SuppressWarnings("unchecked")
			List<SpurtsOi> beans = new CsvToBeanBuilder(new FileReader(filePath)).withSkipLines(1)
					.withType(SpurtsOi.class).build().parse();
			spurts = beans;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spurts;
	}

	// Analyze spurts data from stored object
	public Map<String, Long> dataAnalysis() {
		Map<String, Long> sortedValues = new LinkedHashMap<>();
		Map<String, Long> oIincrease = new HashMap<>();
		List<SpurtsOi> fromCsv = addCsvToObject();
		for (SpurtsOi oiData : fromCsv) {
			oIincrease.put(oiData.getSymbol(), oiData.getChgOi());
		}
		sortedValues = GenUtils.descendingMapSort(oIincrease);
		return sortedValues;
	}

}
