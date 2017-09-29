layui.use(['layer', 'form', 'table', 'common','jquery'], function() {
    var $ = layui.$,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        common = layui.common,
        jquery=layui.jquery;

    var tableIns = table.render({
        elem: '#logTables',
        id:'logTable',
        width:'auto',
        limits: [10,20,50,100],
        limit: 20, //默认采用60
        cols: [
            [{
                checkbox: true,
                width: 60,
                fixed: true
            },{
                field: 'username',
                // edit:true,  //单元格编辑
                width: 120,
                title: '用户名'
            },{
                field:'module',
                title:'模块',
                width:130
            },{
                field:'method',
                title:'方法',
                width:180
            },{
                field:'responseDate',
                title:'响应时间(毫秒)',
                width:150,
                templet:'#responseDateTpl'
            },{
                field:'ip',
                title:'ip地址',
                width:150
            },{
                field:'date',
                title:'操作时间',
                width:200
            },{
                field:'commit',
                title:'操作结果',
                width:100,
                align:'center',
                templet:'#commitTpl'
            }]

        ],
        url: '/logAjax.action',
        page: true,
        even: true,
    });

    /**
     * 表格重载
     */
     function  reload(){
        tableIns.reload();
     }
    $('#larry_group .layui-btn').on('click',function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    var active = {
        add:function(){//添加用户信息
           
        },grant:function(){//批量授权
        }
    };
});