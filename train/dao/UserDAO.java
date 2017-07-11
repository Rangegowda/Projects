package com.ibm.train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.train.bean.User;

public class UserDAO {

	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER_ID = "system";
	private static final String PASSWORD = "orcl";

	private java.sql.Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(DB_URL, USER_ID, PASSWORD);

	}

	public boolean getUserDetails(String name,String pass) throws SQLException, ClassNotFoundException {
		boolean flag = false;
		try {
			Connection con = createConnection();
			String Query = "select * from user_details where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			//System.out.println(rs.next());
			if (rs.next() == true) {
				return true;
			}
		} catch (SQLException se) {

		}
		return flag;

	}

	public boolean insertUser(String name,String pass,String mail) throws SQLException, ClassNotFoundException {
		boolean flag = false;
		try {
			Connection con = createConnection();
			String queryString = "insert into user_details values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, mail);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		}

		catch (SQLException se) {

		}
		return flag;
	}
}
