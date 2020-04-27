<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加场地</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>



    <input hidden name="id" id ="id" value="${order.id}" style="display:none;">
   <#-- <div class="layui-form-item">
        <label class="layui-form-label">场地名称</label>
        <div class="layui-input-block">
            <input type="text" id = "name" name="name" lay-verify="required" lay-reqtext="场地名称是必填项，不可为空" placeholder="请输入" value="${order.name}" autocomplete="off" class="layui-input">
        </div>
    </div>-->

    <div class="layui-form-item">
        <label class="layui-form-label">预约日期</label>
        <div class="layui-input-block">
            <input type="date" id = "date" name="name" lay-verify="required" lay-reqtext="预约日期是必填项，不可为空" placeholder="请输入" value="${order.gyDate}" autocomplete="off" class="layui-input">
        </div>
    </div>



    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="update()">修改预约信息</button>
        </div>
    </div>


<script src="/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    var layer;
    layui.use("layer",function(){
        layer = layui.layer;

   });

    function update() {
        var id = $("#id").val();
        var name = "";//$("#name").val();
        var date = $("#date").val();
        $.ajax({
            url:'/order/updateOrder',
            type:'post',
            data:{id : id, name : name, gyDate : date},
            success:function (response) {
                if(0 == response){
                    alert("UPDATE ERROR");
                }else if(400 == response){
                    alert("不能预约今天前的日期！！");
                }else{
                    alert("UPDATE SUCCESS");
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.location.reload();
                }
            },error:function () {
                alert("SYSTEM ERROR !!!");
            }
        });
    }





</script>
</body>

</html>