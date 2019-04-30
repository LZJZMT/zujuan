package com.zujuan.pojo;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/4/27 14:13
 */
public class EchartLegend {
    private String orient;
    private String left;
    private List<String> data;

    public String getOrient() {
        return orient;
    }

    public void setOrient(String orient) {
        this.orient = orient;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
