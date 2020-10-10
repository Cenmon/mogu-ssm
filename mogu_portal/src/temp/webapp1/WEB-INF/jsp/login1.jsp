<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>登录商城</title>
    <link type="text/css" rel="stylesheet" href="/css/login1.css"/>
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
</head>

<body>
<div id="Layer1" style="position:absolute; left:0px; top:0px; width:100%; height:100%">  
	<img src="${pageContext.request.contextPath}/images/background.jpg" width="100%" height="100%"/> 
</div> 

<form id="formlogin" method="post" onsubmit="return false;">
    <div class=" w1" id="entry" width=450px>
        <div class="mc " id="bgDiv">
	        <div class="mc " id="bgDiv">
	        	<img alt="" src="${pageContext.request.contextPath}/images/qrcode.png">
	         </div>
			
            <div class="form ">
                <div class="item fore1">
                    <span>用户名</span>
                    <div class="item-ifo">
                        <input type="text" id="loginname" name="username" class="text"  tabindex="1" autocomplete="off"/>
                        <div class="i-name ico"></div>
                        <label id="loginname_succeed" class="blank invisible"></label>
                        <label id="loginname_error" class="hide"><b></b></label>
                    </div>
                </div>
                
                <script type="text/javascript">
                    setTimeout(function () {
                        if (!$("#loginname").val()) {
                            $("#loginname").get(0).focus();
                        }
                    }, 0);
                </script>
                
                <div id="capslock">键盘大写锁定已打开，请注意大小写</div>
                <div class="item fore2">
                    <span>密码</span>
                    <div class="item-ifo">
                        <input type="password" id="nloginpwd" name="password" class="text" tabindex="2" autocomplete="off"/>
                        <div class="i-pass ico"></div>
                        <label id="loginpwd_succeed" class="blank invisible"></label>
                        <label id="loginpwd_error" class="hide"></label>
                    </div>
                </div>
                <div class="item login-btn2013">
                    <input type="button" class="btn-img btn-entry" id="loginsubmit" value="登录" tabindex="8" clstag="passport|keycount|login|06"/>
                </div>
            </div>
        </div>
        <div class="free-regist">
            <span><a href="register1.html" clstag="passport|keycount|login|08">免费注册&gt;&gt;</a></span>
        </div>
    </div>
</form>

</body>
</html>