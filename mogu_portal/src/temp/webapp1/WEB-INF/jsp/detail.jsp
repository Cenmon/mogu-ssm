<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情页</title>
    <!--设置标签图标-->
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/detail.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/header.css">

</head>
<body>
<!--头部-->
<<div id="header">
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
            <form action="#" >
                <input type="text" placeholder="搜索商品..." class="t_input">
                <input type="submit" class="t_button">
            </form>
            <div class="hot">
                <a href="#">新款连衣裙</a>
                <a href="#">四件套</a>
                <a href="#">潮流T恤</a>
                <a href="#">时尚女鞋</a>
                <a href="#">短裤半身裙</a>
                <a href="#">墙纸</a>
                <a href="#">行车记录仪</a>
                <a href="#">新款男鞋</a>
                <a href="#">耳机</a>
                <a href="#">时尚女包</a>
            </div>
        </div>

        <div class="h_c_code">
            <img src="../images/QR.jpg" alt="">
        </div>
    </div>
    <!--导航-->
    <div class="nav">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">蘑菇精选</a></li>
            <li><a href="#">蘑菇旅行</a></li>
            <li><a href="#">智能生活</a></li>
            <li><a href="#">蘑菇秒杀</a></li>
            <li><a href="#">蘑菇好货</a></li>
        </ul>
    </div>

</div>
<!--面包屑导航-->
<div id="bread_crumb">
    <div class="bread_center">

        <a href="index.html">首页</a>
        <small>&gt</small>
        <a href="#">家具分类</a>
        <small>&gt</small>
        <a href="#">家具装饰</a>
    </div>
</div>
<!--详情展示-->
<div id="detail">
    <!--左侧-->
    <div class="detail_img">
        <img src="../images/detail.jpg" alt="">
    </div>
    <!--右侧-->
    <div class="detail_price">
        <h3>吱音原创 信凳创意北欧设计水曲柳全实木矮凳子家具个性板凳</h3>
        <div class="goods_price">
            <p class="ori_price">原价：￥399.00  <em></em></p>
            <p> 价格： <i class="yuan">￥</i><span class="price">299</span></p>
        </div>
         <div class="goods_count">
             购买数量 <input type="text" value="1">
         </div>

        <div class="goods_buy mt50 ml5">
            <input type="submit" value="加入购物车">
        </div>

    </div>
    
</div>

<!--商品介绍-->
<div id="introduce">
    <h3>商品详情</h3>
    <div class="introduce_body">
        <img src="../images/good-detail01.jpg" alt="">
        <img src="../images/good-detail02.jpg" alt="">
    </div>
</div>

<!--尾部-->
<div id="footer">
    <div class="link">
        <a href="#">消费者保证</a>
        |
        <a href="#">新手上路</a>
        |
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