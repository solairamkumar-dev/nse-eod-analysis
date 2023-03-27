package com.eod.entities;

public class FileDownload {

	private String downloadDate;
	private String fileName;

	public String getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "FileDownload [downloadDate=" + downloadDate + ", fileName=" + fileName + "]";
	}
	

	

}
