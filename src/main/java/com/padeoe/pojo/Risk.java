package com.padeoe.pojo;

/**
 * Created by zafara on 2016/11/14.
 */
public class Risk {

    private Integer id;

    private String riskContent = ""; //风险内容

    private Integer possibility = 2; //可能性 1 低，2普通，3高

    private Integer influenceLevel = 2; //影响程度 1 较轻，2普通，3严重

    private String threshold = ""; //阈值

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRiskContent() {
        return riskContent;
    }

    public void setRiskContent(String riskContent) {
        this.riskContent = riskContent;
    }

    public Integer getPossibility() {
        return possibility;
    }

    public void setPossibility(Integer possibility) {
        this.possibility = possibility;
    }

    public Integer getInfluenceLevel() {
        return influenceLevel;
    }

    public void setInfluenceLevel(Integer influenceLevel) {
        this.influenceLevel = influenceLevel;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

}
