<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>收货地址_用户中心</title>
    <link rel="stylesheet" href="/res/css/style.css"/>
    <script src="/res/js/jquery.js"></script>
    <script src="/res/js/com.js"></script>
    <script type="application/javascript">
        $(function () {
            var url = "/buyer/province.shtml";
            $.post(url, function (data) {
                var provinces = data.provinces;
                var html = '<option value="" selected>省/直辖市</option>';
                for (var i = 0; i < provinces.length; i++) {
                    html += "<option value=" + provinces[i].code + ">" + provinces[i].name + "</option>";
                }
                $("#province").html(html);
            });

        });
        function changeProvince(value) {

            var url = "/buyer/city.shtml";
            var params = {"province": value};
            $.post(url, params, function (data) {
                var cities = data.cities;
                var html = "<option value='' selected='selected'>城市</option>";
                for (var i = 0; i < cities.length; i++) {
                    html += "<option value=" + cities[i].code + ">" + cities[i].name + "</option>";

                }
                //改变城市
                $("#city").html(html);

                //改变县区
                var html1 = '<option value="" selected>县/区</option>';
                $("#town").html(html1);

            })
        }

        function changeCity(value) {
            var url = "/buyer/town.shtml";
            var params = {"city": value};
            $.post(url, params, function (data) {
                var towns = data.towns;
                var html = "<option value='' selected='selected'>县区</option>";
                for (var i = 0; i < towns.length; i++) {
                    html += "<option value=" + towns[i].code + ">" + towns[i].name + "</option>";
                }
                $("#town").html(html);
            })
        }

        function save() {

            var id = $("#id").val();
            var name = $("#username").val();
            var province = $("#province").find("option:selected").text();
            var city = $("#city").find("option:selected").text();
            var town = $("#town").find("option:selected").text();
            var addr = $("#addr").val();
            var phone = $("#telphone").val();
            var isDef = 0;
            if ($("#isdef").attr("checked")) {
                isDef = 1;
            }

            var url = "/buyer/saveAddress.shtml";
            var params = {
                "id": id,
                "name": name,
                "city": province + city + town,
                "addr": addr,
                "phone": phone,
                "isDef": isDef
            };
            $.post(url, params, function (data) {
                alert(data.message);
                window.location.href = "/buyer/deliver_address.shtml";
            }, "json")
        }

        function modify(id, name, addr, phone, isDef) {

//            addr的id
            $("#id").val(id);
            $("#username").val(name);
            $("#addr").val(addr);
            $("#telphone").val(phone);

            if (isDef == 1) {
                $("#isDef").attr("checked", true);
                $("#isDef").attr("disabled", true);
            }
            if (isDef == 0) {
                $("#isDef").attr("checked", false);
                $("#isDef").attr("disabled", false);
            }
        }

    </script>
</head>
<body>
<div class="bar">
    <div class="bar_w">
        <p class="l">
		<span class="l">
			收藏本网站！北京<a href="#" title="更换">[更换]</a>
		</span>
        </p>
        <ul class="r uls">
            <li class="dev">您好,欢迎来到新巴巴运动网！</li>
            <li class="dev"><a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a></li>
            <li class="dev"><a href="javascript:void(0)" onclick="myOrder()" title="我的订单">我的订单</a></li>
            <li class="dev"><a href="#" title="在线客服">在线客服</a></li>
            <li class="dev after"><a href="#" title="English">English</a></li>
        </ul>
    </div>
</div>

