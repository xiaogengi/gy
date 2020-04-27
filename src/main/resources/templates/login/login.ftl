<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登陆体育馆预约系统</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>

    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" id = "userAccount" name="name" lay-verify="required" lay-reqtext="账号是必填项，不可为空" placeholder="请输入账号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" id = "userPwd" name="name" lay-verify="required" lay-reqtext="密码是必填项，不可为空" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="login()">登陆</button>
<#--
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
-->
        </div>
    </div>


<script src="/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>

    function login() {
        var userAccount = $("#userAccount").val();
        var userPwd = $("#userPwd").val();
        $.ajax({
            url:'/login/login',
            type:'post',
            data:{userAccount : userAccount, userPwd : userPwd},
            dataType:'json',
            success:function (response) {
               if(response.code == 200){
                   alert(response.msg);
                   location.href = "/";
                   alert("欢迎 " + response.userName + response.userType + "登陆体育馆预约系统");
               }else{
                   alert(response.msg);
               }
            },error:function () {
                alert("SYSTEM ERROR !!!");
            }
        });
    }

</script>
</body>

</html>