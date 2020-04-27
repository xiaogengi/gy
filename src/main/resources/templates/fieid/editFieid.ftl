<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加场地</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>

   <#-- <div class="layui-form-item">
        <label class="layui-form-label">单行输入框</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>-->

    <input hidden name="id" id ="id" value="${fieid.id}" style="display:none;">
    <div class="layui-form-item">
        <label class="layui-form-label">场地名称</label>
        <div class="layui-input-block">
            <input type="text" id = "name" name="name" lay-verify="required" lay-reqtext="场地名称是必填项，不可为空" placeholder="请输入" value="${fieid.name}" autocomplete="off" class="layui-input">
        </div>
    </div>

   <div class="layui-form-item">
        <label class="layui-form-label">场地开放时间段</label>
        <div class="layui-input-block">
            <input type="Time" id = "startTime" name="time" lay-verify="required" lay-reqtext="场地开放时间段是必填项，不可为空" placeholder="请输入" value="${fieid.startTime}" autocomplete="off" class="layui-input">
            <input type="Time" id = "endTime" name="time" lay-verify="required" lay-reqtext="场地结束时间段是必填项，不可为空" placeholder="请输入" value="${fieid.endTime}" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="update()">修改场地信息</button>
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
        var name = $("#name").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        $.ajax({
            url:'/fieid/updateFieid',
            type:'post',
            data:{id : id, name : name, startTime : startTime,endTime : endTime},
            success:function (response) {
                if(0 == response){
                    alert("UPDATE ERROR");
                }else if(400 == response){
                    alert("时间段格式不正确！！！ 正确格式事例： 12:00 - 18:00");
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