<div class="w loc">
    <div class="h-title">
        <div class="h-logo"><a href="http://localhost:8080"><img src="/res/img/pic/logo-1.png"/></a></div>
        <div class="h-search">
            <input type="text"/>
            <div class="h-se-btn"><a href="#">搜索</a></div>
        </div>
    </div>
    <dl id="cart" class="cart r">
        <dt><a href="#" title="结算">结算</a>购物车:<b id="">5</b>件</dt>
        <dd class="hidden">
            <p class="alg_c hidden">购物车中还没有商品，赶紧选购吧！</p>
            <h3 title="最新加入的商品">最新加入的商品</h3>
            <ul class="uls">
                <li>
                    <a href="#"
                       title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
                        <img src="/res/img/pic/p50x50.jpg"
                             alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元"/></a>
                    <p class="dt"><a href="#"
                                     title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新
                        瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
                    <p class="dd">
                        <b><var>¥128</var><span>x1</span></b>
                        <a href="javascript:void(0);" title="删除" class="del">删除</a>
                    </p>
                </li>
                <li>
                    <a href="#"
                       title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
                        <img src="/res/img/pic/p50x50.jpg"
                             alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元"/></a>
                    <p class="dt"><a href="#"
                                     title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新
                        瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
                    <p class="dd">
                        <b><var>¥128</var><span>x1</span></b>
                        <a href="javascript:void(0);" title="删除" class="del">删除</a>
                    </p>
                </li>
                <li>
                    <a href="#"
                       title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
                        <img src="/res/img/pic/p50x50.jpg"
                             alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元"/></a>
                    <p class="dt"><a href="#"
                                     title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新
                        瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
                    <p class="dd">
                        <b><var>¥128</var><span>x1</span></b>
                        <a href="javascript:void(0);" title="删除" class="del">删除</a>
                    </p>
                </li>
                <li>
                    <a href="#"
                       title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
                        <img src="/res/img/pic/p50x50.jpg"
                             alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元"/></a>
                    <p class="dt"><a href="#"
                                     title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新
                        瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
                    <p class="dd">
                        <b><var>¥128</var><span>x1</span></b>
                        <a href="javascript:void(0);" title="删除" class="del">删除</a>
                    </p>
                </li>
                <li>
                    <a href="#"
                       title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
                        <img src="/res/img/pic/p50x50.jpg"
                             alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元"/></a>
                    <p class="dt"><a href="#"
                                     title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新
                        瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
                    <p class="dd">
                        <b><var>¥128</var><span>x1</span></b>
                        <a href="javascript:void(0);" title="删除" class="del">删除</a>
                    </p>
                </li>
            </ul>
            <div>
                <p>共<b>5</b>件商品&nbsp;&nbsp;&nbsp;&nbsp;共计<b class="f20">¥640.00</b></p>
                <a href="#" title="去购物车结算" class="inb btn120x30c">去购物车结算</a>
            </div>
        </dd>
    </dl>
</div>

