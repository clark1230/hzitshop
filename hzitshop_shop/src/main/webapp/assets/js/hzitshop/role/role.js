layui.use(['layer', 'form', 'table', 'common','jquery'], function() {
    var $ = layui.$,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        common = layui.common,
        jquery=layui.jquery;

    var tableIns = table.render({
        elem: '#roleTables',
        id:'roleTable',
        width:'auto',
        limits: [10,20,50,100],
        limit: 20, //默认采用60
        cols: [
            [{
                checkbox: true,
                width: 60,
                fixed: true
            },{
                field: 'roleName',
                // edit:true,  //单元格编辑
                width: 120,
                title: '角色名'
            },{
                field:'description',
                title:'描述',
                width:100
            },{
                field:'isLock',
                title:'锁定',
                width:80,
                templet:'#isLockTpl'
            },{
                field:'createBy',
                title:"录入人",
                width:80
            },{
                field:'createTime',
                title:'录入时间',
                width:180
            },{
                field:'updateBy',
                title:'修改人',
                width:80
            },{
                field:'updateTime',
                title:'修改时间',
                width:180
            },{

                title: '常用操作',
                width: 200,
                align: 'center',
                toolbar: '#roleBar'
            }]

        ],
        url: '/roleAjax.action',
        page: true,
        even: true,

    });

    //监听工具条
    table.on('tool(userTables)', function(obj) {
        var data = obj.data;
        if (obj.event === 'edit') {//编辑数据
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            location.href='/editRole.action?roleId='+data.roleId;
        }else if (obj.event === 'shouquan') {//授权

            layer.alert('授权行：<br>' + JSON.stringify(data))
        }else if (obj.event === 'disable') {//禁用或者启用角色
            // layer.alert('禁用行：<br>' + JSON.stringify(data))
            var isLock;
            var msg = '';
            if(data.isLock == 0){
                //启用
                isLock =1;
                msg = '启用成功!';
                setTimeout(function(){
                    reload();
                },1500);
            }else{
                //禁用
                isLock =0;
                msg = '禁用成功!';
                setTimeout(function(){
                    reload();
                },1500);
            }
            var reqData = 'roleId='+data.roleId +"&isLock="+isLock;
            //异步修改数据
            $.post('/lockRole.action',reqData,function(resp){
                if(resp.code === 200){
                    layer.msg(msg,{icon:1});

                    //修改按钮的文本

                }else{
                    layer.msg('操作失败!',{icon:2});
                }
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除当前选择的数据吗?', function(index) {
                obj.del();
                //异步发送数据
                $.get('/deleteRole.action?roleId='+data.roleId,function(resp){
                    if(resp.code === 200){
                        layer.msg('删除成功!',{icon:1});
                    }else{
                        layer.msg('删除失败!',{icon:2})
                    }
                });
                layer.close(index);
            });
        }
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
            //common.larryCmsMessage('最近好累，还是过段时间在写吧！','error');
            location.href ='/addRole.action';
        },grant:function(){//批量授权
            common.larryCmsMessage('最近好累，还是过段时间在写吧！','error');
            var roleIdArr =[];
            var selectData = table.checkStatus('userTable'); //test即为基础参数id对应的值
            if(selectData.data.length ==0){
                layer.msg('请选择要授权的数据!',{icon:3});
            }else{
                for(var i=0;i<selectData.data.length;i++){
                    roleIdArr.push(selectData.data[i].roleId);
                }

                //跳转到授权页面

            }
        },del:function(){//批量删除数据
            var roleIdArr =[];
            var selectData = table.checkStatus('roleTable');
            if(selectData.data.length ==0){
                layer.msg('请选择要删除的数据!',{icon:3});
            }else{
                layer.confirm('真的删除当前选择的数据吗?', function(index) {
                    for(var i=0;i<selectData.data.length;i++){
                        roleIdArr.push(selectData.data[i].roleId);
                    }
                    //异步发送数据
                    $.get('/deleteRole.action?roleId='+roleIdArr,function(resp){
                        if(resp.code === 200){
                            layer.msg('删除成功!',{icon:1});
                        }else{
                            layer.msg('删除失败!',{icon:2})
                        }
                    });
                });
            }
        }
    };
});