package com.eod.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eod.entities.EodBhavData;


@Repository
public interface EodBhavRepository extends JpaRepository<EodBhavData, Long> {
	@Query(value = "select t.id, t.symbol, t.series, t.open, t.high, t.low, t.close, t.last, t.prevclose, t.tottrdqty, t.tottrdval, t.timestamp, t.totaltrades, \r\n"
			+ "t.isin from historical_data_eod t where t.timestamp = :date and t.series= :series and t.tottrdqty > :volume", nativeQuery = true)
	public List<EodBhavData> getBhavData(@Param("date")String date, @Param("volume") long volume, @Param("series") String series);

	
}
