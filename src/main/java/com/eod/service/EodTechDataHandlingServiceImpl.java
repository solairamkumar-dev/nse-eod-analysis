package com.eod.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eod.dataTransfer.EodTechnicalsToDB;
import com.eod.entities.FileDownload;
import com.eod.repo.EodTechRepository;
import com.eod.spring.def.EodDefault;
import com.eod.spring.utilities.GenUtils;

@Service
public class EodTechDataHandlingServiceImpl implements EodTechDataHandlingService{

	@Autowired
	EodTechRepository eodTechRepository;
	@Autowired
	EodTechnicalsToDB eodTechToDB;
	
	@Override
	public boolean downloadEodTechData(FileDownload fileDownload) {
		boolean downloadResult = false;
		try {
			downloadResult = GenUtils.downloadFile(EodDefault.getEodTechUrl(), GenUtils.eodFileName(fileDownload));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return downloadResult;
	}

	@Override
	public boolean uploadEodTechDataToDB(FileDownload fileDownload) {
		boolean uploadResult = false;
		try {
			uploadResult = eodTechToDB.transferEodTechnicalsToDb(fileDownload);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploadResult;
	}

	@Override
	public boolean moveEodTechData(FileDownload fileDownload) {
		boolean fileMovedResult = false;
		try {
			fileMovedResult = GenUtils.moveFile(fileDownload);
		} catch (Exception e) {e.printStackTrace();}
		return fileMovedResult;
	}
	
	
	

}
