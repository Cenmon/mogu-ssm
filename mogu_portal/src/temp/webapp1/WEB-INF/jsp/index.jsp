<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>蘑菇商场</title>
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
</head>

<body>
<!--头部 -->
<div id="header">
    <!--顶部
    <jsp:include page="commons/shortcut.jsp" />-->
    <div class="header_top"><!--快捷方式div.header_top+tap-->
        <div class="h_top_center">
            <div class="h_top_left">
                欢迎来到蘑菇商城
            </div>
            <div class="h_top_right">
                <a href="/login1.html">登录</a>
                <a href="/register1.html">免费注册</a>
                <a href="/cart.html">购物车</a>
                <a href="/my-orders.html">我的订单</a>
                <!-- /my-orders.html -->
                <a href="#">个人信息</a>
                <a href="#">收藏夹</a>
            </div>
        </div>
    </div>
    
    <!--中部搜索-->
    <div class="header_center">
        <div class="h_c_logo">
            <a href="/"><img src="/images/logo.jpg" alt=""></img></a>
        </div>
        <div class="h_c_search">
        <!-- /search.html -->
            <form action="/sea.html">
                <input type="text" placeholder="欢迎来到蘑菇商城..." class="t_input">
                <input type="submit" value="提交" class="t_button">
            </form>
            <div class="hot">
                <a href="#">新款连衣裙</a>
                <a href="#">四件套</a>
                <a href="#">潮流T恤</a>
                <a href="#">时尚女鞋</a>
                <a href="#">短裤</a>
                <a href="#">半身裙</a>
                <a href="#">男士外套</a>
                <a href="#">墙纸</a>
                <a href="#">行车记录仪</a>
                <a href="#">新款男鞋</a>
                <a href="#">耳机</a>
                <a href="#">时尚女包</a>
            </div>
        </div>
        <div class="h_c_logo">
            <img src="../images/QR.jpg" alt="">
        </div>
    </div>
    <!--导航-->
    <div class="nav">
        <ul>
            <li><a href="/">首页</a></li>
            <li><a href="#">蘑菇精选</a></li>
            <li><a href="#">蘑菇旅行</a></li>
            <li><a href="#">智能生活</a></li>
            <li><a href="#">蘑菇秒杀</a></li>
            <li><a href="#">蘑菇好货</a></li>
        </ul>
    </div>
</div>

<!--广告页-->
<div id="ad">
    <img src="../images/index.jpg" alt="">
</div>

<!--秒杀-->
<div id="ms">
    <div class="ms_top">
        <span>蘑菇秒杀</span>
        <span>总有你想不到的低价</span>
    </div>
    <div class="ms_body">
        <ul>
            <li>
                <a href="/item.html">
                    <img src="../images/clothes.jpg" alt="">
                    <p class="ms_title">Coca-Cola 可乐瓶T恤 </p>
                    <p class="ms_detail">简单的纯色基调</p>
                    <i class="yuan">￥</i><span class="price">156</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/rouge.jpg" alt="">
                    <p class="ms_title">Bite 唇釉     </p>
                    <p class="ms_detail">简洁的灰色包装，低调</p>
                    <i class="yuan">￥</i><span class="price">75</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/cup.jpg" alt="">
                    <p class="ms_title">奶喵喵陶瓷咖啡杯  </p>
                    <p class="ms_detail">手工手绘情侣杯 碟下午茶茶杯茶具</p>
                    <i class="yuan">￥</i><span class="price">160</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/pillow.jpg" alt="">
                    <p class="ms_title">北欧现代简约抱枕 </p>
                    <p class="ms_detail">沙发靠垫办公室抱枕床头靠枕</p>
                    <i class="yuan">￥</i><span class="price">45</span>
                </a>
            </li>
            <li>
                <a href="/detail.html">
                    <img src="../images/bench.jpg" alt="">
                    <p class="ms_title">个性板凳 </p>
                    <p class="ms_detail">吱音原创 信凳创意北欧设计水曲柳全实木矮凳子家具个性板凳</p>
                    <i class="yuan">￥</i><span class="price">299</span>
                </a>
            </li>
        </ul>
    </div>
</div>

<!--热卖-->
<div id="hot_goods">
    <h3>热卖商品</h3>
    <div class="hot_goods_body">
        <ul>
            <li>
                <a href="/item.html">
                    <img src="../images/hang.jpg" alt="">
                    <p>超可爱的上吊猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/despair.jpg" alt="">
                    <p>超可爱的任人宰割猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/scare.jpg" alt="">
                    <p>超可爱的害怕猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/heart.jpg" alt="">
                    <p>超可爱的比❤猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/death.jpg" alt="">
                    <p>超可爱的被扼住命运喉咙猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/ballball.jpg" alt="">
                    <p>超可爱的球球猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/gaze.jpg" alt="">
                    <p>超可爱的盯你猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="/item.html">
                    <img src="../images/eat.jpg" alt="">
                    <p>超可爱的能吃猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
        </ul>
    </div>
</div>

<!--尾部-->
<div id="footer">
    <div class="link">
        <a href="#">消费者保证</a>
        |
        <a href="#">新手上路</a>        |
        <a href="#">付款方式</a>
        |
        <a href="#">蘑菇特色</a>
    </div>
    <div class="copyright">
        Copyright&nbsp;&copy;&nbsp;2020-2021&nbsp;&nbsp;蘑菇商城&nbsp;版权所有
    </div>
</div>
</body>
</html>