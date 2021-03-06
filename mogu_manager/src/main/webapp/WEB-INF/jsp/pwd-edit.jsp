<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px" align="center">
	<form id="pwdEditForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>旧密码:</td>
	            <td><input class="easyui-textbox" type="password" name="old" data-options="required:true" style="width: 240px;"></input></td>
	        </tr>
	        <tr>
	            <td>新密码:</td>
	            <td><input class="easyui-textbox" type="password" name="news" style="width: 240px;"></input></td>
	        </tr>
	        <tr>
	            <td>确定密码:</td>
	            <td><input class="easyui-textbox" type="password" name="check" style="width: 240px;"></input>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="pwdEditForm.submit()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="pwdEditForm.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
var pwdEditForm = {
		param:{
			//单点登录系统的url
			surl:""
		},
		inputcheck:function(){
				//不能为空检查
				if ($("input[name='old']").val() == "") {
					alert("旧密码不能为空");
					$("input[name='old']").focus();
					return false;
				}
				if ($("input[name='news']").val() == "") {
					alert("新密码不能为空");
					$("input[name='email']").focus();
					return false;
				}
				if ($("input[name='check']").val() == "") {
					alert("确认密码不能为空");
					$("input[name='check']").focus();
					return false;
				}
				if ($("input[name='news']").val() != $("input[name='check']").val()) {
					alert("两次输入密码不同");
					$("input[name='check']").focus();
					return false;
				}
				return true;
		},
		doSubmit:function() {
			
		},
		submit:function() {
			if (this.inputcheck()) {
				$.messager.confirm('确认','确定修改吗？',function(r){
	        	    if (r){
	        	    	$.post("/admin/update",$("#pwdEditForm").serialize(),function(data){
	        				if(data.status == 200){
	        					alert("修改成功！请返回登录界面");
	        					location.href=data.msg;
	        				}else{
	        					alert("修改密码失败！请检查原密码是否正确！");
	        				}
	        			});
	        	    }
	        	});
			}
		}
	};
</script>