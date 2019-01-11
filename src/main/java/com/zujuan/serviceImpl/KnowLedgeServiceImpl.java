package com.zujuan.serviceImpl;

import com.zujuan.mapper.KnowledgeMapper;
import com.zujuan.pojo.Knowledge;
import com.zujuan.pojo.KnowledgeExample;
import com.zujuan.pojo.PageBean;
import com.zujuan.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/10 15:41
 */
@Service
public class KnowLedgeServiceImpl implements KnowledgeService {
    @Autowired
    private KnowledgeMapper km;

    @Override
    public PageBean list(Knowledge knowledge, Integer page, Integer limit) {
        PageBean pageBean = new PageBean();
        if (knowledge == null) {
            pageBean.setData(km.list((page - 1) * limit, limit));
            long l = km.countByExample(new KnowledgeExample());
            pageBean.setCount(String.valueOf(l));
        }
        return pageBean;
    }

    @Override
    public void add(Knowledge knowledge) {
        km.insert(knowledge);
    }

    //查询是否存在相同得知识点名字
    @Override
    public boolean isCunzai(String zsdname) {
        KnowledgeExample knowledgeExample = new KnowledgeExample();
        knowledgeExample.createCriteria().andZsdnameEqualTo(zsdname);
        List<Knowledge> list = km.selectByExample(knowledgeExample);
        if (list == null || list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void del(Long id) {
        km.deleteByPrimaryKey(id);
    }

    @Override
    public List<Knowledge> listParent() {
        return km.getParentIdisNull();
    }

    @Override
    public void updateByExample(Knowledge knowledge, KnowledgeExample example) {
        km.updateByExampleSelective(knowledge, example);
    }

    @Override
    public List selectByExample(KnowledgeExample example) {
        return km.selectByExample(example);
    }

    @Override
    public long countByExample(KnowledgeExample example) {
        return km.countByExample(example);
    }
}
