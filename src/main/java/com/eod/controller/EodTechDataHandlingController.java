package com.eod.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eod.entities.FileDownload;
import com.eod.service.EodTechDataHandlingServiceImpl;

@RestController
@RequestMapping("/techEod")
public class EodTechDataHandlingController {

	@Autowired
	EodTechDataHandlingServiceImpl eodTechDataHandlingServiceImpl;

	@PostMapping(value = "/downloadEodTech")
	public void downloadEodTechData(@RequestBody FileDownload fileDownload) {
		boolean uploadResult = false;
		boolean fileMoveResult = false;
		boolean downloadResult = eodTechDataHandlingServiceImpl.downloadEodTechData(fileDownload);

		if (downloadResult) {
			uploadResult = eodTechDataHandlingServiceImpl.uploadEodTechDataToDB(fileDownload);
		} else
			System.out.println("Download Failed");
		if (uploadResult) {
			fileMoveResult = eodTechDataHandlingServiceImpl.moveEodTechData(fileDownload);
		} else
			System.out.println("Files Uploaded Failed");
		if (fileMoveResult) {
			System.out.println("Files Moved Successfully");
		} else
			System.out.println("Failed to move files");

	}

}
