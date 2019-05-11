package com.zujuan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ExamPaper implements Serializable {
    private Long pid;

    private String name;

    private String courseCode;

    private String njzy;

    private Integer totalScore;

    private Integer time;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date createTime;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date examTime;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date reviseTime;

    private Double degree;

    private String fileUrl;

    private Integer xzScore;

    private Integer tkScore;

    private Integer pdScore;

    private Integer wdScore;

    private Long authorId;

    private static final long serialVersionUID = 1L;
    public static void main(String[] args) throws ParseException {
           String s = "2019-04-10 00:00:00";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sf.format(new Date());
        Date parse = sf.parse(s);
    }

}