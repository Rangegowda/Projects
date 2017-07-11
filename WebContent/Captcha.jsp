<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Captcha</title>
</head>
<body>
             <script type="text/javascript">
                 function Captcha(){
                     var numerics = new Array('1','2','3','4','5','6','7','8','9');
                     var i;
                     for (i=0;i<6;i++){
                       var a = numerics[Math.floor(Math.random() * numerics.length)];
                       var b = numerics[Math.floor(Math.random() * numerics.length)];
                       var c = numerics[Math.floor(Math.random() * numerics.length)];
                       var d = numerics[Math.floor(Math.random() * numerics.length)];
                        }
                    var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d ;
                    document.getElementById("mainCaptcha").value = code
                  }
                  function ValidCaptcha(){
                      var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
                      var string2 = removeSpaces(document.getElementById('txtInput').value);
                      if (string1 == string2){
                        return true;
                      }
                      else{        
                        
                       return response.sendRedirect("Train.jsp");
                      }
                  }
                  function removeSpaces(string){
                    return string.split(' ').join('');
                  }
             </script>    
        </head>
     <body onload="Captcha();">
        <table>
          
          <tr>
          
           <td>
              Captcha: <input type="text" id="mainCaptcha" readonly/>
              <input type="button" id="refresh" value="Refresh" onclick="Captcha();" />
           </td>
          </tr>
          <tr>
           <td>
           Enter above Captcha: <input type="text" id="txtInput"/>    
          </td>
         </tr>
          </table>
    </body>
 </html>

