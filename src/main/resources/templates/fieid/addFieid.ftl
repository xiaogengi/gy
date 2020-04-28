<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加场地</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>

    <div class="layui-form-item">
        <label class="layui-form-label">场地名称</label>
        <div class="layui-input-block">
            <input type="text" id = "name" name="name" lay-verify="required" lay-reqtext="场地名称是必填项，不可为空" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">场地开放时间段</label>
        <div class="layui-input-block">
            <input type="Time" id = "startTime" name="time" lay-verify="required" lay-reqtext="场地开放时间段是必填项，不可为空" placeholder="请输入" autocomplete="off" class="layui-input">
            <input type="Time" id = "endTime" name="time" lay-verify="required" lay-reqtext="场地结束时间段是必填项，不可为空" placeholder="请输入"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">场地图片</label>
        <div class="layui-input-block">
            <input type="file" id = "imgUrl">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="save()">立即提交</button>
<#--
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
-->
        </div>
    </div>


<script src="/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>

    function save() {
        var name = $("#name").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var imgUrl = $("#imgUrl")[0].files[0];
        if(imgUrl == null || imgUrl == ''){
            alert("场地图片不可为空！");
            return;
        }
        $.ajax({
            url:'/fieid/saveFieid',
            type:'post',
            processData: false,   // jQuery不要去处理发送的数据
            contentType: false,   // jQuery不要去设置Content-Type请求头
            data:{name : name, startTime : startTime,endTime : endTime, file : imgUrl},
            success:function (response) {
                if(0 == response){
                    alert("SAVE ERROR");
                }else if(400 == response){
                    alert("时间段格式不正确！");
                }else{
                    alert("SAVE SUCCESS");

                    $("#name").val("");
                    $("#startTime").val("");
                    $("#endTime").val("");
                    // var index = parent.layer.getFrameIndex(window.name);
                    // parent.layer.close(index);
                    // parent.location.reload();
                }
            },error:function () {
                alert("SYSTEM ERROR !!!");
            }
        });
    }

</script>
</body>

</html>