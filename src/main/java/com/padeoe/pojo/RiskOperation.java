package com.padeoe.pojo;

import java.util.Date;
/**
 * RiskOperation定义了对一条风险的任何操作，譬如风险的识别，添加，转化成问题了，被委托给某人追踪，记录了这些操作发生的时间，操作人
 * @author padeoe
 * Date: 2016/11/16
 */
public class RiskOperation {

    private Integer id;

    private Integer riskId;

    private String creatorName;

    private String tracerName;

    private String projectName;

    private Integer state;

    private Date updateTime;

    private String description;

    private Integer possibility;

    private Integer influence;
    /**
     * 非数据库项，查询update time的条件
     */
    private Date startTime;

    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRiskId() {
        return riskId;
    }

    public void setRiskId(Integer riskId) {
        this.riskId = riskId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public String getTracerName() {
        return tracerName;
    }

    public void setTracerName(String tracerName) {
        this.tracerName = tracerName == null ? null : tracerName.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getPossibility() {
        return possibility;
    }

    public void setPossibility(Integer possibility) {
        this.possibility = possibility;
    }

    public Integer getInfluence() {
        return influence;
    }

    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
