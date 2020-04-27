<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>预约列表</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>
    <!-- 预约列表 &ndash;&gt; -->
    <table id="orderList" lay-filter="test" lay-data="{height: 'full-20', cellMinWidth: 80}" ></table>


<script src="/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#orderList'
            //,height: 'full-200'
            //,toolbar: '#toolbarDemo'
            ,url: '/order/queryAllOrder' //数据接口
            ,page: false //开启分页
            ,cols: [[ //表头
                 //{field: 'id', title: 'ID', fixed: 'left'},
                {field: 'userName', title: '用户姓名'}
                ,{field: 'fieidName', title: '场地名称'}
                ,{field: 'gyDate', title: '预约日期'}
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
                    updateOrder(obj.data);
                    break;
                case 'del':
                    deleteOrder(obj.data);
                    break;
                case 'rootMaa':
                    deleteOrder(obj.data);
                    break;
                case 'maa':
                    alert("请联系管理员取消预约");
                    break;
            }
        });


        /**
         *  修改预约信息
         */
        function updateOrder(data) {
            layer.open({
                title : '编辑预约信息',
                type : 2,
                area : [ '62%', '80%' ],
                maxmin : true,
                shadeClose : true,
                content : '/order/queryOrderById?id='+data.id,
                shade : 0, // 不显示遮罩

                success : function(layero, index) {
                    layer.iframeAuto(index);
                    console.log(data)
                }
            });
        }


        /**
         * 删除预约信息
         * @param data
         */
        function deleteOrder(data) {
            layer.confirm('你确定要删除预约信息？', {
                btn: ['YES','NO'] //按钮
            }, function(index){
                layer.close(index);

                $.ajax({
                    url:'/order/deleteOrderById',
                    type:'post',
                    data:{id : data.id},
                    success:function (response) {
                        if(0 == response){
                            layer.error("DELETE ERROR");
                        }else{
                            table.reload("orderList");
                            layer.msg("DELETE SUCCESS");
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
    {{# if(d.type == 1){ }}
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-checked layui-btn-xs" lay-event="rootMaa">取消预约</a>
    {{# } else { }}
         <a class="layui-btn layui-btn-checked layui-btn-xs" lay-event="maa">取消预约</a>
    {{# } }}
</script>

</body>
</html>