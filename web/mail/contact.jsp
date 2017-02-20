<%-- 
    Document   : contact
    Created on : 19/02/2017, 09:29:42 PM
    Author     : imanol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.cMail"%>

<%
  cMail mail = new cMail();
  
  if(request.getParameter("name").isEmpty()){
      response.sendRedirect("index.jsp#contact");
  }
  else{
      mail.emailContact(request.getParameter("email"), request.getParameter("subject"), request.getParameter("message"), request.getParameter("name"));  
  }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
