package com.openshift.aeg;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountNumberGenerator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int MAX_ACCOUNT_NUMBERS = 5;
	private static final Logger LOGGER = Logger.getLogger( "AccountNumberGenerator" );

	{
		accountNumbers= generateAccountNumbers();
	}
	
	private String[] accountNumbers;
	
	
	public String[] getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(String[] accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
//	public String[] generateAccountNumbers() {
//		String[] accountPrefixes = {"AAA","BBB","CCC","DDD"};
//		accountNumbers = new String[MAX_ACCOUNT_NUMBERS];
//		for (int i=0; i<MAX_ACCOUNT_NUMBERS; i++) {
//			String accountNumberPrefix = accountPrefixes[new Random().nextInt(accountPrefixes.length)];
//			int accountNumberSuffix = 1000000 + new Random().nextInt(9000000); 
//			accountNumbers[i] = new String(accountNumberPrefix + "-" + accountNumberSuffix);
//		}
//		return accountNumbers;
//	}
	
	public String[] generateAccountNumbers() {
		LOGGER.log(Level.INFO, "Entering generateAccountNumbers()...");
		ArrayList<String> list = new ArrayList<String>();
		try {
				String databaseURL = "jdbc:postgresql://";
				databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
				databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
				String username = System.getenv("POSTGRESQL_USER");
				String password = System.getenv("PGPASSWORD");
				Connection connection = DriverManager.getConnection(databaseURL, username, password);
				if (connection != null) {
					String SQL = "select a.ac_number as account_number from account_number a";
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(SQL);
					while (rs.next()) {
						list.add(rs.getString("account_number"));
					}
					rs.close();
					connection.close();
				} else
					LOGGER.log(Level.SEVERE, "Could not connect to the database.");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
			System.out.println("Database connection problem!");
		}
		return list.toArray(new String[list.size()]);	  
	}
}
