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
    <title>注册</title>
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
<form class="form-signin" action="${pageContext.request.contextPath}/user/register.html" >
    <img class="mb-4" src="/DataManage/img/bootstrap-solid1.jpg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">欢迎注册文件管理平台</h1>
    <label class="sr-only">用户名:</label>
    <input type="text" class="form-control" name="userName" placeholder="Username" required="" autofocus="">
    <label class="sr-only">密码:</label>
    <input type="password" class="form-control" name="userPwd" placeholder="Password" required="">
    <label class="sr-only">密码:</label>
    <input type="password" class="form-control" name="userPwd1" placeholder="Password again" required="">
    <label class="sr-only">班级:</label>
    <input type="text" class="form-control" name="userClass" placeholder="Class" required="">
    <label class="sr-only">小组:</label>
    <input type="text" class="form-control" name="userGroup" placeholder="group name" required="">
    <label class="sr-only">联系方式:</label>
    <input type="text" class="form-control" name="userTel" placeholder="telphone number" required="">
    <br>
    已经有账号?<a class="btn btn-sm" href="${pageContext.request.contextPath}/user/tologin.html">我要登录</a>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    <a class="btn btn-sm" href="http://xxgc.sicau.edu.cn">信息工程学院</a>
</form>

</body>
</html>
