<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户列表</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>
    <!-- 预约列表 &ndash;&gt; -->
    <table id="userList" lay-filter="test" lay-data="{height: 'full-20', cellMinWidth: 80}" ></table>

　　<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/layui.js"></script>
<script>

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#userList'
            //,height: 'full-200'
            //,toolbar: '#toolbarDemo'
            ,url: '/user/queryAllUser' //数据接口
            ,page: false //开启分页
            ,cols: [[ //表头
                 //{field: 'id', title: 'ID', fixed: 'left'},
                {field: 'userName', title: '用户名称'}
                ,{field: 'userAccount', title: '用户账号'}
                ,{field: 'userTypeStr', title: '用户类型'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
                // ,{field: '', title: '性别', width:80, sort: true}
                // ,{field: 'city', title: '城市', width:80}
                // ,{field: 'sign', title: '签名', width: 177}
                // ,{field: 'experience', title: '积分', width: 80, sort: true}
                // ,{field: 'score', title: '评分', width: 80, sort: true}
                // ,{field: 'classify', title: '职业', width: 80}
                // ,{field: 'wealth', title: '财富', width: 135, sort: true}
            ]]
        });


        table.on('tool(test)', function(obj){
            switch(obj.event){
                case 'edit':
                    updateUserRoot(obj.data);
                    break;
                case 'del':
                    deleteUser(obj.data);
                    break;
            }
        });


        /**
         *  修改用户类型
         */
        function updateUserRoot(data) {
            var userName = data.userName;
            var userType = data.userType==1?"普通用户":"管理员";
            layer.confirm('你确定要修改'+ userName +'为'+ userType +'？', {
                btn: ['YES','NO'] //按钮
            }, function(index){
                layer.close(index);

                $.ajax({
                    url:'/user/updateUserRoot',
                    type:'post',
                    data:{id : data.userId, type: data.userType},
                    success:function (response) {
                        if(0 == response){
                            alert("修改用户[" +userName +"]为["+userType+"]失败，请稍后重试！");
                        }else{
                            table.reload("userList");
                            alert("修改用户[" +userName +"]为["+userType+"]成功");
                        }
                    },error:function () {
                        alert("SYSTEM ERROR !!!");
                    }
                });

            }, function(){
                layer.close();
            });
        }

        /**
         * 删除用户
         * @param data
         */
        function deleteUser(data) {
            layer.confirm('你确定要删除'+ data.userName +'用户？', {
                btn: ['YES','NO'] //按钮
            }, function(index){
                layer.close(index);

                $.ajax({
                    url:'/user/deleteOrderById',
                    type:'post',
                    data:{id : data.id},
                    success:function (response) {
                        if(0 == response){
                            layer.error("删除用户失败");
                        }else{
                            table.reload("userList");
                            layer.msg("删除成功");
                        }
                    },error:function () {
                        layer.error("SYSTEM ERROR !!!");
                    }
                });

            }, function(){
                layer.close();
            });
        }

    });



</script>

<script type="text/html" id="barDemo">
    {{# if(d.userType == 1){ }}
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改用户为普通用户</a>
    {{# } else if(d.userType == 2){ }}
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改用户为管理员</a>
    {{# } }}

    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除用户</a>
</script>

</body>
</html>