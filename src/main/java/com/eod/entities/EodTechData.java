package com.eod.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eod_technical_data")
public class EodTechData {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "p_symbol")
	private String p_symbol;
	@Column(name = "last_close")
	private Double last_close;
	@Column(name = "last_volume")
	private Double last_volume;
	@Column(name = "avg_volume")
	private Double avg_volume;
	@Column(name = "pct_change_1_day")
	private Double pct_change_1_day;
	@Column(name = "pct_change_1_week")
	private Double pct_change_1_week;
	@Column(name = "pct_change_1_month")
	private Double pct_change_1_month;
	@Column(name = "pct_change_3_months")
	private Double pct_change_3_months;
	@Column(name = "pct_change_1_year")
	private Double pct_change_1_year;
	@Column(name = "sma_5")
	private Double sma_5;
	@Column(name = "ema_5")
	private Double ema_5;
	@Column(name = "sma_13")
	private Double sma_13;
	@Column(name = "ema_13")
	private Double ema_13;
	@Column(name = "sma_20")
	private Double sma_20;
	@Column(name = "ema_20")
	private Double ema_20;
	@Column(name = "sma_34")
	private Double sma_34;
	@Column(name = "ema_34")
	private Double ema_34;
	@Column(name = "sma_50")
	private Double sma_50;
	@Column(name = "ema_50")
	private Double ema_50;
	@Column(name = "sma_89")
	private Double sma_89;
	@Column(name = "ema_89")
	private Double ema_89;
	@Column(name = "sma_200")
	private Double sma_200;
	@Column(name = "ema_200")
	private Double ema_200;
	@Column(name = "bband_upper")
	private Double bband_upper;
	@Column(name = "bband_lower")
	private Double bband_lower;
	@Column(name = "bband_mid")
	private Double bband_mid;
	@Column(name = "macd")
	private Double macd;
	@Column(name = "macd_signal")
	private Double macd_signal;
	@Column(name = "macd_hist")
	private Double macd_hist;
	@Column(name = "adx")
	private Double adx;
	@Column(name = "dmi_plus")
	private Double dmi_plus;
	@Column(name = "dmi_minus")
	private Double dmi_minus;
	@Column(name = "rsi")
	private Double rsi;
	@Column(name = "stoch_k")
	private Double stoch_k;
	@Column(name = "stoch_d")
	private Double stoch_d;
	@Column(name = "cci")
	private Double cci;
	@Column(name = "psar")
	private Double psar;
	@Column(name = "true_range")
	private Double true_range;
	@Column(name = "atr")
	private Double atr;
	@Column(name = "williams_r")
	private Double williams_r;
	@Column(name = "trix")
	private Double trix;
	@Column(name = "stochrsi_k")
	private Double stochrsi_k;
	@Column(name = "stochrsi_d")
	private Double stochrsi_d;
	@Column(name = "momentum")
	private Double momentum;
	@Column(name = "candle")
	private Double candle;
	@Column(name = "p_date")
	private Date p_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getP_symbol() {
		return p_symbol;
	}

	public void setP_symbol(String p_symbol) {
		this.p_symbol = p_symbol;
	}

	public Double getLast_close() {
		return last_close;
	}

	public void setLast_close(Double last_close) {
		this.last_close = last_close;
	}

	public Double getLast_volume() {
		return last_volume;
	}

	public void setLast_volume(Double last_volume) {
		this.last_volume = last_volume;
	}

	public Double getAvg_volume() {
		return avg_volume;
	}

	public void setAvg_volume(Double avg_volume) {
		this.avg_volume = avg_volume;
	}

	public Double getPct_change_1_day() {
		return pct_change_1_day;
	}

	public void setPct_change_1_day(Double pct_change) {
		this.pct_change_1_day = pct_change;
	}

	public Double getPct_change_1_week() {
		return pct_change_1_week;
	}

	public void setPct_change_1_week(Double pct_change_1_week) {
		this.pct_change_1_week = pct_change_1_week;
	}

	public Double getPct_change_1_month() {
		return pct_change_1_month;
	}

	public void setPct_change_1_month(Double pct_change_1_month) {
		this.pct_change_1_month = pct_change_1_month;
	}

	public Double getPct_change_3_months() {
		return pct_change_3_months;
	}

	public void setPct_change_3_months(Double pct_change_3_months) {
		this.pct_change_3_months = pct_change_3_months;
	}

	public Double getPct_change_1_year() {
		return pct_change_1_year;
	}

	public void setPct_change_1_year(Double pct_change_1_year) {
		this.pct_change_1_year = pct_change_1_year;
	}

	public Double getSma_5() {
		return sma_5;
	}

	public void setSma_5(Double sma_5) {
		this.sma_5 = sma_5;
	}

	public Double getEma_5() {
		return ema_5;
	}

	public void setEma_5(Double ema_5) {
		this.ema_5 = ema_5;
	}

	public Double getSma_13() {
		return sma_13;
	}

	public void setSma_13(Double sma_13) {
		this.sma_13 = sma_13;
	}

	public Double getEma_13() {
		return ema_13;
	}

	public void setEma_13(Double ema_13) {
		this.ema_13 = ema_13;
	}

	public Double getSma_20() {
		return sma_20;
	}

	public void setSma_20(Double sma_20) {
		this.sma_20 = sma_20;
	}

	public Double getEma_20() {
		return ema_20;
	}

	public void setEma_20(Double ema_20) {
		this.ema_20 = ema_20;
	}

	public Double getSma_34() {
		return sma_34;
	}

	public void setSma_34(Double sma_34) {
		this.sma_34 = sma_34;
	}

	public Double getEma_34() {
		return ema_34;
	}

	public void setEma_34(Double ema_34) {
		this.ema_34 = ema_34;
	}

	public Double getSma_50() {
		return sma_50;
	}

	public void setSma_50(Double sma_50) {
		this.sma_50 = sma_50;
	}

	public Double getEma_50() {
		return ema_50;
	}

	public void setEma_50(Double ema_50) {
		this.ema_50 = ema_50;
	}

	public Double getSma_89() {
		return sma_89;
	}

	public void setSma_89(Double sma_89) {
		this.sma_89 = sma_89;
	}

	public Double getEma_89() {
		return ema_89;
	}

	public void setEma_89(Double ema_89) {
		this.ema_89 = ema_89;
	}

	public Double getSma_200() {
		return sma_200;
	}

	public void setSma_200(Double sma_200) {
		this.sma_200 = sma_200;
	}

	public Double getEma_200() {
		return ema_200;
	}

	public void setEma_200(Double ema_200) {
		this.ema_200 = ema_200;
	}

	public Double getBband_upper() {
		return bband_upper;
	}

	public void setBband_upper(Double bband_upper) {
		this.bband_upper = bband_upper;
	}

	public Double getBband_lower() {
		return bband_lower;
	}

	public void setBband_lower(Double bband_lower) {
		this.bband_lower = bband_lower;
	}

	public Double getBband_mid() {
		return bband_mid;
	}

	public void setBband_mid(Double bband_mid) {
		this.bband_mid = bband_mid;
	}

	public Double getMacd() {
		return macd;
	}

	public void setMacd(Double macd) {
		this.macd = macd;
	}

	public Double getMacd_signal() {
		return macd_signal;
	}

	public void setMacd_signal(Double macd_signal) {
		this.macd_signal = macd_signal;
	}

	public Double getMacd_hist() {
		return macd_hist;
	}

	public void setMacd_hist(Double macd_hist) {
		this.macd_hist = macd_hist;
	}

	public Double getAdx() {
		return adx;
	}

	public void setAdx(Double adx) {
		this.adx = adx;
	}

	public Double getDmi_plus() {
		return dmi_plus;
	}

	public void setDmi_plus(Double dmi_plus) {
		this.dmi_plus = dmi_plus;
	}

	public Double getDmi_minus() {
		return dmi_minus;
	}

	public void setDmi_minus(Double dmi_minus) {
		this.dmi_minus = dmi_minus;
	}

	public Double getRsi() {
		return rsi;
	}

	public void setRsi(Double rsi) {
		this.rsi = rsi;
	}

	public Double getStoch_k() {
		return stoch_k;
	}

	public void setStoch_k(Double stoch_k) {
		this.stoch_k = stoch_k;
	}

	public Double getStoch_d() {
		return stoch_d;
	}

	public void setStoch_d(Double stoch_d) {
		this.stoch_d = stoch_d;
	}

	public Double getCci() {
		return cci;
	}

	public void setCci(Double cci) {
		this.cci = cci;
	}

	public Double getPsar() {
		return psar;
	}

	public void setPsar(Double psar) {
		this.psar = psar;
	}

	public Double getTrue_range() {
		return true_range;
	}

	public void setTrue_range(Double true_range) {
		this.true_range = true_range;
	}

	public Double getAtr() {
		return atr;
	}

	public void setAtr(Double atr) {
		this.atr = atr;
	}

	public Double getWilliams_r() {
		return williams_r;
	}

	public void setWilliams_r(Double williams_r) {
		this.williams_r = williams_r;
	}

	public Double getTrix() {
		return trix;
	}

	public void setTrix(Double trix) {
		this.trix = trix;
	}

	public Double getStochrsi_k() {
		return stochrsi_k;
	}

	public void setStochrsi_k(Double stochrsi_k) {
		this.stochrsi_k = stochrsi_k;
	}

	public Double getStochrsi_d() {
		return stochrsi_d;
	}

	public void setStochrsi_d(Double stochrsi_d) {
		this.stochrsi_d = stochrsi_d;
	}

	public Double getMomentum() {
		return momentum;
	}

	public void setMomentum(Double momentum) {
		this.momentum = momentum;
	}

	public Double getCandle() {
		return candle;
	}

	public void setCandle(Double candle) {
		this.candle = candle;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	@Override
	public String toString() {
		return "EodTechData [id=" + id + ", p_symbol=" + p_symbol + ", last_close=" + last_close + ", last_volume="
				+ last_volume + ", avg_volume=" + avg_volume + ", pct_change=" + pct_change_1_day + ", pct_change_1_week="
				+ pct_change_1_week + ", pct_change_1_month=" + pct_change_1_month + ", pct_change_3_months="
				+ pct_change_3_months + ", pct_change_1_year=" + pct_change_1_year + ", sma_5=" + sma_5 + ", ema_5="
				+ ema_5 + ", sma_13=" + sma_13 + ", ema_13=" + ema_13 + ", sma_20=" + sma_20 + ", ema_20=" + ema_20
				+ ", sma_34=" + sma_34 + ", ema_34=" + ema_34 + ", sma_50=" + sma_50 + ", ema_50=" + ema_50
				+ ", sma_89=" + sma_89 + ", ema_89=" + ema_89 + ", sma_200=" + sma_200 + ", ema_200=" + ema_200
				+ ", bband_upper=" + bband_upper + ", bband_lower=" + bband_lower + ", bband_mid=" + bband_mid
				+ ", macd=" + macd + ", macd_signal=" + macd_signal + ", macd_hist=" + macd_hist + ", adx=" + adx
				+ ", dmi_plus=" + dmi_plus + ", dmi_minus=" + dmi_minus + ", rsi=" + rsi + ", stoch_k=" + stoch_k
				+ ", stoch_d=" + stoch_d + ", cci=" + cci + ", psar=" + psar + ", true_range=" + true_range + ", atr="
				+ atr + ", williams_r=" + williams_r + ", trix=" + trix + ", stochrsi_k=" + stochrsi_k + ", stochrsi_d="
				+ stochrsi_d + ", momentum=" + momentum + ", candle=" + candle + ", p_date=" + p_date + "]";
	}

}
