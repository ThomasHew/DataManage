<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <title>
          文件上传
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
      <script type="text/javascript" src="/DataManage/js/jquery.min.js"></script>
       <script type="text/javascript" language="JavaScript" src="/DataManage/js/jquery.js"></script>
        <script type="text/javascript" src="/DataManage/js/register.js"></script>
        <link rel="stylesheet" href="/DataManage/css/x-admin.css" media="all">
    </head>

    <body>
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
    </body>

</html>