<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
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
    <div action="Login">
        <h1>Login form </h1>
        <form action="Login">
            <input type="text" name="username" placeholder="UserName">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" name="submit" value="Login">
            <a href="register">Registration</a>
        </form>
    </div>
</div>
</body>
</html>
