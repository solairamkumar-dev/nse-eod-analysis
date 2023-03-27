package com.eod.spring.def;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import com.eod.spring.utilities.GenUtils;

public class EodDefault {

	public static String jdbcURL = "jdbc:mysql://localhost:3306/stockeod";
	public static String userName = "root";
	public static String passWord = "root";
	public static String eodBhavSavePath = "D:\\EodBhav\\";
	public static String eodDataSavePath = "D:\\EodData\\";
	public static String filePath = "C:\\Users\\Ram\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\spring-batch-example-main\\spring-batch-example-main\\";
	public static String hammerPattern = "HAMMER";
	public static String shootingStarpattern = "SHOTTING_STAR";
	public static String bullishMarubozuPattern = "BULLISH_MARUBOZU";
	public static String bearishMarubozuPattern = "BEARISH_MARUBOZU";
    public static String yesInd = "Y";
    public static String noInd = "N";
	public static URL getEodTechUrl() throws MalformedURLException {
		URL url = new URL("https://main.icharts.in/includes/screener/EODScan.php?export=1");
		return url;
	}

	public static List<String> getOptionStocksName() {
		List<String> optionStocksName = new LinkedList<>();
		optionStocksName.add("ABCAPITAL");
		optionStocksName.add("ABBOTINDIA");
		optionStocksName.add("ABFRL");
		optionStocksName.add("AMBUJACEM");
		optionStocksName.add("ADANIENT");
		optionStocksName.add("ASHOKLEY");
		optionStocksName.add("APOLLOHOSP");
		optionStocksName.add("ASIANPAINT");
		optionStocksName.add("AUBANK  ");
		optionStocksName.add("AUROPHARMA");
		optionStocksName.add("ALKEM");
		optionStocksName.add("ACC");
		optionStocksName.add("BAJAJ-AUTO");
		optionStocksName.add("ASTRA");
		optionStocksName.add("BAJAJFINSV");
		optionStocksName.add("BAJFINANCE");
		optionStocksName.add("BALKRISIND");
		optionStocksName.add("BATAINDIA");
		optionStocksName.add("BEL");
		optionStocksName.add("BHARTIARTL");
		optionStocksName.add("BIOCON");
		optionStocksName.add("BOSCHLTD");
		optionStocksName.add("BPCL");
		optionStocksName.add("BRITANNIA");
		optionStocksName.add("BSOFT");
		optionStocksName.add("BHEL");
		optionStocksName.add("CANBK");
		optionStocksName.add("CANFINHOME");
		optionStocksName.add("CHAMBLFERT");
		optionStocksName.add("CIPLA");
		optionStocksName.add("COLPAL");
		optionStocksName.add("CONCOR");
		optionStocksName.add("COROMANDEL");
		optionStocksName.add("CROMPTON");
		optionStocksName.add("CUB");
		optionStocksName.add("CUMMINSIND");
		optionStocksName.add("DELTACORP");
		optionStocksName.add("EICHERMOT");
		optionStocksName.add("EXIDEIND");
		optionStocksName.add("FEDERALBNK");
		optionStocksName.add("GAIL");
		optionStocksName.add("GLENMARK");
		optionStocksName.add("GMRINFRA");
		optionStocksName.add("GNFC");
		optionStocksName.add("GODREJCP");
		optionStocksName.add("GRASIM");
		optionStocksName.add("GUJGASLTD");
		optionStocksName.add("HAL");
		optionStocksName.add("HDFC");
		optionStocksName.add("ABB");
		optionStocksName.add("HDFCBANK");
		optionStocksName.add("HDFCLIFE");
		optionStocksName.add("HEROMOTOCO");
		optionStocksName.add("HINDPETRO");
		optionStocksName.add("HONAUT");
		optionStocksName.add("ICICIBANK");
		optionStocksName.add("HINDALCO");
		optionStocksName.add("IDFC");
		optionStocksName.add("IDFCFIRSTB");
		optionStocksName.add("IGL");
		optionStocksName.add("INDHOTEL");
		optionStocksName.add("INDIGO");
		optionStocksName.add("INDUSINDBK");
		optionStocksName.add("INFY");
		optionStocksName.add("INTELLECT");
		optionStocksName.add("HINDUNILVR");
		optionStocksName.add("IOC");
		optionStocksName.add("IPCALAB");
		optionStocksName.add("IRCTC");
		optionStocksName.add("IBULHSGFIN");
		optionStocksName.add("ICICIGI");
		optionStocksName.add("ITC");
		optionStocksName.add("JINDALSTEL");
		optionStocksName.add("JKCEMENT");
		optionStocksName.add("L&TFH");
		optionStocksName.add("LALPATHLAB");
		optionStocksName.add("JSWSTEEL");
		optionStocksName.add("LT");
		optionStocksName.add("LTIM");
		optionStocksName.add("LTTS");
		optionStocksName.add("LUPIN");
		optionStocksName.add("M&M");
		optionStocksName.add("M&MFIN");
		optionStocksName.add("MANAPPURAM");
		optionStocksName.add("MARICO");
		optionStocksName.add("MPHASIS");
		optionStocksName.add("MRF");
		optionStocksName.add("NMDC");
		optionStocksName.add("NATIONALUM");
		optionStocksName.add("NAUKRI");
		optionStocksName.add("NESTLEIND");
		optionStocksName.add("OBEROIRLTY");
		optionStocksName.add("AXISBANK");
		optionStocksName.add("OFSS");
		optionStocksName.add("PAGEIND");
		optionStocksName.add("PERSISTENT");
		optionStocksName.add("PIDILITIND");
		optionStocksName.add("PNB");
		optionStocksName.add("POWERGRID");
		optionStocksName.add("PVR");
		optionStocksName.add("RBLBANK");
		optionStocksName.add("SAIL");
		optionStocksName.add("SBICARD");
		optionStocksName.add("SBILIFE");
		optionStocksName.add("SBIN");
		optionStocksName.add("SHRIRAMFIN");
		optionStocksName.add("SRF");
		optionStocksName.add("SYNGENE");
		optionStocksName.add("TATACHEM");
		optionStocksName.add("TATACOMM");
		optionStocksName.add("TATACONSUM");
		optionStocksName.add("TATAMOTORS");
		optionStocksName.add("TATAPOWER");
		optionStocksName.add("TATASTEEL");
		optionStocksName.add("TECHM");
		optionStocksName.add("TITAN");
		optionStocksName.add("TRENT");
		optionStocksName.add("TVSMOTOR");
		optionStocksName.add("WHIRLPOOL");
		optionStocksName.add("WIPRO");
		optionStocksName.add("ZYDUSLIFE");
		optionStocksName.add("APOLLOTYRE");
		optionStocksName.add("ATUL");
		optionStocksName.add("BALRAMCHIN");
		optionStocksName.add("BANDHANBNK");
		optionStocksName.add("BANKBARODA");
		optionStocksName.add("COALINDIA");
		optionStocksName.add("CHOLAFIN");
		optionStocksName.add("COFORGE");
		optionStocksName.add("DALBHARAT");
		optionStocksName.add("DIVISLAB");
		optionStocksName.add("DLF");
		optionStocksName.add("ONGC");
		optionStocksName.add("GODREJPROP");
		optionStocksName.add("HDFCAMC");
		optionStocksName.add("HINDCOPPER");
		optionStocksName.add("ADANIPORTS");
		optionStocksName.add("AARTIIND");
		optionStocksName.add("IEX");
		optionStocksName.add("INDIAMART");
		optionStocksName.add("LICHSGFIN");
		optionStocksName.add("MCDOWELL-N");
		optionStocksName.add("MCX");
		optionStocksName.add("MGL");
		optionStocksName.add("MOTHERSON");
		optionStocksName.add("DABUR");
		optionStocksName.add("MUTHOOTFIN");
		optionStocksName.add("NAVINFLUOR");
		optionStocksName.add("PEL");
		optionStocksName.add("PETRONET");
		optionStocksName.add("POLYCAB");
		optionStocksName.add("PFC");
		optionStocksName.add("RAIN");
		optionStocksName.add("RAMCOCEM");
		optionStocksName.add("RELIANCE");
		optionStocksName.add("BERGEPAINT");
		optionStocksName.add("SHREECEM");
		optionStocksName.add("SUNTV");
		optionStocksName.add("TORNTPHARM");
		optionStocksName.add("UBL");
		optionStocksName.add("ZEEL");
		optionStocksName.add("DEEPAKNTR");
		optionStocksName.add("ESCORTS");
		optionStocksName.add("GRANULES");
		optionStocksName.add("HAVELLS");
		optionStocksName.add("DIXON");
		optionStocksName.add("ICICIPRULI");
		optionStocksName.add("KOTAKBANK");
		optionStocksName.add("LAURUSLABS");
		optionStocksName.add("METROPOLIS");
		optionStocksName.add("MFSL");
		optionStocksName.add("BHARATFORG");
		optionStocksName.add("DRREDDY");
		optionStocksName.add("FSL");
		optionStocksName.add("HCLTECH");
		optionStocksName.add("SIEMENS");
		optionStocksName.add("SUNPHARMA");
		optionStocksName.add("VOLTAS");
		optionStocksName.add("INDIACEM");
		optionStocksName.add("INDUSTOWER");
		optionStocksName.add("JUBLFOOD");
		optionStocksName.add("PIIND");
		optionStocksName.add("MARUTI");
		optionStocksName.add("VEDL");
		optionStocksName.add("IDEA");
		optionStocksName.add("NTPC");
		optionStocksName.add("RECLTD");
		optionStocksName.add("UPL");
		optionStocksName.add("ULTRACEMCO");
		optionStocksName.add("TCS");
		optionStocksName.add("TORNTPOWER");

		return optionStocksName;
	}

}