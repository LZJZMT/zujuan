package com.zujuan.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/17 14:18
 */
@Data
@AllArgsConstructor
public class KnowledgeTreeVO {
    private Long value;
    private String title;
    private List<KnowledgeTreeVO> data;

}
