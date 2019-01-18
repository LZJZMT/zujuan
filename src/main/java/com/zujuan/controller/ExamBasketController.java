package com.zujuan.controller;

import com.zujuan.pojo.ExamBasket;
import com.zujuan.pojo.ExamBasketExample;
import com.zujuan.pojo.User;
import com.zujuan.service.ExamBasketService;
import com.zujuan.utils.GetCurrentUser;
import com.zujuan.utils.GetResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/18 15:32
 */
@RestController
@RequestMapping("/examBasket")
public class ExamBasketController {

    @Autowired
    private ExamBasketService ebs;

    @RequestMapping("/addExamToBasket")
    public Map addExamToBasket(ExamBasket examBasket){
        Map resultMap = GetResultBean.getResultMap();

        try {
            //获取当前用户 以便插入用户id 和 试题id
            User user = GetCurrentUser.getCurrentUser();

            ExamBasketExample example = new ExamBasketExample();
            example.createCriteria().andUserIdEqualTo(user.getId())
            .andExamIdEqualTo(examBasket.getExamId());
            List list = ebs.selectByExample(example);
            if(list != null && list.size() > 0){
                throw new Exception("已加入试题库，请不要重复加入");
            }
            //用户未登录直接return
            if (user == null){
                throw new Exception("请先登陆");
            }
            examBasket.setUserId(user.getId());
            ebs.add(examBasket);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap = GetResultBean.getFailResultMap();
        }
        return resultMap;

    }

    //根据登陆用户返回试题篮 试题个数
    @RequestMapping("countExamOfBasketByUserId")
    public Long countExamOfBasketByUserId(){
        long l = 0l;
        try {
            User user = GetCurrentUser.getCurrentUser();
            ExamBasketExample examBasketExample = new ExamBasketExample();
            examBasketExample.createCriteria().andUserIdEqualTo(user.getId());
            l = ebs.countByExample(examBasketExample);
        } catch (Exception e) {
            e.printStackTrace();
            return 0l;
        }
        return l;
    }

    @ResponseBody
    @RequestMapping("delById")
    public Map delById(Long eid){
        Map map = GetResultBean.getResultMap();
        try {
            User user = GetCurrentUser.getCurrentUser();
            ExamBasketExample examBasketExample = new ExamBasketExample();
            examBasketExample.createCriteria().andUserIdEqualTo(user.getId())
                    .andExamIdEqualTo(eid);
            ebs.delByExample(examBasketExample);
        } catch (Exception e) {
            e.printStackTrace();
            map = GetResultBean.getFailResultMap();
        }
        return  map;
    }
}
