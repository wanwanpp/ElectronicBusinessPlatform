<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>babasport-list</title>
    <script type="text/javascript">
        function getTableForm() {
            return document.getElementById('tableForm');
        }
        function optDelete() {
            if (Pn.checkedCount('ids') <= 0) {
                alert("请至少选择一个!");
                return;
            }
            if (!confirm("确定删除吗?")) {
                return;
            }
            var f = getTableForm();
            f.action = "list.do";
            f.submit();
        }

        //上架
        function isShow(pageNo, name, brandId, isShow) {
            if (Pn.checkedCount('ids') <= 0) {
                alert("请至少选择一个!");
                return;
            }
            if (!confirm("确定上架吗?")) {
                return;
            }
//            var ids = [];
//            ids = $("input[name='ids']").val();
//            alert(ids);

            $("#jvForm").attr("action", "/product/show.do?pageNo=" + pageNo + "&name=" + name + "&brandId=" + brandId + "&isShow=" + isShow);
            $("#jvForm").submit();
        }
    </script>
</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置: 商品管理 - 列表</div>
    <form class="ropt">
        <input class="add" type="button" value="添加" onclick="javascript:window.location.href='toAdd.do'"/>
    </form>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form action="/product/list.do" method="post" style="padding-top:5px;">
        名称: <input type="text" value="${name}" name="name"/>
        <select name="brandId">
            <c:forEach items="${brands}" var="brand">
                <option value="${brand.id}"
                        <c:if test="${brand.id==brandId}">selected="selected"</c:if>>${brand.name}</option>
            </c:forEach>
        </select>
        <select name="isShow">
            <option value="1" <c:if test="${isShow==1}">selected="selected"</c:if>>上架</option>
            <option value="0" <c:if test="${isShow==0}">selected="selected"</c:if>>下架</option>
        </select>
        <input type="submit" class="query" value="查询"/>
    </form>
    <form method="post" id="jvForm">
        <table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
            <thead class="pn-lthead">
            <tr>
                <th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>图片</th>
                <th width="4%">新品</th>
                <th width="4%">热卖</th>
                <th width="4%">推荐</th>
                <th width="4%">上下架</th>
                <th width="12%">操作选项</th>
            </tr>
            </thead>
            <tbody class="pn-ltbody">
            <c:forEach items="${pagination.list}" var="entry">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td><input type="checkbox" name="ids" value="${entry.id}"/></td>
                    <td>${entry.id}---${entry.no}</td>
                    <td align="center">${entry.name}</td>
                    <td align="center"><img width="50" height="50" src="${entry.img.allUrl}"/></td>
                    <td align="center">
                        <c:if test="${entry.isNew==1}">是</c:if>
                        <c:if test="${entry.isNew==0}">不是</c:if>
                    </td>
                    <td align="center">
                        <c:if test="${entry.isHot==1}">是</c:if>
                        <c:if test="${entry.isHot==0}">不是</c:if>
                    </td>
                    <td align="center">
                        <c:if test="${entry.isCommend==1}">是</c:if>
                        <c:if test="${entry.isCommend==0}">不是</c:if>
                    </td>
                    <td align="center">
                        <c:if test="${entry.isShow==1}">上架</c:if>
                        <c:if test="${entry.isShow==0}">下架</c:if>
                    </td>
                    <td align="center">
                        <a href="/product/display/detail.shtml?id=${entry.id}" target="_blank" class="pn-opt">查看</a>
                        |
                        <a href="#" class="pn-opt">修改</a>
                        |
                        <a href="#" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
                        |
                        <a href="/sku/list.do?no=${entry.no}&id=${entry.id}" class="pn-opt">库存</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="page pb15">
	        <span class="r inb_a page_b">
		        <c:forEach items="${pagination.pageView}" var="page">
                    ${page }
                </c:forEach>
	        </span>
        </div>

        <div style="margin-top:15px;">
            <input class="del-button" type="button" value="删除" onclick="optDelete();"/>
            <input class="add" type="button" value="上架"
                   onclick="isShow('${pagination.pageNo}','${name }','${brandId }','${isShow }');"/>
            <input class="del-button" type="button" value="下架" onclick="optDelete();"/>
        </div>
    </form>
</div>
</body>
</html>