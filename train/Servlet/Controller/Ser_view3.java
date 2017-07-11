package com.ibm.train.Servlet.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.train.bean.Passenger;
import com.ibm.train.bean.Train;
import com.ibm.train.bo.TrainBo;
import com.ibm.train.dao.TrainDAO;

/**
 * Servlet implementation class Ser_view3
 */
public class Ser_view3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ser_view3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDAO tdao=new TrainDAO();
		
		 int n=Integer.parseInt(request.getParameter("noOfPassenger"));
		 List<Passenger> list=new ArrayList<Passenger>();
		
		 String name,gen ;
		 int age;
		double fare=Double.parseDouble(request.getParameter("fare"));
		String travelDate=request.getParameter("date");
		int tno=Integer.parseInt(request.getParameter("trainno"));
		
		Train t=tdao.findTrain(tno);
		
		
		for(int i=0;i<n;i++){
			
			
			 name=request.getParameter("name"+i);
			 age=Integer.parseInt(request.getParameter("age"+i));
			 gen=request.getParameter("gen"+i);
			list.add(new Passenger(name,age,gen,fare));
			
			
		
			}
		
		TrainBo tr=new TrainBo();
		
		 
		 try {
			boolean bn=tr.registerUser(t, list, travelDate, n);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	 String pnr=tr.generatePNR(t, travelDate);
	 
	 
	      request.setAttribute("PNR",pnr);
		RequestDispatcher rd=request.getRequestDispatcher("payment.jsp");
		rd.include(request, response);
			
			
		

		
	}

}
