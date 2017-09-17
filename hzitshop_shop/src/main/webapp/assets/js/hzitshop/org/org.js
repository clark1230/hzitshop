$(function(){

    $.get('/orgAjax.action', function (result) {
        var setting = {
            //页面上的显示效果
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            key:{
                name: "orgName"
            },
            check: {
                enable: true,
                //勾选 checkbox 对于父子节点的关联关系
                chkboxType: { "Y": "", "N": "" }  //Y 属性定义 checkbox 被勾选后的情况；
                //N 属性定义 checkbox 取消勾选后的情况；
                //"p" 表示操作会影响父级节点；
                //"s" 表示操作会影响子级节点。
                //请注意大小写，不要改变
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "orgId",
                    pIdKey: "orgParentId",
                    rootPId: 0
                }
            }
        };

        $(function () {
            $.fn.zTree.init($("#tree"), setting, result);
        });
    });


});