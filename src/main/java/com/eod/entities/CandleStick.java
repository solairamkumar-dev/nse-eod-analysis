package com.eod.entities;

public class CandleStick {

	private String patternName;
	private long stockVolume = 0;
	private String fileName;
	private String optionOnly;
	
	public CandleStick(){}

	public CandleStick(String patternName, Long stockVolume,String fileName, String optionOnly) {
		super();
		this.patternName = patternName;
		this.stockVolume = stockVolume;
		this.fileName = fileName;
		this.optionOnly = optionOnly;
	}

	public String getPatternName() {
		return patternName;
	}

	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}

	public long getStockVolume() {
		return stockVolume;
	}

	public void setStockVolume(long stockVolume) {
		this.stockVolume = stockVolume;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOptionOnly() {
		return optionOnly;
	}

	public void setOptionOnly(String optionOnly) {
		this.optionOnly = optionOnly;
	}
	
	
	

}
