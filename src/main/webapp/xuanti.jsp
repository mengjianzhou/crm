<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        <title>选题</title>
        <script src="<%=basePath%>js/jquery-3.3.1.js"></script>
    </head>
    <body>
    <!-- 内容主体区域 -->
    请输入您的手机号和姓名进行选题：<br>
    <label class="layui-form-label">手机号：</label> <input type="text" id="mobile" name="mobile" value="" class="layui-input"/><br>
    <label class="layui-form-label">姓&nbsp;&nbsp;&nbsp;名：</label>   <input type="text" id="name" name="name" value="" class="layui-input"/><br>

    <button name="xuantiBtn" onclick="xuanti()">选题</button>
    </body>
    <script type="text/javascript">
        layui.use('layer', function () {
            var layer = layui.layer;
        });

        function xuanti(){
            var mobile = $('#mobile').val();
            var name = $('#name').val();
            if(mobile==''||name==''||mobile.length==0||name.length==0){
                alert("请输入手机号和姓名");
                return;
            }
            $.ajax({
                type : "POST",
                url: "<%=basePath%>xuanti",
                data: {
                    mobile: mobile,
                    name : name
                },
                success: function( result ) {
                    alert(result);
                }
            });
        }
    </script>
</html>
