<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>场地列表</title>
    <link rel="stylesheet" href="/css/layui.css">
</head>
<body>

    <form class="layui-form" action="">

        <div class="layui-inline">
            <label class="">场地名称</label>
            <div class="layui-input-inline">
                <input type="text" id = "fieidName" name="fieidName"  placeholder="请输入场地名称" autocomplete="off" class="layui-input">
            </div>
        </div>


        <#--<div class="layui-inline">
            <label class="layui-form-label">预约开始 or 结束时间</label>
            <div class="layui-input-inline">
                <input type="Time" id = "startTime" name="startTime" autocomplete="off" >
                <input type="Time" id = "endTime" name="endTime" autocomplete="off" >
            </div>
        </div>-->

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
    <table id="fieidList" lay-filter="test" lay-data="{height: 'full-20', cellMinWidth: 80}" ></table>

　　<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="/layui.js"></script>
<script>

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#fieidList'
            //,height: 'full-200'
            //,toolbar: '#toolbarDemo'
            ,url: '/fieid/queryAllFieid' //数据接口
            ,id: "fieidId"
            ,where:{
                name : ''
            }
            ,page: false //开启分页
            ,cols: [[ //表头
                 //{field: 'id', title: 'ID', fixed: 'left'},
                {field: 'name', title: '场地名称'}
                ,{field: 'time', title: '开放时间段'}
                ,{field: 'picture', title: '场地', width: 100,height:100, templet:'<div><img src="/getFile/{{ d.imgUrl }}"></div>'}
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
                case 'maa':
                    maaFieid(obj.data);
                    break;
            }
        });


        $('#searchBtn').on('click', function() {
            table.reload('fieidId', {
                method : 'get',
                where : {
                    name : $('#fieidName').val(),
                }
            });
            //return false;
        });


        /**
         * 预约场地
         */
        function maaFieid(data) {

            layer.open({
                title : '预约场地',
                type : 2,
                area : [ '62%', '80%' ],
                maxmin : true,
                shadeClose : true,
                content : '/fieid/maaQueryFieidById?id='+data.id,
                shade : 0, // 不显示遮罩

                success : function(layero, index) {
                    layer.iframeAuto(index);
                    console.log(data)
                }
            });

        }

        /**
         * 修改场地信息
         */
        function updateFieid(data) {
            // layer.confirm('你确定要修改场地信息？', {
            //     btn: ['YES','NO'] //按钮
            // }, function(index){
            //     layer.close(index);

            layer.open({
                title : '编辑场地信息',
                type : 2,
                area : [ '62%', '80%' ],
                maxmin : true,
                shadeClose : true,
                content : '/fieid/queryFieidById?id='+data.id,
                shade : 0, // 不显示遮罩

                success : function(layero, index) {
                    layer.iframeAuto(index);
                    console.log(data)
                }
            });
            //
            // }, function(){
            //     layer.close();
            // });
        }


        /**
         * 删除场地信息
         * @param data
         */
        function deleteFieid(data) {
            layer.confirm('你确定要删除场地信息？', {
                btn: ['YES','NO'] //按钮
            }, function(index){
                layer.close(index);

                $.ajax({
                    url:'/fieid/deleteFieidById',
                    type:'post',
                    data:{id : data.id},
                    success:function (response) {
                        if(0 == response){
                            layer.error("DELETE ERROR");
                        }else{
                            table.reload("fieidList");
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
    {{# } }}
    <a class="layui-btn layui-btn-checked layui-btn-xs" lay-event="maa">预约</a>
</script>

</body>
</html>