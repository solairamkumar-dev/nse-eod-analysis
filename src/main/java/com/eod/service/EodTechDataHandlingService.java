package com.eod.service;

import com.eod.entities.FileDownload;

public interface EodTechDataHandlingService {

	public boolean downloadEodTechData(FileDownload fileDownload);
	public boolean uploadEodTechDataToDB(FileDownload fileDownload);
	public boolean moveEodTechData(FileDownload fileDownload);
}
