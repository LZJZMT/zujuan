package com.zujuan.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class Knowledge implements Serializable {
    private Long id;
    private String zsdname;
    private Long parentid;

    //一对多关系
    private Set<Examination> examinations;

    private static final long serialVersionUID = 1L;

    public Knowledge() {
    }
    public Knowledge(Long id) {
        this.id = id;
    }

    public Knowledge(Long id, String zsdname, Long parentid) {
        this.id = id;
        this.zsdname = zsdname;
        this.parentid = parentid;
    }


}