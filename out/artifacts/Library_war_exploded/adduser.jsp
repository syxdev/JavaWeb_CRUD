<%--
  Created by IntelliJ IDEA.
  User: Song
  Date: 2021/04/29
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/AddUserServlet" method="get">
    <label>
        <span>用户名</span>
        <input type="text" name="username"/>
    </label>
    <label>
        <span>密码</span>
        <input type="password" name="password"/>
    </label>
    <label>
        <span>性别</span>
        <input type="text" name="gender"/>
    </label>
    <label>
        <span>出生日期</span>
        <input type="date" name="birthday"/>
    </label>
    <label>
        <span>电话号码</span>
        <input type="text" name="phone"/>
    </label>
    <label>
        <span>地址</span>
        <input type="text" name="address"/>
    </label>
    <label>
        <input type="submit" value="添加" class="login">
    </label>
</form>
</body>
</html>
