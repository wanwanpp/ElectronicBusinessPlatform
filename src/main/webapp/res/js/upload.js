/**
 * Created by wang0 on 2017/1/5 0005.
 */
function uploadPic() {
    //定义参数
    var options = {
        url: "/upload/uploadPic.do",
        dataType: "json",
        type: "post",
        beforeSubmit: function (formData, jqForm, options) {
            //判断是否为图片
            var f = jqForm[0];//将jqForm转成DOM对象
            var v = f.pic.value;//获取DOM对象中name为pic的值  pic为上传的图片文件的name
            //获取扩展名,并转成小写
            var ext = v.substring(v.length - 3).toLowerCase();
            //比对扩展名 jpg gif bmp png
            if (ext != "jpg" && ext != "gif" && ext != "bmp" && ext != "png") {
                alert("只允许上传图片!");
                return false;
            }
            //校验提交的表单
            return true;
        },

        success: function (data) {

            $("#allImgUrl").attr("src", data.url);
            $("#path").val(data.path);
        }
    };

    //jquery.form使用方式
    $("#jvForm").ajaxSubmit(options);

}
