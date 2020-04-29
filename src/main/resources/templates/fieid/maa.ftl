<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加场地</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>


    <input hidden name="id" id ="id" value="${fieid.id}" style="display:none;">
    <div class="layui-form-item">
        <label class="layui-form-label">场地名称</label>
        <div class="layui-input-block">
            ${fieid.name}
        </div>
    </div>

    <div class="layui-inline">
        <label class="layui-form-label">预约日期</label>
        <div class="layui-input-inline">
            <input type="date" id = "date" class="layui-input" id="test22" placeholder="yyyy-MM-dd">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">场地预约时间</label>
        <div class="layui-input-block">
            <input type="Time" id = "startTime" name="time" lay-verify="required" lay-reqtext="场地开放时间段是必填项，不可为空" placeholder="请输入" autocomplete="off" class="layui-input">
            <input type="Time" id = "endTime" name="time" lay-verify="required" lay-reqtext="场地结束时间段是必填项，不可为空" placeholder="请输入"  autocomplete="off" class="layui-input">
        </div>
    </div>



    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="saveOrder()">预约场地</button>
        </div>
    </div>


<script src="/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>

    layui.use("laydate",function(){
        laydate = layui.laydate;
        laydate.render({
            elem: '#test22'
            ,showBottom: false
        });
    })


    layui.use("layer",function(){
        layer = layui.layer;
        var laydate = layui.laydate;
        laydate.render({
            elem: '#test22'
            ,showBottom: false
        });

    });

    function saveOrder() {
        var id = $("#id").val();
        var date = $("#date").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();

        $.ajax({
            url:'/order/saveOrder',
            type:'post',
            data:{fieid : id, gyDate : date, startTime : startTime, endTime : endTime},
            success:function (response) {
                if(0 == response){
                    alert("预约失败");
                }else if(400 == response){
                    alert("不能预约今天前的日期！！");
                }else {
                    alert("预约成功");
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