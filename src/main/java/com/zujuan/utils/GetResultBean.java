package com.zujuan.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/9 17:08
 */
public class GetResultBean {
    public static Map getResultMap(){
        HashMap map = new HashMap();
        map.put("code","0");
        map.put("msg","操作成功");
        return map;
    }

    public static Map getFailResultMap(){
        HashMap map = new HashMap();
        map.put("code","1");
        map.put("msg","操作失败");
        return map;
    }
}
