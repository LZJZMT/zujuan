package com.zujuan.utils;

import com.zujuan.pojo.MailBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/9 16:47
 */
@Component
public class SendMail {

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleMail(MailBean mailBean) throws Exception {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "utf-8");
        //邮件发送人
        msgHelper.setFrom(username);
        //邮件接收人
        msgHelper.setTo(mailBean.getAddress());
        //邮件主题
        msgHelper.setSubject(mailBean.getTitle());
        //邮件内容
        msgHelper.setText(mailBean.getContent(),true);

        javaMailSender.send(msg);

    }


}