<div class="w mt ofc">
    <div class="l wl">

        <h2 class="h2 h2_l"><em title="交易管理">交易管理</em><cite>&nbsp;</cite></h2>
        <div class="box bg_gray">
            <ul class="ul left_nav">
                <li><a href="../buyer/orders.jsp" title="我的订单">我的订单</a></li>
                <li><a href="../buyer/orders.jsp" title="退换货订单">退换货订单</a></li>
                <li><a href="../buyer/orders.jsp" title="我的收藏">我的收藏</a></li>
            </ul>
        </div>

        <h2 class="h2 h2_l mt"><em title="账户管理">账户管理</em><cite>&nbsp;</cite></h2>
        <div class="box bg_gray">
            <ul class="ul left_nav">
                <li><a href="/buyer/profile.shtml" title="个人资料">个人资料</a></li>
                <li><a href="/buyer/deliver_address.shtml" title="收货地址">收货地址</a></li>
                <li><a href="../buyer/change_password.jsp" title="修改密码">修改密码</a></li>
            </ul>
        </div>
    </div>
    <div class="r wr profile">

        <div class="confirm">
            <div class="tl"></div>
            <div class="tr"></div>
            <div class="ofc">

                <h2 class="h2 h2_r2"><em title="个人资料">收货地址</em></h2>

                <h3 class="h3_r">已存收货地址列表</h3>

                <table cellspacing="0" summary="" class="tab tab6">
                    <thead>
                    <tr>
                        <th>收货人</th>
                        <th>所在地区</th>
                        <th>街道地址</th>
                        <th>电话/手机</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${addrs }" var="addr">
                        <tr <c:if test="${addr.isDef == 1 }">class="here"</c:if>>
                            <td>${addr.name }</td>
                            <td>${addr.city }</td>
                            <td>${addr.addr }</td>
                            <td>${addr.phone }</td>
                            <td class="def blue">设为默认</td>
                            <td><a href="javascript:void(0);" title="修改"
                                   onclick="modify(${addr.id},'${addr.name }','${addr.addr }','${addr.phone }',${addr.isDef })"
                                   class="blue">[修改]</a><a href="javascript:void(0);" title="删除" onclick="del(this)"
                                                           class="blue">[删除]</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

                <h3 class="h3_r">新增/修改收货地址<span>手机、固定电话选填一项，其余均为必填</span></h3>

                <form id="jvForm" method="post">
                    <ul class="uls form">

                        <li id="errorName" class="errorTip" style="display:none">${error}</li>
                        <li><input type="hidden" id="id"/></li>
                        <li>
                            <label for="username"><samp>*</samp>收货人姓名：</label>
                            <span class="bg_text"><input type="text" id="username" name="username" vld="{required:true}"
                                                         maxLength="100"/></span>
                            <span class="pos"><span class="tip okTip">&nbsp;</span></span>
                        </li>
                        <li>
                            <label><samp>*</samp>地　　址：</label>
                            <span class="word">
						<select name="province" id="province" onchange="changeProvince(this.value)">
							<option value="" selected>省/直辖市</option>
						</select>
                                <select name="city" id="city" onchange="changeCity(this.value)">
							<option value="" selected>城市</option>
						</select>
                                <select name="town" id="town">
							<option value="" selected>县/区</option>
							<option value=""></option>
						</select>
                            </span>
                        </li>
                        <li>
                            <label for="addr"><samp>*</samp>街道地址：</label>
                            <span class="bg_text"><input type="text" id="addr" name="addr" maxLength="32"/></span>
                            <span class="pos"><span class="tip errorTip">用户名为4-20位字母、数字或中文组成，字母区分大小写。</span></span>
                        </li>
                        <li>
                            <label for="telphone"><samp>*</samp>联系电话：</label>
                            <span class="bg_text"><input type="text" id="telphone" name="telphone"
                                                         maxLength="32"/></span>
                            <span class="pos"><span class="tip warningTip">用户名为4-20位字母、数字或中文组成，字母区分大小写。</span></span>
                        </li>
                        <li>
                            <label for="isDef">&nbsp;</label>
                            <span><input type="checkbox" name="statusAddr" id="isDef"/>设为默认收货地址</span>
                        </li>
                        <li><label for="">&nbsp;</label><input onclick="save()" value="保存" class="hand btn66x23"/></li>
                    </ul>
                </form>
            </div>
        </div>

    </div>
</div>

<div class="mode">
    <div class="tl"></div>
    <div class="tr"></div>
    <ul class="uls">
        <li class="first">
            <span class="guide"></span>
            <dl>
                <dt title="购物指南">购物指南</dt>
                <dd><a href="#" title="购物流程">购物流程</a></dd>
                <dd><a href="#" title="购物流程">购物流程</a></dd>
                <dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
                <dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
            </dl>
        </li>
        <li>
            <span class="way"></span>
            <dl>
                <dt title="支付方式">支付方式</dt>
                <dd><a href="#" title="货到付款">货到付款</a></dd>
                <dd><a href="#" title="在线支付">在线支付</a></dd>
                <dd><a href="#" title="分期付款">分期付款</a></dd>
                <dd><a href="#" title="分期付款">分期付款</a></dd>
            </dl>
        </li>
        <li>
            <span class="help"></span>
            <dl>
                <dt title="配送方式">配送方式</dt>
                <dd><a href="#" title="上门自提">上门自提</a></dd>
                <dd><a href="#" title="上门自提">上门自提</a></dd>
                <dd><a href="#" title="上门自提">上门自提</a></dd>
                <dd><a href="#" title="上门自提">上门自提</a></dd>
            </dl>
        </li>
        <li>
            <span class="service"></span>
            <dl>
                <dt title="售后服务">售后服务</dt>
                <dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
                <dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
                <dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
                <dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
            </dl>
        </li>
        <li>
            <span class="problem"></span>
            <dl>
                <dt title="特色服务">特色服务</dt>
                <dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
                <dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
                <dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
                <dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
            </dl>
        </li>
    </ul>
</div>
</body>
</html>
