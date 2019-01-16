package com.zujuan.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/15 18:06
 */
public class BeanUtil {

    public static <T> T copy(Object poObj,final Class <T>voClass)
    {
        T voObj =null;
        try {
            voObj = voClass.newInstance();
            BeanUtils.copyProperties(poObj, voObj);
            return voObj;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> List<T> copyList(List <? extends Object> poList , final Class <T>voClass){

        List<T> voList=new ArrayList<T>();

        T voObj =null;
        for(Object poObj:poList){
            try {
                voObj = voClass.newInstance();
                BeanUtils.copyProperties(poObj, voObj);
                voList.add(voObj);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return voList;
    }
}