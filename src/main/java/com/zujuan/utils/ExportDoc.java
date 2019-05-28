package com.zujuan.utils;

import com.zujuan.ZujuanApplication;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;


@Data
public class ExportDoc {
    private Configuration configuration;
    private String encoding;
    private String _NextPart;//------=_NextPart_01D4B408.68160A80
    private String preFile;//  file:///C:/2673C891/

    public ExportDoc(String encoding) {
        this.encoding = encoding;
        configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding(encoding);
        configuration.setClassForTemplateLoading(ZujuanApplication.class, "template");

    }

    public Template getTemplate(String name,String encoding) throws Exception {
        return configuration.getTemplate(name,encoding);
    }

    public String getImageStr(String image) throws IOException {
        InputStream is = new FileInputStream(image);
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] data = new byte[is.available()];
        is.read(data); is.close();
        return encoder.encode(data);
    }


    public String  handHtml2Word(String question, List<String> imageBase64BlockList, List<String> oFileList) throws IOException {
        Document doc = Jsoup.parse(wrappHtml(question));
        Elements imags = doc.getElementsByTag("img");
        if (imags == null || imags.size() == 0) {
            return question;
        }
        // 转换成word mht 能识别图片标签内容，去替换html中的图片标签
        for (Element item : imags) {
            // 把文件取出来
            String src = item.attr("src");
            String srcRealPath = "E:"+src;

            File imageFile = new File(srcRealPath);
            String imageFielShortName = imageFile.getName();
            String fileTypeName = src.split("\\.")[1];

            Path path = Paths.get(srcRealPath);
            String fileType = Files.probeContentType(path);


            String fileNameByNowDateTime = CommonUtils.getFileNameByNowDateTime()+"_"+ (int)((Math.random()*9+1)*1000000);
            String docFileName = "image" + fileNameByNowDateTime + "."
                    + fileTypeName;


            BufferedImage bi = ImageIO.read(imageFile);// 通过ImageIO读取输入流来获取一个BufferedImage对象
            double height = bi.getHeight()/1.6;//获取高度
            double width = bi.getWidth()/1.6;//获取宽度

            // 得到文件的word mht的body块
            String handledDocBodyBlock = toDocBodyBlock(height, width,docFileName);

            item.after(handledDocBodyBlock);
            item.remove();
            // 去替换原生的html中的imag

            String base64Content = getImageStr(srcRealPath);

            String imageBase64Block = generateImageBase64Block(docFileName, fileType, base64Content);

            imageBase64BlockList.add(imageBase64Block);

            String oFile = "<o:File HRef=3D\"" + docFileName + "\"/>";
            oFileList.add(oFile);

        }
        //doc.getElementsByTag("body").append("<br>");
        String body = doc.getElementsByTag("body").html();
        return body;
    }


    public String generateImageBase64Block(String fileNewName,
                                                  String fileTypeName,String base64Content){

        StringBuilder sb=new StringBuilder();
        sb.append("\n");
        sb.append("\n");
        sb.append(_NextPart);
        sb.append("\n");
        sb.append("Content-Location: "+preFile+fileNewName);
        sb.append("\n");
        sb.append("Content-Transfer-Encoding: base64");
        sb.append("\n");
        sb.append("Content-Type: " + fileTypeName);
        sb.append("\n");
        sb.append("\n");
        sb.append(base64Content);

        return sb.toString();
    }

    private static String toDocBodyBlock(double imageHeight ,double imageWidth, String srcLocationShortName ){
        StringBuilder sb1=new StringBuilder();
        sb1.append(" <!--[if gte vml 1]>");
        sb1.append("<v:shape id=3D\"" + (int)((Math.random()*9+1)*100000)+"\"");
        sb1.append("\n");
        sb1.append(" o:spid=3D\""+ (int)((Math.random()*9+1)*100000) +"\"" );
        sb1.append(" type=3D\""+  (int)((Math.random()*9+1)*100000) +"\"");
        sb1.append("\n");
        sb1.append( " style=3D'width:"+new DecimalFormat("#.00").format(imageWidth)+"pt;height:"+new DecimalFormat("#.00").format(imageHeight)+"pt;'");
        sb1.append(">");
        sb1.append("\n");
        sb1.append(" <v:imagedata src=3D\"" + srcLocationShortName +"\""  );
        sb1.append("\n");
        sb1.append(" o:title=3D\"\"");
        sb1.append("/>");
        sb1.append("</v:shape>");
        sb1.append("<![endif]-->");
        return sb1.toString();
    }

    private String wrappHtml(String html){
        // 因为传递过来都是不完整的doc
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(html);
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    /*public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div>");

        sb.append("<img   src='\\image\\15482455024575958.png'/>");
        sb.append("<img   src='\\image\\154824563938793170.png'/>");
        sb.append("<span>中国梦，幸福梦！</span>");
        sb.append("</div>");

        String s = null;
        try {
            ExportDoc exportDoc = new ExportDoc("UTF-8");
            exportDoc.set_NextPart("------=_NextPart_01D4B408.68160A80");
            exportDoc.setPreFile("file:///C:/2673C891/");
            s = exportDoc.handHtml2Word(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }*/
}
