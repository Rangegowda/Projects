package com.ibm.train.Servlet.Controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.train.bean.Passenger;
import com.ibm.train.bean.Train;
import com.ibm.train.bo.TrainBo;

/**
 * Servlet implementation class Ser_view4
 */
public class Ser_view4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ser_view4() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String passno=request.getParameter("name");
		
		System.out.println(passno);
		
	}

}
