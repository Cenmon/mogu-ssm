<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>蘑菇商场</title>
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">
</head>
<body>

<!--头部 -->
<div id="header">
    <!--顶部-->
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
                <a href="/my-info.html">个人信息</a>
                <a href="/collection.html">收藏夹</a>
            </div>
        </div>
    </div>
    <!--中部搜索-->
    <div class="header_center">
        <div class="h_c_logo">
            <a href="/"><img src="/images/logo.jpg" alt=""></a>
        </div>
        <div class="h_c_search">
            <form action="#">
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
            <img src="/images/QR.jpg" alt="">
        </div>
    </div>
    <!--导航-->
    <div class="nav">
        <ul>
            <li><a href="http://localhost:8083/">首页</a></li>
            <li><a href="http://localhost:8083/#">蘑菇精选</a></li>
            <li><a href="http://localhost:8083/#">蘑菇旅行</a></li>
            <li><a href="http://localhost:8083/#">智能生活</a></li>
            <li><a href="http://localhost:8083/#">蘑菇秒杀</a></li>
            <li><a href="http://localhost:8083/#">蘑菇好货</a></li>
        </ul>
    </div>
</div>

<!--广告页-->
<div id="ad">
    <img src="/images/index.jpg" alt="">
</div>

<!--收藏-->
<div id="hot_goods">
    <h3>我的收藏</h3>
    <div class="hot_goods_body">
        <ul>
            <li>
                <a href="http://localhost:8083/item.html">
                    <img src="/images/hang.jpg" alt="">
                    <p>超可爱的上吊猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8083/item.html">
                    <img src="/images/despair.jpg" alt="">
                    <p>超可爱的任人宰割猪</p>
                    <i class="yuan">￥</i><span class="price">0.01</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8083/item.html">
                    <img src="/images/scare.jpg" alt="">
                    <p>超可爱的害怕猪</p>
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