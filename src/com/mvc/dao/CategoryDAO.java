package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.beans.CategoryBean;

public class CategoryDAO {

	static Connection con = null;

	static boolean flag = false;

	static PreparedStatement pst = null;
	
//	To show the category
	static ResultSet rs = null;

	// --------------START------get connection---------------

	/*
	 * @author: rahul
	 * 
	 * @Date: 16.11.2023
	 * 
	 * @version : 1.0
	 * 
	 * @purpose : database connection
	 */

	public static Connection getDbConnection() throws SQLException {

		try {
			DBDAO.connect();
			con = DBDAO.getDbCon();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

	// ------------------END-------------database connection---------

	// --------------START------ insert method ---------------

	/*
	* 
	* 
	* 
	* 	
	*/

	public static boolean insertCategory(String catName) throws SQLException {

		con = getDbConnection();
		try {

			pst = con.prepareStatement("insert into category(ca_name)values (?)");
			pst.setString(1, catName);
			pst.executeUpdate();

			flag = true;
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return flag;

	}

//	method to list all categories in CategoryDAO(to display values in CategoryVED.jsp)

	// ---------------------------------listEnquiries----------------------------------------
	public static ArrayList<CategoryBean> listAllCategories() throws SQLException {
		ArrayList<CategoryBean> categoryBean = new ArrayList<CategoryBean>();
		con = getDbConnection();
		try {
			pst = con.prepareStatement("SELECT * FROM category");
			rs = pst.executeQuery();
			while (rs.next()) {
				CategoryBean category = new CategoryBean();
				category.setCaId(rs.getInt(1));
				category.setCaName(rs.getString(2));
				categoryBean.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryBean;
	}
	// --------------END----------------------------------------------------------------

}
