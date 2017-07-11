<%@ page language="java" import="com.ibm.train.dao.TrainDAO" import="com.ibm.train.bo.TrainBo" import="com.ibm.train.bean.Train" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.ibm.train.bean.Train"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int i; %>
<%
   
  
	TrainDAO tdao = new TrainDAO();
	TrainBo tb=new TrainBo();
   int trno= Integer.parseInt(request.getParameter("trainno"));
   String travelDate=request.getParameter("date");
   int no=Integer.parseInt(request.getParameter("noOfPassenger"));
   
   //out.println(no);
   %>
   
   
   <% Train t=tdao.findTrain(trno);
   
   
   //out.println(t.getTicketPrice());
   double c=t.getTicketPrice() ;
   
 
  //Boolean flag=t.validateDate(date1);
   boolean bo=tb.checkDate(travelDate);
   if (bo==true) {
   %>
   <form method="Post" action="Ser_view3">
   <input type="hidden" value="<%=no%>" name="noOfPassenger"/>
    <input type="hidden" value="<%=c %>" name="fare"/> 
    <input type="hidden" value="<%=travelDate %>" name="date"/>
    <input type="hidden" value="<%=trno %>" name="trainno" />
   <%  for(int i=0;i<no;i++)
   {%>
   
   <table border=2 >
   

         
	 <tr><td>Name:<input type="text" name="name<%=i %>"></td></tr> 
	 <tr><td>Age:<input type="text" name="age<%=i %>"/></td></tr>
	 <tr><td>Gender<input type="text" name="gen<%=i %>"/></td></tr> 
	   
   
   
   <%}

} else { 
   RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
	   rd.forward(request, response);
	   } %>
  <tr><td>  
<input type="submit" />

</td></tr>

</table>
   </form>
 
</body>

</html>