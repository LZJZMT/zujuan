package com.zujuan.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExamPaper implements Serializable {
    private Long pid;

    private String name;

    private String courseCode;

    private String njzy;

    private Integer totalScore;

    private Integer time;

    private Date createTime;

    private Date examTime;

    private Date reviseTime;

    private Double degree;

    private String fileUrl;

    private Integer xzScore;

    private Integer tkScore;

    private Integer pdScore;

    private Integer wdScore;

    private Long authorId;

    private static final long serialVersionUID = 1L;

}