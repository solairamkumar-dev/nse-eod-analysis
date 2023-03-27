package com.eod.service;

public interface EodBhavDataHandlingService {
	
	public boolean getEodBhav(String fileName);
    public boolean transferEodBhavToDB(String fileName);
}
