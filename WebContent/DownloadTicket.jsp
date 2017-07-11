<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ibm.train.bo.TrainBo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download Ticket</title>
</head>
<body>
<%!String pnr; %>
<%  pnr=request.getParameter("pnr");
   // out.println(pnr);
%>
<a href="<%="C:/WebAppSpace/TrainApp/"+pnr+".txt"%>" download>Download the ticket</a>
</body>
</html>