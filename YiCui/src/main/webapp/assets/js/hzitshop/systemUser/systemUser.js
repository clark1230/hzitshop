layui.use(['layer', 'form', 'table', 'common','jquery'], function() {
    var $ = layui.$,
        layer = layui.layer,
        form = layui.form,
        table = layui.table,
        common = layui.common,
        jquery=layui.jquery;

    var tableIns = table.render({
        elem: '#userTables',
        id:'userTable',
        width:'auto',
        limits: [10,20,50,100],
        limit: 20, //默认采用60
        cols: [
            [{
                checkbox: true,
                width: 60,
                fixed: true
            },{
                field: 'userName',
               // edit:true,  //单元格编辑
                width: 120,
                title: '用户名'
            },{
                field:'age',
                width:60,
                title:'年龄'
            },{
                field:'gender',
                width:70,
                title:'性别'
            },{
                field:'qq',
                width:80,
                title:'QQ号'
            },{
                field:'email',
                width:80,
                title:'邮箱'
            },{
                field:'isLock',
                width:70,
                title:'禁用',
                templet :'#isLockTpl'
            },{
                field:'status',
                width:70,
                title:'在职状态',
                templet:'#statusTpl'
            },{
                field:'address',
                width:100,
                title:'地址'
            },{
                field:'company',
                width:100,
                title:'公司'
            },{
                field:'dept',
                width:100,
                title:'部门'
            },{
                field:'jobId',
                width:100,
                title:'岗位'
            },{
                field:'createBy',
                title:"录入人",
                width:80
            },{
                field:'createTime',
                title:'录入时间',
                width:120
            },{
                field:'updateBy',
                title:'修改人',
                width:80
            },{
                field:'updateTime',
                title:'修改时间',
                width:120
            },{

                title: '常用操作',
                width: 200,
                align: 'center',
                toolbar: '#userbar'
            }]

        ],
        url: '/systemUserAjax.action',
        page: true,
        even: true,

    });

    //监听工具条
    table.on('tool(userTables)', function(obj) {
        var data = obj.data;
        if (obj.event === 'edit') {//编辑数据
            //layer.alert('编辑行：<br>' + JSON.stringify(data))
            location.href='/editSystemUser.action?userId='+data.userId;
        }else if (obj.event === 'shouquan') {//用户授权

            layer.alert('授权行：<br>' + JSON.stringify(data))
        }else if (obj.event === 'disable') {//禁用或者启用用户
           // layer.alert('禁用行：<br>' + JSON.stringify(data))
            var isLock;
            var msg = '';
            if(data.isLock == 0){
                //启用
                isLock =1;
                msg = '启用成功!';
                //刷新当表格数据
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
            var reqData = 'userId='+data.userId +"&isLock="+isLock;
            //异步修改数据
            $.post('/lockUser.action',reqData,function(resp){
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
                $.get('/deleteSystemUser.action?userId='+data.userId,function(resp){
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
    function reload(){
        tableIns.reload();
    }
    $('#larry_group .layui-btn').on('click',function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    var active = {
        add:function(){//添加用户信息
            //common.larryCmsMessage('最近好累，还是过段时间在写吧！','error');
            location.href ='/addSystemUser.action';
         },grant:function(){//批量授权
            var userIdArr =[];
            var selectData = table.checkStatus('userTable'); //test即为基础参数id对应的值
            if(selectData.data.length ==0){
                layer.msg('请选择要分配岗位的用户!',{icon:3});
            }else{
                for(var i=0;i<selectData.data.length;i++){
                    userIdArr.push(selectData.data[i].userId);
                }
                //跳转到授权页面
                layer.open({
                    type: 2,
                    title: '授予角色',
                    shadeClose: true,
                    shade: false,
                    maxmin: true,
                    area: ['800px', '500px'],
                    content: '/grantJob.action?userId='+userIdArr //iframe的url
                });
            }
        },del:function(){//批量删除数据
            var userIdArr =[];
            var selectData = table.checkStatus('userTable');
            if(selectData.data.length ==0){
                layer.msg('请选择要删除的数据!',{icon:3});
            }else{
                layer.confirm('真的删除当前选择的数据吗?', function(index) {
                    for(var i=0;i<selectData.data.length;i++){
                        userIdArr.push(selectData.data[i].userId);
                    }
                    //异步发送数据
                    $.get('/deleteSystemUser.action?userId='+userIdArr,function(resp){
                        if(resp.code === 200){
                            layer.msg('删除成功!',{icon:1});
                            //刷新当表格数据
                            setTimeout(function(){
                                reload();
                            },1500);
                        }else{
                            layer.msg('删除失败!',{icon:2})
                        }
                    });
                });
            }
        },colvis:function(){//显示/隐藏列

        },
        resetPwd:function(){
            var selectData = table.checkStatus('userTable');
            if(selectData.data.length ==0){
                layer.msg('请选择要重置密码的用户!',{icon:3});
            }else if(selectData.data.length >1){
                layer.msg('所选用户个数不能大于1个!',{icon:2});
            }else{
                var url = '/resetPwd.action';
                var data ='userId='+selectData.data[0].userId+"&userName="+selectData.data[0].userName+"&email="+selectData.data[0].email;
                $.post(url,data,function(resp){
                    if(resp.code == 200){
                        layer.msg('密码重置成功!',{icon:1});
                    }else{
                        layer.msg('密码重置失败!',{icon:2});
                    }
                });
            }
        }
    };
});