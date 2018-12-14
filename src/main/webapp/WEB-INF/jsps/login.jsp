<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/14
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="/DataManage/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/DataManage/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form action="/tologin" class="form-signin" >
    <img class="mb-4" src="/DataManage/img/bootstrap-solid1.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">欢迎登录文件管理平台</h1>
    <label class="sr-only">用户名:</label>
    <input type="text" class="form-control" name="userName" placeholder="Username" required="" autofocus="">
    <br>
    <label class="sr-only">密码:</label>
    <input type="password" class="form-control" name="userPwd" placeholder="Password" required="">
    <input type="radio" name="isAdminUser" value="0" checked>学生
    <input type="radio" name="isAdminUser" value="1">管理员
    <br>
    还没有账号?<a class="btn btn-sm" href="http://localhost:8888/DataManage/register.html">我要注册</a>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">© java课程小组</p>
    <a class="btn btn-sm" href="http://xxgc.sicau.edu.cn">信息工程学院</a>
</form>

</body>
</html>
