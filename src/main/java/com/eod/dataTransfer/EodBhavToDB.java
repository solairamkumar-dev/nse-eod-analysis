package com.eod.dataTransfer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.eod.entities.FileDownload;
import com.eod.spring.def.EodDefault;
import com.eod.spring.utilities.GenUtils;

@Service
public class EodBhavToDB {
	int batchSize = 20;
	Connection connection = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

	public boolean transferBhavEodToDB(String fileName) {

		try {
			//Use this for manual file "cm10MAR2023bhav.csv"
			String filePath = EodDefault.eodBhavSavePath+GenUtils.getEodBhavUrl(fileName).substring(67,86);
			connection = DriverManager.getConnection(EodDefault.jdbcURL, EodDefault.userName, EodDefault.passWord);
			connection.setAutoCommit(false);

			String query = "INSERT INTO historical_data_eod(symbol,series,open,high,low,close,last,prevclose,"
					+"tottrdqty,tottrdval,timestamp,totaltrades,isin) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(query);

			BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
			String lineText = null;

			int count = 0;

			lineReader.readLine();
			System.out.println("at transferBhavEodToDB....");

			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				java.sql.Date sqlDate = new java.sql.Date(sdf.parse(data[10]).getTime());
				statement.setString(1, data[0]);
				statement.setString(2, data[1]);
				statement.setDouble(3, Double.parseDouble(data[2]));// .substring(1, data[2].length()-1)));
				statement.setDouble(4, Double.parseDouble(data[3]));// .substring(1, data[3].length()-1)));
				statement.setDouble(5, Double.parseDouble(data[4]));// .substring(1, data[4].length()-1)));
				statement.setDouble(6, Double.parseDouble(data[5]));// .substring(1, data[5].length()-1)));
				statement.setDouble(7, Double.parseDouble(data[6]));// .substring(1, data[6].length()-1)));
				statement.setDouble(8, Double.parseDouble(data[7]));// .substring(1, data[7].length()-1)));
				statement.setLong(9, Long.parseLong(data[8]));
				statement.setDouble(10, Double.parseDouble(data[9]));
				statement.setDate(11, sqlDate);
				statement.setLong(12, Long.parseLong(data[11]));
				statement.setString(13, data[12]);
				statement.addBatch();
				if (count % batchSize == 0)
					statement.executeBatch();
			}
			lineReader.close();
			statement.executeBatch();
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
