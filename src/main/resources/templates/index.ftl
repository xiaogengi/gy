<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>体育馆预约</title>
    <link rel="stylesheet" href="./css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">体育馆预约 后台布局</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">

                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">场地管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a data-url="/fieid/fieidList"
                               data-id="0001"
                               data-title="场地信息"
                               class="site-demo-active"
                               href="javascript:;"
                               data-type="tabAdd">场地信息</a>
                        </dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">预约管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a data-url="/order/orderList"
                               data-id="1111"
                               data-title="预约信息"
                               class="site-demo-active"
                               href="javascript:;"
                               data-type="tabAdd">预约信息</a>
                        </dd>
                    </dl>
                </li>


            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab layui-tab-card" lay-filter="demo" lay-allowclose="true" >
            <ul class="layui-tab-title">

            </ul>
            <div class="layui-tab-content">

            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="./layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        var $ = layui.jquery;
        //触发事件
        var active = {
            //在这里给active绑定几项事件，后面可通过active调用这些事件
            tabAdd: function(url,id,name) {
                //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
                //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
                element.tabAdd('demo', {
                    title: name,
                    content: '<iframe data-frameid="'+id+'" frameborder="0"  scrolling="no" src="'+url+'" style="width:100%;height: 500px" ></iframe>',
                    id: id //规定好的id
                })
                element.render('tab');

            },
            tabChange: function(id) {
                //切换到指定Tab项
                element.tabChange('demo', id); //根据传入的id传入到指定的tab项
            },
            tabDelete: function (id) {
                element.tabDelete("demo", id);//删除
            }
            , tabDeleteAll: function (ids) {//删除所有
                $.each(ids, function (i,item) {
                    element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
                })
            }
        };


        //当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
        $('.site-demo-active').on('click', function() {
            var dataid = $(this);

            //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
            if ($(".layui-tab-title li[lay-id]").length <= 0) {
                //如果比零小，则直接打开新的tab项
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
            } else {
                //否则判断该tab项是否以及存在

                var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                $.each($(".layui-tab-title li[lay-id]"), function () {
                    //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                    if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                        isData = true;
                    }
                })
                if (isData == false) {
                    //标志为false 新增一个tab项
                    active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
                }
            }
            //最后不管是否新增tab，最后都转到要打开的选项页面上
            active.tabChange(dataid.attr("data-id"));
        });

    });



</script>
</body>
</html>