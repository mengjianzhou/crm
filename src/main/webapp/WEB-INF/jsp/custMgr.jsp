<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>css/layui.css">
<script src="<%=basePath%>js/layui.js"></script>
<script src="<%=basePath%>js/jquery-3.3.1.js"></script>
<c:import url="/header.jsp"/>

<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;" id="mainBodyInfoPage">
        <div class="layui-col-xs6">
            <div class="grid-demo grid-demo-bg1">
                姓名：
                <div class="layui-inline">
                    <input class="layui-input" name="custName" id="custName" autocomplete="off">
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
                <button class="layui-btn" onclick="openAddCustInfoPage()">添加</button>
                <button class="layui-btn" onclick="delCustInfos()">删除</button>
            </div>
        </div>
        <div class="layui-col-xs6 layui-col-md12">
            <table class="layui-hide" id="custInfoList" lay-filter="custInfoFilter"></table>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
            </script>
        </div>
    </div>
</div>
<div id="addCustInfoContent" style="display: none">
<jsp:include page="addCustInfoPage.jsp"/>
</div>

<script>
    layui.use('layer', function () {
        var layer = layui.layer;
    });

    layui.use('table', function () {
        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#custInfoList'
            , method: 'POST'
            , url: '<%=basePath%>getCustInfoList'
            , cols: [[
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: true}
                , {field: 'name', title: '用户名', width: 80}
                , {field: 'mobile', title: '手机号', width: 150, sort: true, align:'center'}
                , {field: 'investAmount', title: '投资金额', width: 150, sort: true, align:'center'}
                , {field: 'age', title: '年龄', width: 80, sort: true, align:'center'}
                , {field: 'right', title: '操作', width: 177, toolbar: "#barDemo"}
            ]]
            , id: 'testReload'
            , page: true
            , height: 472
        });

        var $ = layui.$, active = {
            reload: function () {
                var custName = $('#custName');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                          custName: custName.val()
                    }
                });
            }
        };

        $('.layui-col-xs6 .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

    function delCustInfos() {

    }
</script>
<c:import url="/footer.jsp"/>






















