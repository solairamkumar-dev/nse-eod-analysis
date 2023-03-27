package com.eod.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eod.entities.EodTechData;

@Repository
public interface EodTechRepository extends JpaRepository<EodTechData, Long> {
	@Query(value = "SELECT * FROM eod_technical_data WHERE p_date = '2023-03-01'", nativeQuery = true)
	public List<EodTechData> getAllEodTechData();
}
