package com.example.demo.vo;



import com.example.demo.component.PDFHeaderFooter;
import com.example.demo.component.PDFKit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fgm on 2017/4/17.
 * 360报告
 */
public class ReportKit360 {

    /*public static List<XYLine> getTemperatureLineList() {
        List<XYLine> list = Lists.newArrayList();
        for (int i = 1; i <= 7; i++) {
            XYLine line = new XYLine();
            float random = Math.round(Math.random() * 10);
            line.setXValue("星期" + i);
            line.setYValue(20 + random);
            line.setGroupName("下周");
            list.add(line);
        }
        for (int i = 1; i <= 7; i++) {
            XYLine line = new XYLine();
            float random = Math.round(Math.random() * 10);
            line.setXValue("星期" + i);
            line.setYValue(20 + random);
            line.setGroupName("这周");
            list.add(line);
        }
        return list;
    }*/

    public static String createPDF(String templatePath, Object data, String fileName) {
        //pdf保存路径
        try {
            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter = new PDFHeaderFooter();
            PDFKit kit = new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            //设置输出路径
            kit.setSaveFilePath("D:/ruoyi/uploadPath/pdf/123.pdf");
            // String saveFilePath = kit.exportToFile(fileName, data);
            String saveFilePath = "";
            return saveFilePath;
        } catch (Exception e) {
//            log.error("PDF生成失败{}", ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        ReportKit360 kit = new ReportKit360();
        EvaluationVO evaluationVO = new EvaluationVO();

        // 项目概况
        evaluationVO.setProjectName("项目名称");
        evaluationVO.setArea("北京");
        evaluationVO.setTopography("平原");
        evaluationVO.setScale("产业园区级");

        // 系统设计
        // 系统整体配置
        List<Map> systemConfig = new ArrayList<Map>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("device", "风机1");
        map.put("num", 1);
        map.put("flag", "默认");
        systemConfig.add(map);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("device", "光伏1");
        map1.put("num", 2);
        map1.put("flag", "预测");
        systemConfig.add(map1);
        evaluationVO.setSystemConfig(systemConfig);

        // 项目运行参数
        Map<String, String> runConfig = new HashMap<String, String>(10);
        runConfig.put("evaluationMode", "运行模式");
        runConfig.put("projectCycle", "项目周期");
        runConfig.put("electricityPriceSubsidy", "电价补贴（元/kWh）");
        runConfig.put("vatRate", "增值税税率");
        runConfig.put("capitalRatio", "资本金比例");
        runConfig.put("longLendingRates", "长期贷款利率");
        runConfig.put("shortLendingRates", "短期贷款利率");
        runConfig.put("preRepaymentYear", "预定还款期");
        runConfig.put("ownWorkingCapital", "自有流动资金比例");
        runConfig.put("corporateIncomeTax", "企业所得税率");
        evaluationVO.setProjectRunConfig(runConfig);

        // 设备具体参数
        List<Map<String,Object>> equipment = new ArrayList();
        // 单个设备
        Map<String, Object> equipmentMap1 = new HashMap<String, Object>();
        equipmentMap1.put("device","风机1");
        // 设备参数
        List<Map> params = new ArrayList();
        for(int i=0;i<10;i++){
            Map<String,String> paramMap = new HashMap<String, String>();
            paramMap.put("key","额定功率（kW）");
            paramMap.put("value","22");
            params.add(paramMap);
        }
        equipmentMap1.put("params",params);
        // 系统运行：为运行评估界面展示的表格内容
        // 说明：与系统组态模型对应
        List<Object> systemRunParam = new ArrayList<Object>();
        Map<String,Object> sysRunMap0 = new HashMap<String, Object>();
        sysRunMap0.put("key","总装机容量（kW）");
        sysRunMap0.put("value","123");
        systemRunParam.add(sysRunMap0);
        Map<String,Object> sysRunMap1 = new HashMap<String, Object>();
        sysRunMap1.put("key","项目周期总发电量（kW‧h）");
        sysRunMap1.put("value","435653654");
        systemRunParam.add(sysRunMap1);
        Map<String,Object> sysRunMap2 = new HashMap<String, Object>();
        sysRunMap2.put("key","等效年利用小时数（h）");
        sysRunMap2.put("value","44758");
        systemRunParam.add(sysRunMap2);
        Map<String,Object> sysRunMap3 = new HashMap<String, Object>();
        sysRunMap3.put("key","项目周期总成本（万元）");
        sysRunMap3.put("value","500");
        systemRunParam.add(sysRunMap3);
        equipmentMap1.put("systemRunParam", systemRunParam);

        equipment.add(equipmentMap1);
        // 添加一个设备相关数据
        evaluationVO.setEquipment(equipment);

        // 评估指标
        Map<String, Object> evaluationIndex = new HashMap<String, Object>();
        // 经济性
        evaluationIndex.put("economy1","500");
        evaluationIndex.put("economy2","10");
        evaluationIndex.put("economy3","76");
        evaluationVO.setEvaluationIndex(evaluationIndex);
//        // 生成时间
        evaluationVO.setCreateDate("2021/5/28");
//        String templatePath = "/Users/fgm/workspaces/fix/pdf-kit/src/test/resources/templates";
        String templatePath = "E:\\IDEA\\workSpace\\demo\\src\\main\\resources\\templates";
//        String path = kit.createPDF(templatePath, evaluationVO, "hello.pdf");
        String path = kit.createPDF(templatePath, evaluationVO, "hello.pdf");
        System.out.println(path);
    }


    //初始化页面数据
//    public static Map initData(){
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("nowDate","2021/5/27");
//
//        return map;
//    }

//    public static void main(String[] args) {
//        ReportKit360 kit = new ReportKit360();
//        Map map = initData();
//        String templatePath = "/Users/fgm/workspaces/fix/pdf-kit/src/test/resources/templates";
//        String path = kit.createPDF(templatePath, map, "demo.pdf");
//        System.out.println(path);
//    }


/*    public static void main(String[] args) {

        Map<String, Double> map = new HashMap();

        map.put("abc", 2.0d);
        if (map.get("bhj") == null) {
            System.out.println("is null");
        }

        if (map.get("abc") != null) {
            System.out.println("abc:" + map.get("abc"));
        }
    }*/

//    public static void main(String[] args) {
//        SimpleDateFormat dbsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
//        if(new BigDecimal("0").compareTo(new BigDecimal("0")) == 0){
//            System.out.println(dbsdf.format(new Date()));
//        }
//
//    }
}
