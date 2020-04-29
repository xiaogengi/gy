<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>预约列表</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>
    <form class="layui-form" action="">
        <div class="layui-inline">
            <label class="layui-form-label">用户姓名</label>
            <div class="layui-input-inline">
                <input type="text" id = "userName" name="userName"  placeholder="请输入用户姓名" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="">场地名称</label>
            <div class="layui-input-inline">
                <input type="text" id = "fieidName" name="fieidName"  placeholder="请输入场地名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-inline">
            <label class="">预约日期</label>
            <div class="layui-input-inline">
                <input type="date" id = "gyDate" name="gyDate"  autocomplete="off">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">预约开始 or 结束时间</label>
            <div class="layui-input-inline">
                <input type="Time" id = "startTime" name="startTime" autocomplete="off" >
                <input type="Time" id = "endTime" name="endTime" autocomplete="off" >
            </div>
        </div>

        <div class="layui-inline">
            <div class="layui-input-inline">
                <a class="layui-btn" id="searchBtn" lay-submit
                        lay-filter="formDemo" data-type="reload" style="margin-left: 15px">
                    <i class="layui-icon layui-icon-search"></i> 查询
                </a>
                <#--<button type="reset" class="layui-btn layui-btn-primary">重置</button>-->
            </div>
        </div>
    </form>
    <!-- 预约列表 &ndash;&gt; -->
    <table id="orderList" lay-filter="test" lay-data="{height: 'full-20', cellMinWidth: 80}" ></table>


<script src="/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        var tableIns =  table.render({
            elem: '#orderList'
            ,id:'orderId'
            //,height: 'full-200'
            //,toolbar: '#toolbarDemo'
            ,url: '/order/queryAllOrder' //数据接口
            ,page: false //开启分页
            ,where : {
                fieidName : '',
                startTime : '',
                endTime : '',
                gyDate : '',
                userName : ''
            }
            ,cols: [[ //表头
                 //{field: 'id', title: 'ID', fixed: 'left'},
                {field: 'userName', title: '用户姓名'}
                ,{field: 'fieidName', title: '场地名称'}
                ,{field: 'startTime', title: '场地预约开始时间'}
                ,{field: 'endTime', title: '场地预约结束时间'}
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

        //var $ = layui.$, active = {
          //  reload: function() {
                $('#searchBtn').on('click', function() {
                    table.reload('orderId', {
                        method : 'get',
                        where : {
                                fieidName : $('#fieidName').val(),
                                startTime : $('#startTime').val(),
                                endTime : $('#endTime').val(),
                                gyDate : $('#gyDate').val(),
                                userName : $('#userName').val()
                        }
                    });
                    //return false;
                });
         //   }
        //}




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