package com.eod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eod.entities.FileDownload;
import com.eod.service.EodBhavDataHandlingServiceImpl;

@RestController
@RequestMapping("/bhavEod")
public class EodBhavDataHandlingController {

	@Autowired
	EodBhavDataHandlingServiceImpl eodBhavDataHandlingServiceImpl;

	@PostMapping(value = "/getEodBhav")
	public void getEodBhavCopy(@RequestBody FileDownload fileDownload) {
		try {
			System.out.println("FileName : "+fileDownload.getFileName());
			boolean result = eodBhavDataHandlingServiceImpl.getEodBhav(fileDownload.getFileName());
			if (result)
				System.out.println("getEodBhavCopy() controller call completed successfully");
			else
				System.out.println("Error executiong getEodBhavCopy() controller call");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value="/transferEodBhavToDB")
	public void transferEodBhavToDB(@RequestBody FileDownload fileDownload) {
		try {
			eodBhavDataHandlingServiceImpl.transferEodBhavToDB(fileDownload.getFileName());
		} catch (Exception e) {e.printStackTrace();}
	}
	
	
}
