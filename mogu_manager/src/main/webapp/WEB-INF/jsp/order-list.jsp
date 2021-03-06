<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="orderList" title="" 
       data-options="singleSelect:false,collapsible:true,pagination:true,pageSize:10,url:'/order/list',method:'get',toolbar:toolbar">
    <!-- url:'/user/list',method:'get', -->
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'orderId',width:80">订单ID</th>
            <th data-options="field:'title',width:200,align:'left'">商品名称</th>
            <th data-options="field:'payment',width:60,formatter:TAOTAO.formatPrice">商品金额</th>
            <th data-options="field:'totalFee',width:100,formatter:TAOTAO.formatPrice">总费用</th>
            <th data-options="field:'shippingName',width:80,align:'left'">发送人姓名</th>
            <th data-options="field:'receiverName',width:80,align:'left'">接收人姓名</th>
            <th data-options="field:'receiverCity',width:80,align:'left'">接收人所在地</th>
            <th data-options="field:'receiverPhone',width:100,align:'left'">接收人手机号码</th>
            <th data-options="field:'paymentTime',width:130,formatter:TAOTAO.formatDateTime">支付时间</th>
            <th data-options="field:'consignTime',width:130,align:'right',formatter:TAOTAO.formatDateTime">检出时间</th>
        </tr>
    </thead>
</table>
<div id="orderEditWindow" class="easyui-window" title="编辑订单" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
    function getSelectionsIds(){
    	var itemList = $("#orderList");
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
        		$.messager.alert('提示','未选中订单!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/order/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除订单成功!',undefined,function(){
            					$("#userList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>