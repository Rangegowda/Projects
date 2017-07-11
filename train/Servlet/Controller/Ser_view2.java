package com.ibm.train.Servlet.Controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.train.bean.Train;
import com.ibm.train.bo.TrainBo;

/**
 * Servlet implementation class Ser_view2
 */
public class Ser_view2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ser_view2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 TrainBo bo=new TrainBo();
		
		  
		int tnum=Integer.parseInt(request.getParameter("trainNum"));
		 String src=request.getParameter("source");
		 String dest=request.getParameter("dest");
		 bo.findTrain(tnum);
		bo.findAllTrains(src,dest);
		
	}

}
