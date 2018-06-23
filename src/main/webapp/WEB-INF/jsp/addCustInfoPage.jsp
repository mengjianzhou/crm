<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <div class="layui-inline">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="realName" id="realName" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">手机</label>
            <div class="layui-input-inline">
                <input type="text" name="mobile" id="mobile" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <textarea id="comment" class="layui-textarea" style="width: 250px"></textarea>
            </div>
        </div>
</body>
<script>
    //打开添加用户信息页面
    function openAddCustInfoPage() {
        //示范一个公告层
        layer.open({
            type: 1
            ,
            title: '添加客户信息' //不显示标题栏
            ,
            area: ['25%', '30%']
            ,
            btn: ['提交', '重置']
            ,
            shade: 0.3
            ,
            id: 'add_cust_info' //设定一个id，防止重复弹出
            ,
            content: $('#addCustInfoContent')
            ,
            success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').click(function(){
                    var realName = $('#realName').val();
                    var mobile = $('#mobile').val();
                    var comment = $('#comment').val();
                    $.ajax({
                        type: 'POST',
                        url: "/addCustInfo",
                        data: {'realName':realName,
                                'mobile':mobile,
                                'comment':comment
                        },
                        success: function(data){
                            console.log(data);
                        }
                    });

                });
                btn.find('.layui-layer-btn1').click(function(){
                    $('#realName').val('');
                    $('#mobile').val('');
                    $('#comment').val('');
                });
            }
        });
    }

</script>
</html>
