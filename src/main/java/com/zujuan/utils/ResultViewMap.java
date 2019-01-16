package com.zujuan.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/16 11:42
 */
public class ResultViewMap {
    public static Map getTypeViewMap(){
        HashMap hashMap = new HashMap();
        hashMap.put(1,"选择题");
        hashMap.put(2,"填空题");
        hashMap.put(3,"判断题");
        hashMap.put(4,"问答题");
        return hashMap;
    }

    public static Map getDegreeViewMap(){
        HashMap hashMap = new HashMap();
        hashMap.put(1d,"简单");
        hashMap.put(2d,"一般");
        hashMap.put(3d,"较难");
        hashMap.put(4d,"困难");
        return hashMap;
    }
}
