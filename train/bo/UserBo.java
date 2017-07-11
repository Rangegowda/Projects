package com.ibm.train.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.train.bean.User;
import com.ibm.train.dao.UserDAO;

public class UserBo {
	UserDAO dao=new UserDAO();
	public boolean validUser(String name,String pass) throws SQLException, ClassNotFoundException
	{
			return dao.getUserDetails(name,pass);
			
		}
	public boolean Register(String name,String pass,String mail) throws ClassNotFoundException, SQLException
	{
		
		
		return dao.insertUser(name,pass,mail);
		
	}
	
}
