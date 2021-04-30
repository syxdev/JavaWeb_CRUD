<%--
  Created by IntelliJ IDEA.
  User: Song
  Date: 2021/04/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<a href="adduser.jsp">添加用户</a>
<table border="1px" cellspacing="0px" cellpadding="0px" width="50%" style="text-align: center">
    <tr>
        <td>序号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>性别</td>
        <td>出生日期</td>
        <td>电话号码</td>
        <td>地址</td>
    </tr>
    <c:forEach var="users" items="${list}" varStatus="status">
        <tr>
            <td>
                <span>${users.id}</span>
            </td>
            <td>
                <span>${users.username}</span>
            </td>
            <td>
                <span>${users.password}</span>
            </td>
            <td>
                <span>${users.gender}</span>
            </td>
            <td>
                <span>${users.birthday}</span>
            </td>
            <td>
                <span>${users.phone}</span>
            </td>
            <td>
                <span>${users.address}</span>
            </td>
            <td>
                <span><a href="/SelectUserServlet?id=${users.id}">修改</a></span>
                <span><a href="/DeleteUserServlet?id=${users.id}">删除</a></span>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
