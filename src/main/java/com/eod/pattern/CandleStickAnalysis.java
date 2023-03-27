package com.eod.pattern;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eod.entities.CandleStick;
import com.eod.spring.def.EodDefault;
import com.eod.spring.utilities.GenUtils;

@Service
public class CandleStickAnalysis {
	// for manual file "\\cm10MAR2023bhav.csv"
	// String filePath = "D:\\EodBhav\\cm20MAR2023bhav.csv";
	List<String> result = new ArrayList<>();

	public List<String> getHammerPattern(CandleStick candleStick) {
		result.clear();
		String filePath = EodDefault.eodBhavSavePath
				+ GenUtils.getEodBhavUrl(candleStick.getFileName()).substring(67, 86);
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
			String lineText = null;
			lineReader.readLine();
			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				double low = Double.parseDouble(data[4]);
				double high = Double.parseDouble(data[3]);
				double close = Double.parseDouble(data[5]);
				double open = Double.parseDouble(data[2]);
				String series = data[1];
				double candleLength = high - low;

				if (close > open && series.equals("EQ") && Long.parseLong(data[8]) > candleStick.getStockVolume()) {
					double openLowPct = ((open - low) / candleLength) * 100;
					if (openLowPct > 65) {
						if (candleStick.getOptionOnly().equals(EodDefault.yesInd)) {
							if (EodDefault.getOptionStocksName().contains(data[0]))
								result.add("Hammer Option Stock: " + data[0]);
						} else if (candleStick.getOptionOnly().equals(EodDefault.noInd)) {
							if (!EodDefault.getOptionStocksName().contains(data[0]))
								result.add("Hammer Stock: " + data[0]);
						}
					}
				}
			}
			lineReader.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	public List<String> getShootingStarPattern(CandleStick candleStick) {
		result.clear();
		String filePath = EodDefault.eodBhavSavePath
				+ GenUtils.getEodBhavUrl(candleStick.getFileName()).substring(67, 86);
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
			String lineText = null;
			lineReader.readLine();
			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				double low = Double.parseDouble(data[4]);
				double high = Double.parseDouble(data[3]);
				double close = Double.parseDouble(data[5]);
				double open = Double.parseDouble(data[2]);
				String series = data[1];
				double candleLength = high - low;
				if (close < open && series.equals("EQ") && Long.parseLong(data[8]) > candleStick.getStockVolume()) {
					double openHighPct = ((high - open) / candleLength) * 100;
					if (openHighPct > 65) {
						if (candleStick.getOptionOnly().equals(EodDefault.yesInd)) {
							if (EodDefault.getOptionStocksName().contains(data[0]))
								result.add("ShootingStar Option Stock: " + data[0]);
						} else if (candleStick.getOptionOnly().equals(EodDefault.noInd)) {
							if (!EodDefault.getOptionStocksName().contains(data[0]))
								result.add("ShootingStar Stock: " + data[0]);
						}
					}
				}
			}
			lineReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<String> getBullishMarubozu(CandleStick candleStick) {
		String filePath = EodDefault.eodBhavSavePath
				+ GenUtils.getEodBhavUrl(candleStick.getFileName()).substring(67, 86);
		result.clear();
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
			String lineText = null;
			lineReader.readLine();
			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				double low = Double.parseDouble(data[4]);
				double high = Double.parseDouble(data[3]);
				double close = Double.parseDouble(data[5]);
				double open = Double.parseDouble(data[2]);
				String series = data[1];
				double candleLength = high - low;
				// super bullish marubozu condition
				if (high == close && low == open && series.equals("EQ")
						&& Long.parseLong(data[8]) > candleStick.getStockVolume()) {
					double highLowPct = (candleLength / close) * 100;
					if (highLowPct > 5) {
						if (candleStick.getOptionOnly().equals(EodDefault.yesInd)) {
							if (EodDefault.getOptionStocksName().contains(data[0])) {
								result.add("Super Bullish Marubozu Option Stocks: " + data[0]);
							}
						} else if (candleStick.getOptionOnly().equals(EodDefault.noInd)) {
							if (!EodDefault.getOptionStocksName().contains(data[0])) {
								result.add("Super Bullish Marubozu : " + data[0]);
							}
						}
					}
					// bullish marubozu condition
				} else if (close <= high && open >= low) {
					double highClosePct = ((high - close) / candleLength) * 100;
					double lowOpenPct = ((open - low) / candleLength) * 100;
					if (highClosePct < 20 && lowOpenPct < 20 && series.equals("EQ")
							&& Long.parseLong(data[8]) > candleStick.getStockVolume()) {
						if (candleStick.getOptionOnly().equals(EodDefault.yesInd)) {
							if (EodDefault.getOptionStocksName().contains(data[0])) {
								result.add("Bullish Marubozu Option Stocks: " + data[0]);
							}
						} else if (candleStick.getOptionOnly().equals(EodDefault.noInd)) {
							if (!EodDefault.getOptionStocksName().contains(data[0])) {
								result.add("Bullish Marubozu : " + data[0]);
							}
						}
					}
				}

			}
			lineReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<String> getBearishMarubozu(CandleStick candleStick) {
		String filePath = EodDefault.eodBhavSavePath
				+ GenUtils.getEodBhavUrl(candleStick.getFileName()).substring(67, 86);
		result.clear();
		try {
			BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
			String lineText = null;
			lineReader.readLine();
			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				double low = Double.parseDouble(data[4]);
				double high = Double.parseDouble(data[3]);
				double close = Double.parseDouble(data[5]);
				double open = Double.parseDouble(data[2]);
				String series = data[1];
				double candleLength = high - low;
				// super bearish marubozu condition
				if (high == open && low == close && series.equals("EQ")
						&& Long.parseLong(data[8]) > candleStick.getStockVolume()) {
					double highLowPct = (candleLength / open) * 100;
					if (highLowPct > 5) {
						if (candleStick.getOptionOnly().equals(EodDefault.yesInd)) {
							if (EodDefault.getOptionStocksName().contains(data[0])) {
								System.out.println("At Super Bearish");
								result.add("Super Bearish Marubozu Option Stocks: " + data[0]);
							}
						} else if (candleStick.getOptionOnly().equals(EodDefault.noInd)) {
							if (!EodDefault.getOptionStocksName().contains(data[0])) {
								result.add("Super Bearish Marubozu Stocks: " + data[0]);
							}
						}
					}
					// bearish marubozu condition
				} else if (open <= high && close >= low) {
					double highOpenPct = ((high - open) / candleLength) * 100;
					double lowClosePct = ((close - low) / candleLength) * 100;
					if (highOpenPct < 20 && lowClosePct < 20 && series.equals("EQ")
							&& Long.parseLong(data[8]) > candleStick.getStockVolume()) {
						if (candleStick.getOptionOnly().equals(EodDefault.yesInd)) {
							if (EodDefault.getOptionStocksName().contains(data[0])) {
								result.add("Bearish Marubozu Option Stocks: " + data[0]);
							}
						} else if (candleStick.getOptionOnly().equals(EodDefault.noInd)) {
							if (!EodDefault.getOptionStocksName().contains(data[0]))
								result.add("Bearish Marubozu Stocks : " + data[0]);
						}
					}

				}
			}

			lineReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
