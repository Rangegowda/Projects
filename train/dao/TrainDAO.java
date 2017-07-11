package com.ibm.train.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.train.bean.Passenger;
import com.ibm.train.bean.Train;
import com.ibm.train.exception.Invalid_Train_Exception;

public class TrainDAO {
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER_ID = "system";
	private static final String PASSWORD = "orcl";

	private java.sql.Connection createConnection() throws SQLException {
		Driver driver = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection(DB_URL, USER_ID, PASSWORD);
	}

	public Train findTrain(int trainNum) {
		Connection con = null;
		ResultSet result = null;
		Train t = new Train();
		List<Train> list = new ArrayList<Train>();
		try {
			
			con = createConnection();
			PreparedStatement statement=con.prepareStatement("select * from train_details where train_no=?");
			statement.setInt(1, trainNum);
			
			result=statement.executeQuery();
			
			while (result.next()) {
				

				t.setTrainNo(result.getInt("train_no"));
				t.setTrainName(result.getString("train_name"));
				t.setSource(result.getString("source"));
				t.setDestination(result.getString("destination"));
				t.setTicketPrice(result.getDouble("ticket_price"));

				list.add(t);
				
			}


			con.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return t;
	}

	public List<Train> findAll(String source,String dest) 
	{
		Connection con = null;
		ResultSet result = null;
		
		List<Train> list = new ArrayList<Train>();
		try {

			con = createConnection();
			PreparedStatement statement=con.prepareStatement("select * from train_details where source=? and destination=?");
			statement.setString(1, source);
			statement.setString(2, dest);
			result=statement.executeQuery();
			
			while (result.next()) {
				Train t = new Train();

				t.setTrainNo(result.getInt("train_no"));
				t.setTrainName(result.getString("train_name"));
				t.setSource(result.getString("source"));
				t.setDestination(result.getString("destination"));
				t.setTicketPrice(result.getDouble("ticket_price"));

				list.add(t);
			}


			con.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean insertPassenger(Passenger[] po, int passno) {
		boolean flag = false;
		try {
			Connection con = createConnection();

			for (int i = 0; i < passno; i++) {
				String queryString = "insert into Passenger values(?,?,?,?)";
				PreparedStatement prep = con.prepareStatement(queryString);
				prep.setString(1, po[i].getName());
				prep.setInt(2, po[i].getAge());
				prep.setString(3, po[i].getGender());
				prep.setDouble(4, po[i].getFare());
				prep.executeUpdate();
				flag = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

}
