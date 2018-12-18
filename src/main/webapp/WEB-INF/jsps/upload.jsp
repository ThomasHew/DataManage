<%--
  Created by IntelliJ IDEA.
  User: stormfang
  Date: 2018/12/15
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script type="text/javascript" src="/DataManage/js/jquery.min.js"></script>
    <script type="text/javascript" language="JavaScript" src="/DataManage/js/jquery.js"></script>
    <script type="text/javascript" src="/DataManage/js/register.js"></script>

    <title>Dashboard Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="/DataManage/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/DataManage/css/dashboard.css" rel="stylesheet">
    <style type="text/css">
        /* Chart.js */

        @-webkit-keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        @keyframes chartjs-render-animation {
            from {
                opacity: 0.99
            }
            to {
                opacity: 1
            }
        }

        .chartjs-render-monitor {
            -webkit-animation: chartjs-render-animation 0.001s;
            animation: chartjs-render-animation 0.001s;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">文件管理平台</a>
    <a class="nav-item" style="color: white">&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;欢迎你：${user.userName}</a>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">

            <a class="nav-link" href="">Sign out</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath }/file/tofilelist.html">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                <polyline points="9 22 9 12 15 12 15 22"></polyline>
                            </svg>
                            文件列表 <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/file/touploadfile.html">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file">
                                <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                <polyline points="13 2 13 9 20 9"></polyline>
                            </svg>
                            文件上传
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart">
                                <circle cx="9" cy="21" r="1"></circle>
                                <circle cx="20" cy="21" r="1"></circle>
                                <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                            </svg>
                            Products
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
                                <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                                <circle cx="9" cy="7" r="4"></circle>
                                <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                                <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                            </svg>
                            Customers
                        </a>
                    </li>

                </ul>


            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h2>文件上传</h2>


            <div id="login_dialog" >
                <div class="x-body">
                    <form class="layui-form"  action="${pageContext.request.contextPath }/file/uploadfile.html" method="post" enctype="multipart/form-data">
                        <div class="layui-form-item">


                            <span class="x-red">*</span>资料名称

                            <div class="layui-input-inline">
                                <input class="layui-input"  type="text" style="width:545px;height:35px" id="tureFileName"  name="tureFileName"  readonly="readonly" />
                                <!-- <input type="text" id="file" name="fileName" required lay-verify="required" -->
                                <!--  autocomplete="off" readonly="readonly" class="layui-input" value=""> -->
                            </div>
                        </div>
                        <div class="layui-form-item">

                            <span class="x-red">*</span>小组名称

                            <div class="layui-input-inline">

                                <input type="text"  name="groupName" style="width:545px;height:35px"  required lay-verify="required"
                                       autocomplete="off" readonly="readonly" class="layui-input" value="${user.userGroup }" >

                            </div>
                        </div>

                        <div class="layui-form-item">

                            <span class="x-red">*</span>上传人

                            <div class="layui-input-inline">

                                <input type="text" style="width:545px;height:35px"  name="userName" required lay-verify="required"
                                       autocomplete="off" readonly="readonly" class="layui-input" value="${user.userName}" >

                            </div>
                        </div>

                        <div class="layui-form-item">
                            <span class="x-red">*</span>上传文件
                            </label>
                            <input type="file" style="width:545px;height:35px"  id="file" onblur="checkfileName()"  name="file"/>
                        </div>
                        <div class="layui-form-item">

                            <span class="x-red">*</span>资料简介
                            </label>
                            <div class="layui-input-inline">
                        <textarea id="L_content" name="fileDescription"
                                  placeholder="简介" style="width:545px;height:240px"  class="layui-textarea fly-editor"></textarea>
                            </div>
                            <div class="layui-form-mid layui-word-aux">
                                <span class="x-red">*</span>
                            </div>
                        </div>
                        <div class="layui-form-item">

                            </label>
                            <button type="submit" style="width:545px;height:50px;color: blue" class="btn btn-default" >提交</button>
                        </div>
                    </form>

                </div>
            </div>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="/DataManage/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="/DataManage/js/popper.min.js"></script>
<script type="text/javascript" src="/DataManage/js/bootstrap.min.js"></script>

<!-- Icons -->
<script type="text/javascript" src="asserts/js/feather.min.js"></script>
<!-- Graphs -->
<script type="text/javascript" src="asserts/js/Chart.min.js"></script>


</body>
</html>
