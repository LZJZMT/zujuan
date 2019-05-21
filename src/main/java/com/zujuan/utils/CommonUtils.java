package com.zujuan.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/5/20 16:01
 */
public class CommonUtils {

    public static String getFileNameByNowDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date nowTime = new Date();
        return sdf.format(nowTime);
    }

    public static boolean backup(String hostIP, String userName, String password, String savePath, String fileName,
                                 String databaseName) throws Exception {
        fileName += ".sql";
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }

        //拼接命令行的命令
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump").append(" --opt").append(" -h").append(hostIP);
        stringBuilder.append(" --user=").append(userName).append(" --password=").append(password)
                .append(" --lock-all-tables=true");
        stringBuilder.append(" --result-file=").append(savePath + fileName).append(" --default-character-set=utf8 ")
                .append(databaseName);
        //调用外部执行exe文件的javaAPI
        Process process = Runtime.getRuntime().exec(stringBuilder.toString());
        if (process.waitFor() == 0) {// 0 表示线程正常终止。
            return true;
        }
        return false;
    }
    /**
     * @param filepath 数据库备份的脚本路径
     * @param ip IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public static boolean recover(String filepath,String ip,String database, String userName,String password) {


        //String stmt1 = "mysqladmin -h "+ip+" -u "+userName+" -p"+password+" create "+database;

        String stmt2 = "mysql -h "+ip+" -u"+userName+" -p"+password+" "+database+" < " + filepath;


        String[] cmd = { "cmd", "/c", stmt2 };

        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("数据已从 " + filepath + " 导入到数据库中");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
