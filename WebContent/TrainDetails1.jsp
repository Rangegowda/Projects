<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="com.ibm.train.bean.Train"%>
<%@page import="java.util.List"%>
<%@page import="com.ibm.train.dao.TrainDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Train Details</title>
</head>
<body bgcolor="image.jpg">

<h1 style="text-align:center">Train Details</h1>


	<%
		TrainDAO tdao = new TrainDAO();
		int traino=Integer.parseInt(request.getParameter("trainNum"));
		Train train = tdao.findTrain(traino);
	%>
		<table border="2" align="center">
		<tr>
			<td>Train No</td>
			<td>Train Name</td>
			<td>Source</td>
			<td>Destination</td>
			<td>Ticket Price</td>
		</tr>
		
			
			
		<tr>
			<td><% 	out.print(train.getTrainNo()); 		%></td>
			<td><%	out.print(train.getTrainName()); 	%></td>
			<td><%	out.print(train.getSource() );	%></td>
			<td><%	out.print(train.getDestination());	%></td>
			<td><%	out.print(train.getTicketPrice());	%></td>
			<% int n=train.getTrainNo(); %>
		</tr>
		
	
	</table>
	
	<br><br><br>
	
	<h1 style="text-align:center">Enter Train Number</h1>	
	<form name="myform" method="post" action="Passenger.jsp"  OnSubmit="return ValidatePassengers();">
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
		<input type="text" name="noOfPassenger" id="noOfPassenger">
		</td>
			</tr>
			<tr>
			<td><input type="Hidden" name="fare" value="${n}"></td> 
			</tr>
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