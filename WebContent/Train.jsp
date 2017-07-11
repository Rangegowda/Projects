
<%@ page language="java" import="com.ibm.train.Servlet.Controller.Ser_view" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login IRCTC Page:</title>

    <script type="text/javascript">
         function Captcha(){
             var cap = new Array('0','1','2','3','4','5','6','7','8','9');
            /*  var i;
                 for (i=0;i<3;i++){ */
                  var a = cap[Math.floor(Math.random() * cap.length)];
                  var b = cap[Math.floor(Math.random() * cap.length)];
                  var c = cap[Math.floor(Math.random() * cap.length)];
                  var d = cap[Math.floor(Math.random() * cap.length)];
                 //}
                    var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d;
                    document.getElementById("mainCaptcha").value = code
        }
         
         function ValidateCaptcha(){
             
        	 
        	 if(document.myform.user.value == "")
             
        	 {
        	 alert('Please input Username');
        	 document.myform.user.focus();
        	  return false;
        	 }   
        	 
        	 if(document.myform.pass.value == "")
                 
        	 {
        	 alert('Please input Password');
        	 document.myform.pass.focus();
        	  return false;
        	 }   
             var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
             var string2 = removeSpaces(document.getElementById('txtInput').value);
             
             if (string1 != string2){
            	 alert("invalid captcha")
                 document.myform.txtInput.focus();
             	return false;
             	}
             
         }
         
         function removeSpaces(string){
           return string.split(' ').join('');
         }
</script>

</head>

<body bgcolor="image.jpg" onload="Captcha();">

<%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>

<div align="center">
<form name="myform" method="POST" action="Ser_view" OnSubmit="return ValidateCaptcha();">
 
  UserName: <input type="text" name="username" id="user"><br>
  Password: <input type="password" name="password" id="pass"><br>
 
   Enter Captcha: 
   <input type="text" id="txtInput"/>    
   <input type="text" id="mainCaptcha" style="color:blue" readonly/>
   <input type="button" id="refresh" value="Refresh" onclick="Captcha();"/>
   <br><br>
   
   <input type="submit" value="Login" />
   <a href="Register.jsp">Create New Account</a>
  	
 </form>
</div>
</body>
</html>