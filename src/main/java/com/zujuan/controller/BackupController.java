package com.zujuan.controller;

import com.zujuan.pojo.PageBean;
import com.zujuan.utils.CommonUtils;
import com.zujuan.utils.GetResultBean;
import com.zujuan.vo.BackupFileVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/5/20 15:55
 */
@Controller
@RequestMapping("/backup")
public class BackupController {

    @Value("${upload.localDirectory}")
    private String localDirectory;

    @Value("${upload.staticMapping}")
    private String staticMapping;

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @ResponseBody
    @RequestMapping("/addBackup")
    public Map addBackup(){
        String fileName = "Database_backup_"+CommonUtils.getFileNameByNowDateTime();
        try {
            boolean zujuansys = CommonUtils.backup("127.0.0.1", username, password, localDirectory + "backup", fileName, "zujuansys");
            if (zujuansys){
                return GetResultBean.getResultMap();
            }else {
                return GetResultBean.getFailResultMap();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return GetResultBean.getFailResultMap();
        }

    }

    @ResponseBody
    @RequestMapping("/delBackup")
    public Map delBackup(String fileName){
        try {
            File file = new File(localDirectory + "backup//" + fileName);
            file.delete();
            return GetResultBean.getResultMap();
        } catch (Exception e) {
            e.printStackTrace();
            return GetResultBean.getFailResultMap();
        }

    }

    @ResponseBody
    @RequestMapping("/recover")
    public Map recover(String fileName){
        try {
            boolean zujuansys = CommonUtils.recover(localDirectory+"backup//"+fileName,"127.0.0.1","zujuansys",username,password);
            if (zujuansys){
                return GetResultBean.getResultMap();
            }else {
                return GetResultBean.getFailResultMap();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return GetResultBean.getFailResultMap();
        }

    }

    @ResponseBody
    @RequestMapping("/list")
    public PageBean list(Integer page, Integer limit){
        File fileDir = new File(localDirectory+"backup");
        if (!fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        ArrayList<BackupFileVO> fileVOS = new ArrayList<>();
        String[] filelist = fileDir.list();
        for (String fileName : filelist) {
            File file = new File(localDirectory + "backup//" + fileName);
            BasicFileAttributes bAttributes = null;
            try {
                bAttributes = Files.readAttributes(file.toPath(),
                        BasicFileAttributes.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileTime fileTime = bAttributes.lastModifiedTime();
            Date date = new Date(fileTime.toMillis());
            BackupFileVO backupFileVO = new BackupFileVO();
            backupFileVO.setFileName(fileName);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            backupFileVO.setCreateTime(simpleDateFormat.format(date));
            fileVOS.add(backupFileVO);
        }
        Collections.reverse(fileVOS);
        PageBean pageBean = new PageBean();
        pageBean.setCount(fileVOS.size()+"");
        int right = page*limit >= fileVOS.size()?fileVOS.size():page*limit;

        pageBean.setData(fileVOS.subList((page-1)*limit,right));
        return pageBean;
    }
}
