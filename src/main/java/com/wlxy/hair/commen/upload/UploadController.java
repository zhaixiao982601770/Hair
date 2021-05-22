package com.wlxy.hair.commen.upload;


import com.wlxy.hair.commen.MyRsp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


//图片文件上传
@Api(value = "图片模块接口",description = "这是一个关于图片的上传的接口文档")
@Controller
@RequestMapping("upload")
@CrossOrigin        //处理跨越请求
public class UploadController {
    @Value("D:\\img\\")
    private  String imgPath;



    @PostMapping("/addImage")
    @ResponseBody
    public Object addImage(@RequestParam(name = "image_data", required = false) MultipartFile file) {

        String fileName = file.getOriginalFilename();
        //文件上传
        if (!file.isEmpty()) {
            try {
                //图片命名
//                String newCompanyImageName = "newPIC";
                String newCompanyImagepath = imgPath+file.getOriginalFilename();
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();//刷新
                out.close();//关闭
            } catch (IOException e) {
                e.printStackTrace();
                return MyRsp.error().msg("上传失败");
            }
        }
        return MyRsp.success(fileName).msg("上传成功");
    }



}
