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
    <script type="text/javascript" language="JavaScript" src="/DataManage/js/register.js"></script>
    <script type="text/javascript" language="JavaScript" src="/DataManage/js/jquery.min.js"></script>
    <script type="text/javascript" language="JavaScript" src="/DataManage/js/jquery.form.js"></script>
    <script type="text/javascript" language="JavaScript" src="/DataManage/js/jquery.js"></script>
    <script type="text/javascript" language="JavaScript" src="/DataManage/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" language="JavaScript" src="/DataManage/jquery.gvChart-1.0.1.min.js"></script>
    <title>用户管理</title>
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
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">文件管理平台</a>
    <a class="nav-item" style="color: white">&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;欢迎你：${user.userName}</a>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="${pageContext.request.contextPath}/user/tologin.html">Sign out</a>
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
                            Customersz
                        </a>
                    </li>

                </ul>


            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <h2>文件列表</h2>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline"
                          action="${pageContext.request.contextPath }/file/tofilelist.html"
                          method="post">

                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="按照文件名" name="tureFileName" />

                        </div>
                        <div class="form-group">

                            <input type="text" class="form-control" placeholder="按照小组名" name="groupName" />
                            <button type="submit" class="btn btn-primary">查询</button>
                        </div>

                        <%-- <div style="position:absolute;right: 50px; width:100px; height:50px;">
                             <a href="${pageContext.request.contextPath }/file/tofilelist.html" class="btn btn-primary">刷新</a>
                         </div>--%>
                    </form>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>小组名</th>
                        <th>资料名</th>
                        <th>上传ip</th>
                        <th>上传人</th>
                        <th>创建时间</th>
                        <th>更新时间</th>
                        <th>浏览数</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var="p" varStatus="v">
                        <tr>
                            <td>${v.index+1}</td>
                            <td>${p.groupName}</td>
                            <td>${p.tureFileName}</td>
                            <td>${p.uploadIp}</td>
                            <td>${p.userName}</td>
                            <td>${p.uploadTime}</td>
                            <td><fmt:formatDate type="both" value="${p.updateTime}" ></fmt:formatDate> </td>
                            <td>${p.fileView}</td>

                            <td>
                                    <%--     ${pageContext.request.contextPath}/file/updatefile.html?id=${p.id}--%>
                                <a href="javascript:;" onclick="deletefile ('${p.userName}','${p.id}','${user.userName}','${user.isAdmin}')" class="btn btn-sm btn-success">删除></a>
                                <a href="${pageContext.request.contextPath}/file/toupdatefile.html?id=${p.id}" class="btn btn-sm btn-success">修改></a>
                                <a href="${pageContext.request.contextPath}/file/download.html?id=${p.id}" class="btn btn-sm btn-success">下载></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="col-md-12 text-right">
                    <ul class="pagination">
                        <li><a href="#">&laquo;</a></li>

                        <li><a href="${pageContext.request.contextPath  }/file/tofilelist.html?currentPage=${page.currentPage==1?1:page.currentPage-1}">上一页</a></li>

                        <li><a href="#">第${page.currentPage}页</a></li>
                        <li><a href="#">共${page.totalPageCount} 页</a></li>

                        <li><a href="${pageContext.request.contextPath  }/file/tofilelist.html?currentPage=${page.currentPage==page.totalPageCount?page.totalPageCount:page.currentPage+1}">下一页</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
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
