<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.ibm.train.bean.Train"%>
<%@page import="java.util.List"%>
<%@page import="com.ibm.train.dao.TrainDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="image.jpg">

<h1 style="text-align:center">Train Details</h1>


	<%
		TrainDAO tdao = new TrainDAO();
		
		List<Train> t = tdao.findAll(request.getParameter("source"),request.getParameter("dest"));
	%>
		<table border="2" align="center">
		<tr>
			<td>Train No</td>
			<td>Train Name</td>
			<td>Source</td>
			<td>Destination</td>
			<td>Ticket Price</td>
		</tr>
		
			<% for (Train train : t) { %>
			
		<tr>
			<td><% 	out.print(train.getTrainNo()); 		%></td>
			<td><%	out.print(train.getTrainName()); 	%></td>
			<td><%	out.print(train.getSource() );	%></td>
			<td><%	out.print(train.getDestination());	%></td>
			<td><%	out.print(train.getTicketPrice());	%></td>
			
		</tr>
		<%
		}
	%>	
	
	</table>
	
	<br><br><br>
	
	<h1 style="text-align:center">Enter Train Number</h1>	
	<form name="myform" method="get" action="Passenger.jsp"  OnSubmit="return ValidatePassengers();">
		<table border="2" align="center">

			<tr>
				<td>Train Number</td>
				<td><input type="text" name="trainno" /></td>
			</tr>
			<tr>
			<td>Travel Date</td>
			<td><input type="text" name="date" /></td>
			</tr>
	
		<tr>
		<td>No.passengers</td>
		<td>
		<input type="text" name="noOfPassenger" >
		</td>
			</tr>
		<tr>
		<tr>
			<tr>
				<td><input type="submit" value="BOOK-TICKET" /></td>
				<td><input type="reset" name="RESET" value="RESET"></td>
			</tr>
		</table>
		
	</form>


</body>
<script type="text/javascript">

function ValidatePassengers(){
	
	var pasngr=document.myform.noOfPassenger.value;
	if(pasngr>6){
		alert("passengers must be less than or equl to 6.")
	   document.myform.noOfPassenger.focus();
		return false;
	}
}


</script>
</html>