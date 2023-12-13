package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDAO {

	private static Connection dbCon;
	private static String dbURL;
	private static String dbDriver;
	private static String userName;
	private static String passWord;

	// --------------START------database initialization---------------
	/**
	 *
	 * @author: rahul
	 * @Date: 16.11.2023
	 * @version : 1.0
	 * @purpose :Initialize database connection values
	 * @param : Nothing
	 * @see : Nothing
	 * @return: Nothing
	 */

	private static void dbInit() {
		try {
			dbDriver = "com.mysql.cj.jdbc.Driver";
			dbURL = "jdbc:mysql://localhost:3306/govegstore";
			userName = "root";
			passWord = "Mysql@Pass";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// -------------END---------database initialization---------------

	// --------------START----------database connection ------------
	/**
	 *
	 * @author: rahul
	 * @Date: 16.11.2023
	 * @version : 1.0
	 * @purpose : database connection
	 * @param : Nothing
	 * @throws : Exception in case of missing driver class
	 * @return: Nothing
	 */
	public static void connect() throws ClassNotFoundException, SQLException {
		dbInit();
		try {
			Class.forName(dbDriver);
//			dbCon = DriverManager.getConnection(dbURL, userName, passWord);
//			setDbCon(dbCon);
			Connection con=DriverManager.getConnection(dbURL,userName,passWord);
			setDbCon(con);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

	// --------------START----------get db connection ------------
	/**
	 *
	 * @author : rahul
	 * @date : 03.14.2023
	 * @version: 1.0
	 * @purpose: Get Connection
	 * @param : Nothing
	 * @return : Connection
	 */
	public static Connection getDbCon() {
		return dbCon;
	}

	// ------------------END-------------get
	
	
	// connection---------//--------------START----------set db connection

	/**
	 *
	 * @author : rahul
	 * @date : 03.14.2023
	 * @version: 1.0
	 * @purpose: Set Connection
	 * @param : Connection
	 * @return : Nothing
	 */
	public static void setDbCon(Connection con) {
		dbCon = con;
	}

	// ------------------END-------------set
	
	
	// connection---------//--------------START----------close connection

	/**
	 *
	 * @author : rahul
	 * @date : 03.14.2023
	 * @version: 1.0
	 * @purpose: Close connection
	 * @param : Nothing
	 * @throws :Exception in case of closing connection
	 * @return : Nothing
	 */
	public static void close() throws SQLException {
		dbCon.close();
	}
	// ------------------END-------------closing connection---------

}
