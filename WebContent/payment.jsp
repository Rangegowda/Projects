<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validate CardNumber</title>

<script type="text/javascript">
function cardnumber()  
{  
	var inputtxt=document.myform.cardno.value;
  var cardno1 = /^(?:[0-9]{16})$/;  
  if(!inputtxt.match(cardno1))  
        {  
  
        alert("Not a valid credit card number!");  
        document.myform.cardno.focus();
        return false;  
        }  
        
  var year = document.myform.expiry_year.value;
  var month= document.myform.expiry_month.value;
     if(year>22 || year<17){
       alert("Not a valid year!");  
          document.myform.expiry_year.focus();
          return false;  
     }
     if(month <= 0 || month > 12){
  	     alert("Not a valid month!");  
  	        document.myform.expiry_month.focus();
  	        return false; 
  	        }
}
</script>
<%
String pnr=(String)request.getAttribute("PNR");
out.println(pnr);
%>
</head>
<form name="myform" method="post" action="DownloadTicket.jsp" OnSubmit="return cardnumber();">
Credit Card number:<input type="text"  name="cardno" required/>
Expiry month:<input type="text" id="expiry_month" name="month" placeholder="mm" required/>
Expiry year:<input type="text"  id="expiry_year" name="year" placeholder="yy" required/>
<input type="hidden" name="pnr" id="pnr" value="<%=pnr%>">
 <input type="submit" value="submit" />
</form>

</body>
</html>