package com.eod.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eod.entities.EodTechData;

@Repository
public interface EodTechRepository extends JpaRepository<EodTechData, Long> {
	@Query(value = "SELECT * FROM eod_technical_data WHERE p_date = '2023-03-01'", nativeQuery = true)
	public List<EodTechData> getAllEodTechData();
	
	@Query(value = "select `eod_technical_data`.`id`,\r\n"
			+ "    `eod_technical_data`.`p_symbol`,\r\n"
			+ "    `eod_technical_data`.`last_close`,\r\n"
			+ "    `eod_technical_data`.`last_volume`,\r\n"
			+ "    `eod_technical_data`.`avg_volume`,\r\n"
			+ "    `eod_technical_data`.`pct_change_1_day`,\r\n"
			+ "    `eod_technical_data`.`pct_change_1_week`,\r\n"
			+ "    `eod_technical_data`.`pct_change_1_month`,\r\n"
			+ "    `eod_technical_data`.`pct_change_3_months`,\r\n"
			+ "    `eod_technical_data`.`pct_change_1_year`,\r\n"
			+ "    `eod_technical_data`.`sma_5`,\r\n"
			+ "    `eod_technical_data`.`ema_5`,\r\n"
			+ "    `eod_technical_data`.`sma_13`,\r\n"
			+ "    `eod_technical_data`.`ema_13`,\r\n"
			+ "    `eod_technical_data`.`sma_20`,\r\n"
			+ "    `eod_technical_data`.`ema_20`,\r\n"
			+ "    `eod_technical_data`.`sma_34`,\r\n"
			+ "    `eod_technical_data`.`ema_34`,\r\n"
			+ "    `eod_technical_data`.`sma_50`,\r\n"
			+ "    `eod_technical_data`.`ema_50`,\r\n"
			+ "    `eod_technical_data`.`sma_89`,\r\n"
			+ "    `eod_technical_data`.`ema_89`,\r\n"
			+ "    `eod_technical_data`.`sma_200`,\r\n"
			+ "    `eod_technical_data`.`ema_200`,\r\n"
			+ "    `eod_technical_data`.`bband_upper`,\r\n"
			+ "    `eod_technical_data`.`bband_lower`,\r\n"
			+ "    `eod_technical_data`.`bband_mid`,\r\n"
			+ "    `eod_technical_data`.`macd`,\r\n"
			+ "    `eod_technical_data`.`macd_signal`,\r\n"
			+ "    `eod_technical_data`.`macd_hist`,\r\n"
			+ "    `eod_technical_data`.`adx`,\r\n"
			+ "    `eod_technical_data`.`dmi_plus`,\r\n"
			+ "    `eod_technical_data`.`dmi_minus`,\r\n"
			+ "    `eod_technical_data`.`rsi`,\r\n"
			+ "    `eod_technical_data`.`stoch_k`,\r\n"
			+ "    `eod_technical_data`.`stoch_d`,\r\n"
			+ "    `eod_technical_data`.`cci`,\r\n"
			+ "    `eod_technical_data`.`psar`,\r\n"
			+ "    `eod_technical_data`.`true_range`,\r\n"
			+ "    `eod_technical_data`.`atr`,\r\n"
			+ "    `eod_technical_data`.`williams_r`,\r\n"
			+ "    `eod_technical_data`.`trix`,\r\n"
			+ "    `eod_technical_data`.`stochrsi_k`,\r\n"
			+ "    `eod_technical_data`.`stochrsi_d`,\r\n"
			+ "    `eod_technical_data`.`momentum`,\r\n"
			+ "    `eod_technical_data`.`candle`,\r\n"
			+ "    `eod_technical_data`.`p_date` from eod_technical_data eod_technical_data where rsi between :rsiFrom and :rsiTo and p_date = :baseDate", nativeQuery = true)
	public List<EodTechData> getRsiData(@Param("rsiFrom")double rsiFrom, @Param("rsiTo")double rsiTo, @Param("baseDate") String baseDate);
}
