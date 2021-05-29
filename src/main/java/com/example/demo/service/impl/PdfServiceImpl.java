package com.example.demo.service.impl;

import com.example.demo.service.PdfService;
import com.example.demo.vo.EvaluationVO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdfServiceImpl implements PdfService {


    @Override
    public EvaluationVO getContent() {
        // 从数据库中获取数据， 出于演示目的， 这里数据不从数据库获取， 而是直接写死
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
        return evaluationVO;
    }

}
