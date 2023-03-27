package com.eod.entities;

public class EodBhavAnalysis {

	private String baseDate;
	private String compareDate;
	private long volume = 0;
	private String series = "EQ";
	private String optionOnly;

	public EodBhavAnalysis(String baseDate, String compareDate, long volume, String series, String optionOnly) {
		super();
		this.baseDate = baseDate;
		this.compareDate = compareDate;
		this.volume = volume;
		this.series = series;
		this.optionOnly = optionOnly;
	}

	public String getBaseDate() {
		return baseDate;
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	public String getCompareDate() {
		return compareDate;
	}

	public void setCompareDate(String compareDate) {
		this.compareDate = compareDate;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getOptionOnly() {
		return optionOnly;
	}

	public void setOptionOnly(String optionOnly) {
		this.optionOnly = optionOnly;
	}
	
	

}
