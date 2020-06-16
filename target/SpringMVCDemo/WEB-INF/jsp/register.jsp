<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/15/2020
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
    <%
    String msg=(String)request.getAttribute("message");
    if (msg==null){
        msg="";
    }
%>
    <%=msg%>
<body>
<div class = "form">
    <h1>Registration form </h1>
    <form action="Register">
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="email" placeholder="Email">
        <input type="password" name="pass" placeholder="Password">
        <input type="password"name="confirmPass" placeholder="Confirm Password">
        <input type="submit" placeholder="submit" value="Register">
    </form>
    </table>
    </form>
</div>
</div>
</center>
</body>
