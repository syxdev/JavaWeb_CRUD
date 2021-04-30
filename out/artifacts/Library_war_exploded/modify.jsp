<%--
  Created by IntelliJ IDEA.
  User: Song
  Date: 2021/04/30
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ModifyServlet" method="post">
    id:<input type="text" name="id" value="${user.id}"/><br>
    username:<input type="text" name="username" value="${user.username}"><br>
    password:<input type="password" name="password" value="${user.password}"><br>
    gender: <input type="text" name="gender" value="${user.gender}"><br>
    phone<input type="text" name="phone" value="${user.phone}"><br>
    birthday<input type="date" name="birthday" value="${user.birthday}"><br>
    address<input type="text" name="address" value="${user.address}"><br>
    <input type="submit" value="确认修改">
    <input><a href="userlist.jsp">返回</a>
    <input type="reset" value="重置">
</form>
</body>
</html>
