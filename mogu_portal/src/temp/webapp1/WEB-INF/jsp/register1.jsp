<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache,must-revalidate">
    <title>注册-个人用户</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/regist.personal.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/passport.base.css"/>
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
</head>
<body>
<div id="Layer1" style="position:absolute; left:0px; top:0px; width:100%; height:100%; z-index:-1" >  
	<img src="${pageContext.request.contextPath}/images/logo.jpg" width="100%" height="100%"/> 
</div> 


<div class="w" id="regist">
    <div class="mt">
        <ul class="tab">
            <li class="curr">个人用户</li>
        </ul>
        <div class="extra">
        <span>我已经注册，现在就&nbsp;
        	<a href="login1.jsp" class="flk13">登录</a>
        </span>
        </div>
    </div>
    <div class="mc">
        <form id="personRegForm" method="post">
            <div class="form" onselectstart="return false;">
                <div class="item" id="select-regName">
                    <span class="label"><b class="ftx04">*</b>用户名：</span>

                    <div class="fl item-ifo">
                        <div class="o-intelligent-regName">
                            <input type="text" id="regName" name="username" class="text" tabindex="1" autoComplete="off"
                                   onpaste="return false;"
                                   value=""
                                   onfocus="if(this.value=='') this.value='';this.style.color='#333'"
                                   onblur="if(this.value=='') {this.value='';this.style.color='#999999'}"/>
                            <i class="i-name"></i>
                            <ul id="intelligent-regName" class="hide"></ul>
                            <label id="regName_succeed" class="blank"></label>
                            <label id="regName_error" class="hide"></label>
                        </div>
                    </div>
                </div>
                <div id="o-password">
                    <div class="item">
                        <span class="label"><b class="ftx04">*</b>请设置密码：</span>

                        <div class="fl item-ifo">
                            <input type="password" id="pwd" name="password" class="text" tabindex="2"
                                   style="ime-mode:disabled;"
                                   onpaste="return  false" autocomplete="off"/>
                        </div>
                    </div>

                    <div class="item">
                        <span class="label"><b class="ftx04">*</b>请确认密码：</span>

                        <div class="fl item-ifo">
                            <input type="password" id="pwdRepeat" name="pwdRepeat" class="text" tabindex="3"
                                   onpaste="return  false" autocomplete="off"/>
                        </div>
                    </div>
                    
					<div class="item" id="dphone">
						<span class="label"><b class="ftx04">*</b>验证手机：</span>

						<div class="fl item-ifo">
							<input type="text" id="phone" maxlength="11" name="phone"
								class="text" tabindex="4"
								autocomplete="off" />
						</div>
					</div>
					
				</div>
				
                <div class="item item-new">
                    <span class="label">&nbsp;</span>

                    <div class="fl item-ifo">
                        <input type="checkbox" class="checkbox" checked="checked" id="readme"
                               onclick="agreeonProtocol();">
                        <label for="protocol">我已阅读并同意<a href="#" class="blue" id="protocol">《用户注册协议》</a></label>
                        <span class="clr"></span>
                        <label id="protocol_error" class="error hide">请接受服务条款</label>
                    </div>
                </div>
                
                <div class="item">
                    <span class="label">&nbsp;</span>
                    <input type="button" class="btn-img btn-regist" id="registsubmit" value="立即注册" tabindex="8"
                           onclick="check();"/>
                </div>
                
            </div>
            
            <div class="phone" >
                <img width="300" height="300" src="${pageContext.request.contextPath}/images/timg.jpg">>
            </div>
        </form>
    </div>
    
<script type="text/javascript">
	function check(){
				//不能为空检查
				if (personRegForm.username.value.length==0){
					alert("用户名不能为空");
					personRegForm.username.focus();
					return;
				}
				
				if (personRegForm.password.value.length==0){
					alert("密码不能为空");
					personRegForm.password.focus();
					return;
				}

				if (personRegForm.password.value.length<6 || personRegForm.password.value.length>20){
					alert("请输入6-20位密码");
					personRegForm.password.focus();
					return;
				}
				
				//密码检查
				if (personRegForm.password.value != personRegForm.pwdRepeat.value) {
					alert("确认密码和密码不一致，请重新输入！");
					$("#pwdRepeat").select();
					$("#pwdRepeat").focus();
					return;
				}
				
				if (personRegForm.phone.value.length==0){
					alert("手机号不能为空");
					personRegForm.phone.focus();
					return;
				}
				
				if (!phoneFun(personRegForm.phone.value)){
					alert("请输入正确的手机号");
					personRegForm.phone.focus();
					return;
				}
				
				personRegForm.submit();
}
	
	//判断是否为手机号的正则表达式
	function phoneFun(phones){
	    var myreg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
	    if (!myreg.test(phones)) {
	        console.log('手机号格式不正确')
	      return false;
	    } else {
	        console.log('手机号格式正确')
	      return true;
	    }
	}
</script>
</body>
</html>