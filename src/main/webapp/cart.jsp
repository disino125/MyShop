<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>cart</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!--------------------------------------cart--------------------->
<%@ include file="header.jsp"%>
<div class="cart mt"><!-----------------logo------------------->
    <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="img/temp/logo.png"></a><img class="top" src="img/temp/cartTop01.png"></h1></div>-->
    <!-----------------site------------------->
    <div class="site"><p class=" wrapper clearfix"><span class="fl">Einkaufwagen</span><img class="top"
                                                                                   src="img/temp/cartTop01.png"><a
            href="index.html" class="fr">Shopping weiter&gt;</a></p></div><!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>Produkt</div>
            <div>Preiß</div>
            <div>Anzahl</div>
            <div>Summe</div>
            <div>bedienen</div>
        </div>

        <c:forEach var="c" items="${carts}">
            <div class="th">
                <div class="pro clearfix">
                    <label class="fl">
                        <input name="checkedCart" type="checkbox" value="${c.CART_ID}"/><span></span>
                    </label>
                    <a class="fl" href="selectProductDetail?id=${c.CART_P_ID}">
                        <dl class="clearfix">
                            <dt class="fl"><img src="img/products/${c.CART_P_IMG}" height="120" width="120"></dt>
                            <dd class="fl"><p>${c.CART_P_NAME}</p>
                                <p>Kategorie:</p>
                                <p>hahaha</p>
                            </dd>
                        </dl>
                    </a>
                </div>
                <div class="price">￥${c.CART_P_PRICE}.00</div>
                <div class="number">
                    <p class="num clearfix">
                        <img class="fl sub" src="img/temp/sub.jpg">
                        <span cartId="${c.CART_ID}" class="fl">${c.CART_P_QUANTITY}</span>
                        <img class="fl add" src="img/temp/add.jpg">
                    </p>
                </div>
                <div class="price sAll">￥${c.CART_P_PRICE*c.CART_P_QUANTITY}.00</div>
                <div class="price"><a class="del" href="#2" cartId="${c.CART_ID}">löschen</a></div>
            </div>
        </c:forEach>

        <div class="goOn">Leer~<a href="indexSelect">Umbummeln</a></div>
        <div class="tr clearfix"><label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>
            <p class="fl"><a href="#">alle</a><a href="#" class="del">löschen</a></p>
            <p class="fr"><span>insges.<small id="sl">0</small>Produkte</span><span>Summe:&nbsp;<small id="all">￥0.00</small></span><a
                    href="javascript:toOrder()" class="count">bezahlen</a></p></div>
    </div>
</div>
<script>
    function toOrder() {
        var cids = "";
        $("input[name='checkedCart']:checked").each(function (index,item) {
            if(index==$("input[name='checkedCart']:checked").length-1){
                cids+= $(this).val();
            }else {
                cids+= $(this).val()+",";
            }
        });
        location.href="orderSelect?cids="+cids;
    }
</script>
<div class="mask"></div>
<div class="tipDel"><p>wollen Sie den Produkt löschen？</p>
    <p class="clearfix"><a class="fl cer" href="#">Ja</a><a class="fr cancel" href="#">Nein</a></p></div><!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>zur<br/>Kasse</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：188-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div><!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
<div class="proDets"><img class="off" src="img/temp/off.jpg"/>
    <div class="proCon clearfix">
        <div class="proImg fr"><img class="list" src="img/temp/proDet.jpg"/>
            <div class="smallImg clearfix"><img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg"><img
                    src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg"><img src="img/temp/proDet03.jpg"
                                                                                          data-src="img/temp/proDet03_big.jpg"><img
                    src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg"></div>
        </div>
        <div class="fl">
            <div class="proIntro change"><p>颜色分类</p>
                <div class="smallImg clearfix"><p class="fl on"><img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                                                     data-src="img/temp/proBig01.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                       data-src="img/temp/proBig02.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg"></p>
                </div>
            </div>
            <div class="changeBtn clearfix"><a href="#2" class="fl"><p class="buy">确认</p></a><a href="#2" class="fr"><p
                    class="cart">取消</p></a></div>
        </div>
    </div>
</div>
<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="img/temp/off.jpg"/></div>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
