package com.wq.core.controller.back;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.wq.common.util.ResponseUtils;
import com.wq.common.web.Constants;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by 王萍 on 2016/12/30 0030.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/uploadPic.do")
    public void uploadBrandPic(HttpServletResponse response, @RequestParam(required = false) MultipartFile pic) {
        //图片名称生成策略---采用时间格式(精确到毫秒)并追加随机3位(10以内)数字
        //精确到毫秒
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String picName = df.format(new Date());
        //随机再生成3位 10以内的数
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            picName += r.nextInt(10);
        }

//        拓展名
        String originalFilename = pic.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);

//        相对路径
        String path = "upload/" + picName + "." + extension;
        String url = Constants.IMAGE_URL + path;

//        使用jersey客户端
        Client client = new Client();
        WebResource resource = client.resource(url);

        try {
            resource.put(String.class, pic.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jo = new JSONObject();
        jo.put("path",path);
        jo.put("url",url);
        ResponseUtils.renderJson(response,jo.toString());

    }
}
