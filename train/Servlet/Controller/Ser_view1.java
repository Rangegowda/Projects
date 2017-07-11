package com.ibm.train.Servlet.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.train.bo.UserBo;

/**
 * Servlet implementation class Ser_view1
 */
public class Ser_view1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ser_view1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("user");
		String pass=request.getParameter("pass");
		String mail=request.getParameter("mail");
		UserBo us=new UserBo();
		
		try {
			boolean insert = us.Register(name, pass, mail);
			if(insert==true)
			{
				response.sendRedirect("Train.jsp");
			}
			else
			{
				response.sendRedirect("Register.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
