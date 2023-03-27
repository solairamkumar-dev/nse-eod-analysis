package com.eod.service;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eod.dataTransfer.EodBhavToDB;
import com.eod.entities.FileDownload;
import com.eod.spring.def.EodDefault;
import com.eod.spring.utilities.GenUtils;

@Service
public class EodBhavDataHandlingServiceImpl implements EodBhavDataHandlingService {

	@Autowired
	EodBhavToDB eodBhavToDB;
	
	@Override
	public boolean getEodBhav(String fileName) {
		Boolean fileDownloadStatus, deleteFile = false;
		Boolean unzipFile = false;
		try {
			fileDownloadStatus = GenUtils.downloadFile(new URL(GenUtils.getEodBhavUrl(fileName)),
					GenUtils.getEodBhavUrl(fileName).substring(67));
			if (fileDownloadStatus) {
				System.out.println(GenUtils.getEodBhavUrl(fileName).substring(67) + " is downloaded successfully");
				unzipFile = GenUtils.unzip(EodDefault.filePath + GenUtils.getEodBhavUrl(fileName).substring(67),
						EodDefault.eodBhavSavePath);
			} else
				System.out.println("Error downloading " + GenUtils.getEodBhavUrl(fileName).substring(67)
						+ " file at getEodBhav() service");
			if (unzipFile) {
				System.out.println(GenUtils.getEodBhavUrl(fileName).substring(67) + " is unzipped successfully");
				deleteFile = GenUtils.deleteFile(EodDefault.filePath + GenUtils.getEodBhavUrl(fileName).substring(67));
			} else
				System.out.println(
						"Error uzipping " + GenUtils.getEodBhavUrl(fileName).substring(67) + " file at getEodBhav() service");
			if (deleteFile)
				System.out.println(GenUtils.getEodBhavUrl(fileName).substring(67) + " is deleted successfully");
			else
				System.out.println(
						"Error deleting " + GenUtils.getEodBhavUrl(fileName).substring(67) + " file at getEodBhav() service");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean transferEodBhavToDB(String fileName) {
	    boolean result = eodBhavToDB.transferBhavEodToDB(fileName);
		return result;
	}
	
	

}
