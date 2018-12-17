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
      <script type="text/javascript" src="/ssmdemo/JS/jquery.min.js"></script>
       <script type="text/javascript" language="JavaScript" src="/ssmdemo/JS/jquery.js"></script>
        <script type="text/javascript" src="/ssmdemo/JS/register1.js"></script>
        <link rel="stylesheet" href="/ssmdemo/CSS/x-admin.css" media="all">
    </head>
    
    <body>
    <div id="login_dialog" >
        <div class="x-body">
            <form class="layui-form"  action="${pageContext.request.contextPath }/user/uploadfile.do" method="post" enctype="multipart/form-data">
             <div class="layui-form-item">
             

                        <span class="x-red">*</span>资料名称

                    <div class="layui-input-inline">
                    <input class="layui-input"  type="text" id="fileName"  name="fileName"  readonly="readonly" />
                        <!-- <input type="text" id="file" name="fileName" required lay-verify="required" -->
                       <!--  autocomplete="off" readonly="readonly" class="layui-input" value=""> -->
                    </div>
                </div>
                <div class="layui-form-item">

                        <span class="x-red">*</span>小组名称

                    <div class="layui-input-inline">
                        
                            <input type="text"  name="userGroup" required lay-verify="required"
                                   autocomplete="off" readonly="readonly" class="layui-input" value="${user.userGroup }" >
                         
                    </div>
                </div>

                <div class="layui-form-item">

                        <span class="x-red">*</span>上传人

                    <div class="layui-input-inline">
                        
                            <input type="text"  name="userName" required lay-verify="required"
                                   autocomplete="off" readonly="readonly" class="layui-input" value="${user.userName}" >
                     
                    </div>
                </div>

                 	<div class="layui-form-item">
                        <span class="x-red">*</span>上传文件
                    </label>
                        <input type="file" id="file" onblur="checkfileName()"  name="file"/> 
                     </div>
                <div class="layui-form-item">

                        <span class="x-red">*</span>资料简介
                    </label>
                    <div class="layui-input-inline">
                        <textarea id="L_content" name="fileDescribe" 
                        placeholder="简介" class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>
                    </div>
                </div>
                <div class="layui-form-item">

                    </label>
                 			 <button type="submit" class="btn btn-default" >提交</button>
                </div>
            </form>
        
        <script src="/ssmdemo/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="/ssmdemo/JS/x-layui.js" charset="utf-8"></script>      
        </div>
    </body>
		
</html>