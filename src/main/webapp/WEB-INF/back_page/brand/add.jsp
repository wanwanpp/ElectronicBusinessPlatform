<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>babasport-add</title>
	<script type="text/javascript">
		//上传图片
		function uploadPic() {
			//定义参数
			var options = {
				url: "/upload/uploadPic.do",
				dataType: "json",
				type: "post",
				beforeSubmit : function(formData,jqForm,options){
					//判断是否为图片
					var f = jqForm[0];//将jqForm转成DOM对象
					var v = f.pic.value;//获取DOM对象中name为pic的值  pic为上传的图片文件的name
					//获取扩展名,并转成小写
					var ext = v.substring(v.length-3).toLowerCase();
					//比对扩展名 jpg gif bmp png
					if(ext != "jpg" && ext != "gif" && ext != "bmp" && ext != "png"){
						alert("只允许上传图片!");
						return false;
					}
					//校验提交的表单
					return true;
				},

				success: function (data) {
					//回调 二个路径
					//url
					//path
					$("#allImgUrl").attr("src", data.url);
					$("#path").val(data.path);
				}
			};

			//jquery.form使用方式
			$("#jvForm").ajaxSubmit(options);

		}

	</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='v_list.shtml';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="add.do" method="post" enctype="multipart/form-data">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
			<tr>
				<td width="20%" class="pn-flabel pn-flabel-h">
					<span class="pn-frequired">*</span>
					品牌名称:
				</td>
				<td width="80%" class="pn-fcontent">
					<input type="text" class="required" name="name" maxlength="100"/>
				</td>
			</tr>
			<tr>
				<td width="20%" class="pn-flabel pn-flabel-h">
					<span class="pn-frequired">*</span>
					上传商品图片(90x150尺寸):
				</td>
				<td width="80%" class="pn-fcontent">
					注:该尺寸图片必须为90x150。
				</td>
			</tr>
			<tr>
				<td width="20%" class="pn-flabel pn-flabel-h"></td>
				<td width="80%" class="pn-fcontent">
					<img width="100" height="100" id="allImgUrl"/>
					<input type="hidden" name="imgUrl" id="path"/>
					<input type="file" onchange="uploadPic()" name="pic"/>
				</td>
			</tr>
			<tr>
				<td width="20%" class="pn-flabel pn-flabel-h">
					品牌描述:
				</td>
				<td width="80%" class="pn-fcontent">
					<input type="text" class="required" name="description" maxlength="80" size="60"/>
				</td>
			</tr>
			<tr>
				<td width="20%" class="pn-flabel pn-flabel-h">
					排序:
				</td>
				<td width="80%" class="pn-fcontent">
					<input type="text" class="required" name="sort" maxlength="80"/>
				</td>
			</tr>
			<tr>
				<td width="20%" class="pn-flabel pn-flabel-h">
					是否可用:
				</td>
				<td width="80%" class="pn-fcontent">
					<input type="radio" name="isDisplay" value="1" checked="checked"/>可用
					<input type="radio" name="isDisplay" value="0"/>不可用
				</td>
			</tr>
			</tbody>
			<tbody>
			<tr>
				<td class="pn-fbutton" colspan="2">
					<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset"
																				   value="重置"/>
				</td>
			</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>