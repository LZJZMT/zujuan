package com.zujuan.controller;

import com.zujuan.pojo.Examination;
import com.zujuan.service.ExamBasketService;
import com.zujuan.service.ExamService;
import com.zujuan.utils.ExportDoc;
import com.zujuan.utils.GetResultBean;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
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


    @ResponseBody
    @RequestMapping("/convertPaper")
    public Map converPaper() throws Exception {

        ExportDoc exportDoc = new ExportDoc("gb2312");
        exportDoc.set_NextPart("------=_NextPart_01D4B400.AC80D130");
        exportDoc.setPreFile("file:///C:/8589A2B1/");
        Template template = exportDoc.getTemplate("t1.mht","gb2312");

        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\generate.doc"), "gb2312"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("courseCode", "21312312");
        map.put("njzy", "17级软件工程");
        map.put("time", "120");
        LinkedList<String> imageBase64BlockList = new LinkedList<>();
        LinkedList<String> oFileList = new LinkedList<>();
        int index = 1;

        List<Examination> examinations = ebs.getMyExam();
        for (Examination examination : examinations) {
            String wordQuestion = exportDoc.handHtml2Word(examination.getQuestion(),imageBase64BlockList,oFileList);
            StringBuilder sb = new StringBuilder(wordQuestion);//构造一个StringBuilder对象
            sb.insert(3, index+++"、");//在指定的位置1，插入指定的字符串
            examination.setQuestion(sb.toString());
        }
        map.put("examList",examinations);
        map.put("base64List",imageBase64BlockList);
        map.put("oFileList",oFileList);
        template.process(map, writer);

        System.out.println(imageBase64BlockList);
        System.out.println(oFileList);
        writer.close();

        return GetResultBean.getResultMap();

    }

        /*List<Examination> examinations = ebs.getMyExam();
        List<ExaminationVO> examinationVOS = es.convert2VOlist(examinations);
        boolean isHasXz = false;
        boolean isHasTk = false;
        boolean isHasPd = false;
        boolean isHasWd = false;
        List xzList = new ArrayList();
        List tkList = new ArrayList();
        List pdList = new ArrayList();
        List wdList = new ArrayList();
        int xzIndex = 1;
        int tkIndex = 1;
        int pdIndex = 1;
        int wdIndex = 1;
        for (ExaminationVO examinationVO : examinationVOS) {
            if (examinationVO.getType().equals(1)){
                examinationVO.setIndex(xzIndex++);
                xzList.add(examinationVO);
                isHasXz = true;
            }
            if (examinationVO.getType().equals(2)){
                examinationVO.setIndex(tkIndex++);
                tkList.add(examinationVO);
                isHasTk = true;
            }
            if (examinationVO.getType().equals(3)){
                examinationVO.setIndex(pdIndex++);
                pdList.add(examinationVO);
                isHasPd = true;
            }
            if (examinationVO.getType().equals(4)){
                examinationVO.setIndex(wdIndex++);
                wdList.add(examinationVO);
                isHasWd = true;
            }
        }

        if (isHasXz){
            DocxRenderData xzRenderData = new DocxRenderData(new File(xzTemplateExamPath), xzList);
            paper.setXzRenderData(xzRenderData);
        }
        if (isHasTk){
            DocxRenderData tkRenderData = new DocxRenderData(new File(tkTemplateExamPath), tkList);
            paper.setTkRenderData(tkRenderData);
        }
        if (isHasPd){
            DocxRenderData pdRenderData = new DocxRenderData(new File(pdTemplateExamPath), pdList);
            paper.setPdRenderData(pdRenderData);
        }
        if (isHasWd){
            DocxRenderData wdRenderData = new DocxRenderData(new File(wdTemplateExamPath), wdList);
            paper.setWdRenderData(wdRenderData);
        }

        XWPFTemplate template = XWPFTemplate.compile(templatePath).render(paper);
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
    }*/
}
