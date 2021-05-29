package com.example.demo.vo;


import java.util.List;
import java.util.Map;

/**
 * 生成评估报告pdf文件值对象
 */
public class EvaluationVO {

    /**
     * 生成时间字符串（yyyy.MM.dd）
     */
    private String createDate;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目区域
     */
    private String area;

    /**
     * 地形地貌
     */
    private String topography;

    /**
     * 系统规模
     */
    private String scale;

    /**
     * 系统整体配置方案(系统组件，数量，数据来源标志位 )
     */
    private List<Map> systemConfig;

    /**
     * 项目运行参数配置
     */
    private Map<String,String> projectRunConfig;

    /**
     * 设备信息
     */
    private  List<Map<String,Object>> equipment;

    /**
     * 评估指标
     */
    private Map<String,Object> evaluationIndex;

    private Map<String,Object> map;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTopography() {
        return topography;
    }

    public void setTopography(String topography) {
        this.topography = topography;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public List<Map> getSystemConfig() {
        return systemConfig;
    }

    public void setSystemConfig(List<Map> systemConfig) {
        this.systemConfig = systemConfig;
    }

    public Map<String,String> getProjectRunConfig() {
        return projectRunConfig;
    }

    public void setProjectRunConfig(Map<String,String> projectRunConfig) {
        this.projectRunConfig = projectRunConfig;
    }

    public List<Map<String,Object>> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Map<String,Object>> equipment) {
        this.equipment = equipment;
    }

    public Map<String,Object> getEvaluationIndex() {
        return evaluationIndex;
    }

    public void setEvaluationIndex(Map<String,Object> evaluationIndex) {
        this.evaluationIndex = evaluationIndex;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
