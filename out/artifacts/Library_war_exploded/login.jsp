<%--
  Created by IntelliJ IDEA.
  User: Song
  Date: 2021/04/27
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<section class="content">
    <form action="/LoginServlet" method="post">
        <div class="form sign-in">
            <h2>欢迎回来</h2>
            <label>
                <span>用户名</span>
                <input type="text" name="username"/>
            </label>
            <label>
                <span>密码</span>
                <input type="password" name="password"/>
            </label>
            <p class="forgot-pass"><a href="javascript:">忘记密码？</a></p>
            <label>
                <input type="submit" value="登录" class="login">
            </label>
            <%--            <button type="button" class="submit">登 录</button>--%>
            <button type="button" class="fb-btn">使用 <span>facebook</span> 帐号登录</button>
        </div>
    </form>
    <form action="/RegisterServlet" method="get">
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h2>还未注册？</h2>
                    <p>立即注册，发现大量机会！</p>
                </div>
                <div class="img__text m--in">
                    <h2>已有帐号？</h2>
                    <p>有帐号就登录吧，好久不见了！</p>
                </div>
                <div class="img__btn">
                    <span class="m--up">注 册</span>
                    <span class="m--in">登 录</span>
                </div>
            </div>
            <div class="form sign-up">
                <h2>立即注册</h2>
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
                    <input type="submit" value="注 册" class="login">
                </label>
                <%--                <button type="button" class="submit">注 册</button>--%>
            </div>

        </div>
    </form>
</section>

<script src="script.js"></script>

<div style="text-align:center;">
</div>
</body>
</html>
