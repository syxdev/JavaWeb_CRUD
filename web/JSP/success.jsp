<%--
  Created by IntelliJ IDEA.
  User: Song
  Date: 2021/04/28
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
welcome! ${username.username}
<form action="/LogoutServlet" method="post">
    <input type="submit" value="注销">
</form>
<a href="/UserListServlet">查看用户列表</a>
</body>
</html>
