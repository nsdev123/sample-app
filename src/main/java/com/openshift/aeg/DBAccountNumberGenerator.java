package com.openshift.aeg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;


public class DBAccountNumberGenerator extends AccountNumberGenerator {

	private static final long serialVersionUID = 5344149485208505751L;
	private static final Logger LOGGER = Logger.getLogger( "DBAccountNumberGenerator" );
	@Override
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
