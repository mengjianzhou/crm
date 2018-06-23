<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:import url="/header.jsp"></c:import>
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;" id="mainBodyInfoPage">
        欢迎进入CRM系统
    </div>
</div>
<c:import url="/footer.jsp"></c:import>