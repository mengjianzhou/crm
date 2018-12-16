<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>选题结果</title>
</head>
<script src="/js/jquery-3.3.1.js"></script>
<body>
    <table border="1">
        <tr>
            <td>姓名</td>
            <td>手机号</td>
            <td>选题</td>
        </tr>
        <c:forEach var="obj" items="${data}">
        <tr>
            <td>${obj.name}</td>
            <td>${obj.mobile}</td>
            <td>${obj.num}</td>
        </tr>
        </c:forEach>
    </table>
    <button onclick="clearAllXuanTiResult()">清除记录</button>
    <script type="text/javascript">

        function clearAllXuanTiResult(){

            $.ajax({
                type : "POST",
                url: "<%=basePath%>clearAllXuanTiResult",
                success: function( result ) {
                    alert("清理完毕");
                    window.location = "<%=basePath%>xuanTiResult"
                }
            });
        }
    </script>
</body>
</html>
