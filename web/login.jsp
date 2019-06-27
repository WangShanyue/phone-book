<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2018/2/20
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/user/user_normal.css">
<link rel="stylesheet" href="css/button.css">
<%

%>
<style>
    .top{
        height: 60px;
        background-color: #ffffff;
        margin-bottom: 40px;
    }
</style>
<body style="background: url(/images/bg1.jpg); background-size:cover">
<div class="container">
    <form class="form-signin">
        <div class="panel panel-success">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-5"><h2>登录</h2></div>
                    <div class="col-md-5"></div>
                    <div class="col-lg-offset-8"><br>
                        <button type="button" class="button button-plain button-raised" onclick="go_to_register()">注册</button>
                    </div>
                </div>
            </div>
            <div class="panel-body ">
                <label for="username">用户名</label>
                <input type="text" id="username" class="form-control" placeholder="Username" name="username" required autofocus>
                <br>
                <label for="password">密码</label>
                <input type="password" id="password" class="form-control" placeholder="Password" name="password" required>
                <br>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me" id="remb"> 记住密码
                    </label>
                </div>
                <br>
                <button type="button" class="btn btn-lg btn-success btn-block" id="loginBtn">登录</button>
            </div>
        </div>
    </form>

</div>
<script src="js/jquery/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/common/ajaxfunc.js"></script>
<script src="js/user/login.js"></script>
</body>
</html>
