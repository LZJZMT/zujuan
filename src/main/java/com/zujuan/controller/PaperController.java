package com.zujuan.controller;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import com.zujuan.pojo.Examination;
import com.zujuan.pojo.PaperPoiData;
import com.zujuan.service.ExamBasketService;
import com.zujuan.service.ExamService;
import com.zujuan.vo.ExaminationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/1/22 15:42
 */

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Value("${upload.localDirectory}")
    private String localDirectory;

    @Autowired
    private ExamBasketService ebs;

    @Autowired
    private ExamService es;

    @RequestMapping("/convertPaper")
    public Map converPaper(){
        String templatePath = this.getClass().getResource("/poi_template/template.docx").getPath();
        String templateExamPath = this.getClass().getResource("/poi_template/template_exam.docx").getPath();

        PaperPoiData paperPoiData = new PaperPoiData();
        paperPoiData.setXuenian("2018-2019");
        paperPoiData.setXueqi("1");
        paperPoiData.setAorB("A");
        paperPoiData.setCourseCode("182352");
        paperPoiData.setCourseName("离散数学");
        paperPoiData.setIsOpen("开");
        paperPoiData.setMajor("16级软件工程");
        paperPoiData.setTime("120");

        List<Examination> examinations = ebs.getMyExam();
        List<ExaminationVO> examinationVOS = es.convert2VOlist(examinations);

        DocxRenderData examinationRenderData = new DocxRenderData(new File(templateExamPath), examinationVOS);
        paperPoiData.setExaminationRenderData(examinationRenderData);


        XWPFTemplate template = XWPFTemplate.compile(templatePath).render(paperPoiData);
        try {
            FileOutputStream out = new FileOutputStream(localDirectory+"paper/out_template.docx");

            template.write(out);
            out.flush();
            out.close();
            template.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
