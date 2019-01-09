package com.zujuan.pojo;

import lombok.Data;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 019/1/9 16:42
 */
@Data
public class MailBean {

    private String address; //邮件接收人
    private String title;   //主题
    private String content; //内容
}
