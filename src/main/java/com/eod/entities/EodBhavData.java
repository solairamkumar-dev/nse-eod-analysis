package com.eod.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historical_data_eod")
public class EodBhavData {

	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "symbol")
	private String symbol;
	@Column(name = "series")
	private String series;
	@Column(name = "open")
	private double open;
	@Column(name = "high")
	private double high;
	@Column(name = "low")
	private double low;
	@Column(name = "close")
	private double close;
	@Column(name = "last")
	private double last;
	@Column(name = "prevclose")
	private double prevclose;
	@Column(name = "tottrdqty")
	private long tottrdqty;
	@Column(name = "tottrdval")
	private double tottrdval;
	@Column(name = "timestamp")
	private Date timestamp;
	@Column(name = "totaltrades")
	private long totaltrades;
	@Column(name = "isin")
	private String isin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getLast() {
		return last;
	}

	public void setLast(double last) {
		this.last = last;
	}

	public double getPrevclose() {
		return prevclose;
	}

	public void setPrevclose(double prevclose) {
		this.prevclose = prevclose;
	}

	public long getTottrdqty() {
		return tottrdqty;
	}

	public void setTottrdqty(long tottrdqty) {
		this.tottrdqty = tottrdqty;
	}

	public double getTottrdval() {
		return tottrdval;
	}

	public void setTottrdval(double tottrdval) {
		this.tottrdval = tottrdval;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public long getTotaltrades() {
		return totaltrades;
	}

	public void setTotaltrades(long totaltrades) {
		this.totaltrades = totaltrades;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	@Override
	public String toString() {
		return "EodBhavData [id=" + id + ", symbol=" + symbol + ", series=" + series + ", open=" + open + ", high="
				+ high + ", low=" + low + ", close=" + close + ", last=" + last + ", prevclose=" + prevclose
				+ ", tottrdqty=" + tottrdqty + ", tottrdval=" + tottrdval + ", timestamp=" + timestamp
				+ ", totaltrades=" + totaltrades + ", isin=" + isin + "]";
	}

}
