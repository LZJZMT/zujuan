package com.zujuan.controller;

import com.zujuan.utils.GetCurrentUser;
import com.zujuan.utils.GetResultBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/10 14:21
 */
@Controller
public class CommonController {

    @RequestMapping("/views/index")
    public String home(ModelMap modelMap){
        modelMap.addAttribute("username", GetCurrentUser.getCurrentUser().getUsername());
        return "index";
    }



    @Value("${upload.localDirectory}")
    private String localDirectory;

    @Value("${upload.staticMapping}")
    private String staticMapping;


    @ResponseBody
    @RequestMapping("/upload/file")
    public Map uploadFile(HttpServletRequest request){
        //多个文件同时上传
        String fileName = null;

        Map resultMap = GetResultBean.getResultMap();
        try {
            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
            BufferedOutputStream stream = null;
            fileName = null;
            for (MultipartFile f : files) {
                if (f.isEmpty()){
                    continue;
                }
                try {
                    byte[] b = f.getBytes();
                    long time = new Date().getTime();
                    String[] split = f.getOriginalFilename().split("\\.");
                    fileName = ""+time+new Random().nextInt(100000)+"."+split[split.length-1];
                    String path = localDirectory+fileName;
                    stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
                    stream.write(b);
                    stream.close();
                    HashMap<String, String> stringStringHashMap = new HashMap<>();
                    stringStringHashMap.put("src",staticMapping.replace("*", "")+fileName);
                    resultMap.put("data",stringStringHashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            resultMap = GetResultBean.getFailResultMap();
            e.printStackTrace();
        }
        return resultMap;
    }
}
