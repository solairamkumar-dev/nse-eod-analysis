package com.eod.dataTransfer;

import java.io.BufferedReader;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.eod.entities.FileDownload;
import com.eod.spring.def.EodDefault;
import com.eod.spring.utilities.GenUtils;

@Service
public class EodTechnicalsToDB {
	int batchSize = 20;
	Connection connection = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public boolean transferEodTechnicalsToDb(FileDownload fileDownload) {
		boolean deleteDownloadedFile = false;
		Date date = new Date();

		try {
			String filePath = EodDefault.filePath +GenUtils.eodFileName(fileDownload);
			connection = DriverManager.getConnection(EodDefault.jdbcURL, EodDefault.userName, EodDefault.passWord);
			connection.setAutoCommit(false);

			String sqlQuery = "INSERT INTO eod_technical_data (p_symbol,last_close,last_volume,avg_volume,pct_change_1_day,pct_change_1_week,pct_change_1_month,pct_change_3_months\r\n"
					+ ",pct_change_1_year,sma_5,ema_5,sma_13,ema_13,sma_20,ema_20,sma_34,ema_34,sma_50,ema_50,sma_89,ema_89,sma_200,ema_200,bband_upper,bband_lower,bband_mid,macd,\r\n"
					+ "macd_signal,macd_hist,adx,dmi_plus,dmi_minus,rsi,stoch_k,stoch_d,cci,psar,true_range,atr,williams_r,trix,stochrsi_k\r\n"
					+ ",stochrsi_d,momentum,candle,p_date) values (?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
			String lineText = null;

			int count = 0;

			lineReader.readLine();

			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				// condition to find out today's data or not

				/*
				 * if (!data[45].isEmpty()) {
				 * System.out.println("data 45 : "+sdf.format(date).toString());
				 * System.out.println(data[45].substring(1, data[45].length() - 1)); if
				 * (data[45].substring(1, data[45].length() -
				 * 1).equals(sdf.format(date).toString())) System.out.println("Uploading " +
				 * data[45] + " Tech Data to DB"); else { lineReader.close();
				 * deleteDownloadedFile = GenUtils.deleteFile(filePath); } if
				 * (deleteDownloadedFile) { System.out.println("Downloded file is old dated at "
				 * + data[45] + ", so file uploaded was stopped and deleted the file"); return
				 * false; } }
				 */

				java.sql.Date sqlDate = new java.sql.Date(
						sdf.parse(data[45].substring(1, data[45].length() - 1)).getTime());
				statement.setString(1, data[0]);
				statement.setDouble(2, Double.parseDouble(data[1].substring(1, data[1].length() - 1)));
				statement.setDouble(3, Double.parseDouble(data[2].substring(1, data[2].length() - 1)));
				statement.setDouble(4, Double.parseDouble(data[3].substring(1, data[3].length() - 1)));
				statement.setDouble(5, Double.parseDouble(data[4].substring(1, data[4].length() - 1)));
				statement.setDouble(6, Double.parseDouble(data[5].substring(1, data[5].length() - 1)));
				statement.setDouble(7, Double.parseDouble(data[6].substring(1, data[6].length() - 1)));
				statement.setDouble(8, Double.parseDouble(data[7].substring(1, data[7].length() - 1)));
				statement.setDouble(9, Double.parseDouble(data[8].substring(1, data[8].length() - 1)));
				statement.setDouble(10, Double.parseDouble(data[9].substring(1, data[9].length() - 1)));
				statement.setDouble(11, Double.parseDouble(data[10].substring(1, data[10].length() - 1)));
				statement.setDouble(12, Double.parseDouble(data[11].substring(1, data[11].length() - 1)));
				statement.setDouble(13, Double.parseDouble(data[12].substring(1, data[12].length() - 1)));
				statement.setDouble(14, Double.parseDouble(data[13].substring(1, data[13].length() - 1)));
				statement.setDouble(15, Double.parseDouble(data[14].substring(1, data[14].length() - 1)));
				statement.setDouble(16, Double.parseDouble(data[15].substring(1, data[15].length() - 1)));
				statement.setDouble(17, Double.parseDouble(data[16].substring(1, data[16].length() - 1)));
				statement.setDouble(18, Double.parseDouble(data[17].substring(1, data[17].length() - 1)));
				statement.setDouble(19, Double.parseDouble(data[18].substring(1, data[18].length() - 1)));
				statement.setDouble(20, Double.parseDouble(data[19].substring(1, data[19].length() - 1)));
				statement.setDouble(21, Double.parseDouble(data[20].substring(1, data[20].length() - 1)));
				statement.setDouble(22, Double.parseDouble(data[21].substring(1, data[21].length() - 1)));
				statement.setDouble(23, Double.parseDouble(data[22].substring(1, data[22].length() - 1)));
				statement.setDouble(24, Double.parseDouble(data[23].substring(1, data[23].length() - 1)));
				statement.setDouble(25, Double.parseDouble(data[24].substring(1, data[24].length() - 1)));
				statement.setDouble(26, Double.parseDouble(data[25].substring(1, data[25].length() - 1)));
				statement.setDouble(27, Double.parseDouble(data[26].substring(1, data[26].length() - 1)));
				statement.setDouble(28, Double.parseDouble(data[27].substring(1, data[27].length() - 1)));
				statement.setDouble(29, Double.parseDouble(data[28].substring(1, data[28].length() - 1)));
				statement.setDouble(30, Double.parseDouble(data[29].substring(1, data[29].length() - 1)));
				statement.setDouble(31, Double.parseDouble(data[30].substring(1, data[30].length() - 1)));
				statement.setDouble(32, Double.parseDouble(data[31].substring(1, data[31].length() - 1)));
				statement.setDouble(33, Double.parseDouble(data[32].substring(1, data[32].length() - 1)));
				statement.setDouble(34, Double.parseDouble(data[33].substring(1, data[33].length() - 1)));
				statement.setDouble(35, Double.parseDouble(data[34].substring(1, data[34].length() - 1)));
				statement.setDouble(36, Double.parseDouble(data[35].substring(1, data[35].length() - 1)));
				statement.setDouble(37, Double.parseDouble(data[36].substring(1, data[36].length() - 1)));
				statement.setDouble(38, Double.parseDouble(data[37].substring(1, data[37].length() - 1)));
				statement.setDouble(39, Double.parseDouble(data[38].substring(1, data[38].length() - 1)));
				statement.setDouble(40, Double.parseDouble(data[39].substring(1, data[39].length() - 1)));
				statement.setDouble(41, 0);
				statement.setDouble(42, Double.parseDouble(data[41].substring(1, data[41].length() - 1)));
				statement.setDouble(43, Double.parseDouble(data[42].substring(1, data[42].length() - 1)));
				statement.setDouble(44, Double.parseDouble(data[43].substring(1, data[43].length() - 1)));
				statement.setString(45, null);
				statement.setDate(46, sqlDate);
				statement.addBatch();

				if (count % batchSize == 0)
					statement.executeBatch();
			}
			lineReader.close();
			// statement.executeBatch();
			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
