<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>选题结果</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>css/layui.css"  media="all">
    <script src="<%=basePath%>js/layui.js"></script>
    <script src="<%=basePath%>js/jquery-3.3.1.js"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div align="center" style="margin-top: 50px">
    <div><span style="font-size: 20px">选题结果</span></div>
    <table class="layui-hide" id="test"></table>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
    <button onclick="clearAllXuanTiResult()">清除记录</button>
</div>
<script>

    var $layui = layui.jquery, layer = layui.layer;

    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'<%=basePath%>getXuanTiResult'
            ,width: 324
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'name', width:80, title: '姓名'}
                ,{field:'mobile', width:120, title: '学号'}
                ,{field:'num', width:120, title: '选题编号'}
            ]]
        });
    });

    function clearAllXuanTiResult(){
        layer.confirm('确定删除行么?', function(index){
            $.ajax({
                type : "POST",
                url: "<%=basePath%>clearAllXuanTiResult",
                success: function( result ) {
                    layer.alert("清理完毕");
                    window.location.reload();
                }
            });
            layer.close(index);
        });
    }
</script>


</body>
</html>
