<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <title>选题</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" type="text/css" href="<%=basePath%>css/layui.css"/>
        <script src="<%=basePath%>js/jquery-3.3.1.js"></script>
        <script src="<%=basePath%>js/layui.all.js"></script>
        <style type="text/css">
            .a1 {
                margin-top: 200px;
            }

            .c1{
                margin: 0 auto;
            }

            .m1{
                margin-top: 25px;
            }

            .t1{
                margin-top: 5px;
            }

            body{background-color: #87CEFA}
        </style>
    </head>
    <body >
    <div class="a1" >
        <!-- 内容主体区域 -->
        <div style="text-align: center;font-family: Cambria;font-size: 20px">请输入您的学号和姓名进行选题：</div><br>
        <div align="center">
            <table>
                <tr class="t1">
                    <td align="right" ><label style="font-size: 18px">学号：</label></td>
                    <td><input type="text" id="mobile" name="mobile" value="" class="layui-text" style="margin-bottom:5px;width:150px;height:30px"/></td>
                </tr>
                <tr class="t1">
                    <td align="right"><label style="font-size: 18px">姓名：</label></td>
                    <td><input type="text" id="name" name="name" value="" class="layui-text" style="margin-bottom:5px;width:150px;height:30px"/></td>
                </tr>
            </table>
        </div>
        <div class="m1" align="center">
            <button name="xuantiBtn" onclick="xuanti()" class="layui-btn layui-btn-normal" style="width: 150px; height: 45px">选题</button>
        </div>
    </div>
    </body>
    <script type="text/javascript">
        var $ = layui.jquery, layer = layui.layer;
        function xuanti(){
            var mobile = $('#mobile').val();
            var name = $('#name').val();
            if(mobile==''||name==''||mobile.length==0||name.length==0){
                alert("请输入学号和姓名进行选题");
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
                    layer.alert("您的选题编号是："+ result);
                }
            });
        }
    </script>
</html>
