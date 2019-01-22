package com.zujuan.pojo;

import com.deepoove.poi.data.DocxRenderData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/22 16:46
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperPoiData {
    private String xuenian;
    private String xueqi;
    private String courseCode;
    private String courseName;
    private String AorB;
    private String isOpen;
    private String major;
    private String time;
    private DocxRenderData examinationRenderData;
}
