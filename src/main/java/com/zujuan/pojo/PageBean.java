package com.zujuan.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/10 16:06
 */
@Data
public class PageBean {
    private String code;
    private String msg;
    private String count;
    private List data;

    public PageBean() {
        code = "0";
        msg = "OK";
    }
}
