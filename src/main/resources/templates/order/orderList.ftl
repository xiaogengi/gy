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
                 {field: 'id', title: 'ID', fixed: 'left'}
                ,{field: 'startTime', title: '预约开始时间'}
                ,{field: 'endTime', title: '预约结束时间'}
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
                    updateFieid(obj.data);
                    break;
                case 'del':
                    deleteFieid(obj.data);
                    break;
            }
        });


        function updateFieid(data) {
            alert(data.id);
        }


        function deleteFieid(data) {

        }

    });



</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>