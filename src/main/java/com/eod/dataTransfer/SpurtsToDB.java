package com.eod.dataTransfer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.eod.spring.def.EodDefault;

public class SpurtsToDB {
	int batchSize = 20;
	Connection connection = null;
	java.util.Date date = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());

	public boolean transferSpurtsToDb() {
		try {
			String filePath = "C:\\Users\\Ram\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\spring-batch-example-main\\spring-batch-example-main\\Spurts-in-OI-By-Underlying-18122022.csv";
			connection = DriverManager.getConnection(EodDefault.jdbcURL, EodDefault.userName, EodDefault.passWord);
			String sqlQuery = "Insert into spruts_oi_data (symbol,oi_ytd,oi_tdy,oi_change,volume,und_value,date_time)"
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
			String lineText = null;
			int count = 0;

			lineReader.readLine();
			while ((lineText = lineReader.readLine()) != null) {
				String[] data = lineText.split(",");
				statement.setString(1, data[0]);
				statement.setLong(2, Long.parseLong(data[1]));
				statement.setLong(3, Long.parseLong(data[2]));
				statement.setLong(4, Long.parseLong(data[3]));
				statement.setLong(5, Long.parseLong(data[5]));
				statement.setDouble(6, Double.parseDouble(data[9]));
				statement.setTimestamp(7, sqlTime);
				statement.addBatch();

				if (count % batchSize == 0)
					statement.executeBatch();
			}
			lineReader.close();
			statement.executeBatch();
			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
