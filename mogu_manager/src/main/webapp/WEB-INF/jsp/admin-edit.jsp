<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px" align="center">
	<form id="adminEditForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>头像:</td>
	            <td>
	                <input type="hidden" name="img" value="${admin.img }" />
	                
	                <a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">
	                	<value>
	                		<img src="${admin.img }" width="50" height="50">
	                	</value>
	                </a>
	            </td>
	        </tr>
	        <tr></tr>
	        <tr>
	            <td>用户名:</td>
	            <td><input class="easyui-textbox" type="text" name="username" value="${admin.username }" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr></tr>
	        <tr>
	            <td>电子邮箱:</td>
	            <td><input class="easyui-textbox" type="text" name="email" value="${admin.email }" style="width: 280px;"></input></td>
	        </tr>
	        <tr></tr>
	        <tr>
	            <td>手机号码:</td>
	            <td><input class="easyui-textbox" name="phone" value="${admin.phone }" data-options="multiline:true,validType:'length[0,150]'" style="width: 280px;"></input>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="adminEditForm.submit()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="adminEditForm.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
/* var contentEditEditor ;
$(function(){
	contentEditEditor = TT.createEditor("#adminEditForm [name=content]");
	TT.initOnePicUpload();
}); */

$(function(){
	TT.initOnePicUpload();
});
var adminEditForm = {
		param:{
			//单点登录系统的url
			surl:""
		},
		inputcheck:function(){
				//不能为空检查
				if ($("input[name='username']").val() == "") {
					alert("用户名不能为空");
					$("input[name='username']").focus();
					return false;
				}
				if ($("input[name='email']").val() == "") {
					alert("密码不能为空");
					$("input[name='email']").focus();
					return false;
				}
				if ($("input[name='phone']").val() == "") {
					alert("手机号不能为空");
					$("input[name='phone']").focus();
					return false;
				}
				return true;
		},
		/* beforeSubmit:function() {
				//检查用户是否已经被占用
				$.ajax({
	            	url : REGISTER.param.surl + "/admin/check/"+$("#username").val()+"/1?r=" + Math.random(),
	            	success : function(data) {
	            		if (data.data) {
	            			
	            			//检查手机号是否存在
	            			$.ajax({
	            				url : REGISTER.param.surl + "/admin/check/"+$("#phone").val()+"/3?r=" + Math.random(),
				            	success : function(data) {
				            		if (data.data) {
				            			
				            			//检查邮箱
					            		$.ajax({
					            			url:REGISTER.param.surl + "/admin/check/"+$("#email").val()+"/2?r=" + Math.random(),
					            			success:function(data){
					            				if(data.data){
					            					REGISTER.doSubmit();
					            				}else{
					            					alert("此电子邮箱已经被注册！");
							            			$("#email").select();
					            				}
					            			}
					            		});
				            		} else {
				            			alert("此手机号已经被注册！");
				            			$("#phone").select();
				            		}
				            	}
	            			});
	            		} else {
	            			alert("此用户名已经被占用，请选择其他用户名");
	            			$("#username").select();
	            		}	
	            	}
				});
	            	
		}, */
		doSubmit:function() {
			$.post("/admin/update/data",$("#adminEditForm").serialize(), function(data){
				if(data.status == 200){
					alert('更新成功！');
					REGISTER.refresh();
				} else {
					alert("更新失败！");
				}
			});
		},
		refresh:function() {
			// 注册成功，重定向到登录页面
			 location.href = "/";
			 return false;
		},
		submit:function() {
			if (this.inputcheck()) {
				this.doSubmit();//用户名和电话号码检测
			}
		}
	};
</script>