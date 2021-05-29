package com.example.demo.controller;

import com.example.demo.component.PDFHeaderFooter;
import com.example.demo.component.PDFKit;
import com.example.demo.service.PdfService;
import com.example.demo.vo.EvaluationVO;
import com.example.demo.vo.ReportKit360;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author song
 * @date 2021年05月28日 20:03
 */

@Controller
@RequestMapping("/")
public class pdfController {

    @Autowired
    private PdfService pdfService;

    @RequestMapping("export")
    public void exportPdf(HttpServletResponse response) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream out = null;
        try {
            //linux地址
            //String templatePath = "/Users/fgm/workspaces/fix/pdf-kit/src/test/resources/templates";
            // 设置响应消息头，告诉浏览器当前响应是一个下载文件
            response.setContentType("application/x-msdownload");
            // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
            String fileName = URLEncoder.encode("报表.pdf", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            //模板
            String templatePath = "demo.ftl";
            //从数据库取数据组装map
            EvaluationVO evaluationVO = pdfService.getContent();

            out = response.getOutputStream();

            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter = new PDFHeaderFooter();
            PDFKit kit = new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            //设置输出路径导出pdf
            kit.exportToFile(templatePath, evaluationVO, out);
            baos.writeTo(out);
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                baos.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
