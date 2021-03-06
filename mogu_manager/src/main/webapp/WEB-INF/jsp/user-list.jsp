<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="userList" title="" 
       data-options="singleSelect:false,collapsible:true,pagination:true,pageSize:10,url:'/user/list',method:'get',toolbar:toolbar">
    <!-- url:'/user/list',method:'get', -->
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">用户ID</th>
            <th data-options="field:'username',width:80">用户名</th>
            <th data-options="field:'password',width:100">密码</th>
            <th data-options="field:'phone',width:90">手机号码</th>
            <th data-options="field:'email',width:150,align:'right'">邮箱</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<script>
    function getSelectionsIds(){
    	var itemList = $("#userList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中用户!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/user/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除用户成功!',undefined,function(){
            					$("#userList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>