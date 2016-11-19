package com.padeoe.pojo;

/**
 * Risk类定义了风险的基本模板，仅仅包含Risk的自身属性，除id外，Risk的区别由别的所有字段来唯一确定
 * @author padeoe
 * Date: 2016/11/16
 */
public class Risk {
    /**
     * 风险id，由数据库生成，是唯一的。两个{@link Risk}对象如果id不同，则其余字段一定至少有一个字段不同。
     * 就是说，除了id之外，别的字段不可能完全相同，这一点将由后台负责确保
     */
    private Integer id;

    /**
     * 风险简述,不同{@link Risk}对象的风险简述可能相同
     */
    private String riskBrief;

    /**
     * 风险详述,不同{@link Risk}对象的风险详述可能相同
     */
    private String riskDetail;

    /**
     * 风险可能性
     */
    private Integer possibility;

    /**
     * 风险影响程度
     */
    private Integer influence;

    /**
     * 风险阈值
     */
    private String threshold;

    /**
     * 计数，查询最大时用。
     */
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRiskBrief() {
        return riskBrief;
    }

    public void setRiskBrief(String riskBrief) {
        this.riskBrief = riskBrief;
    }

    public String getRiskDetail() {
        return riskDetail;
    }

    public void setRiskDetail(String riskDetail) {
        this.riskDetail = riskDetail;
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

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static Integer getLevel_Possiblility(String input){
        switch (input){
            case "高":
                return 3;
            case "普通":
                return 2;
            case "低":
                return 1;
            default:
                return null;
        }
    }

    public static Integer getLevel_Influence(String input){
        switch (input){
            case "致命":
                return 3;
            case "较大":
                return 2;
            case "一般":
                return 1;
            default:
                return null;
        }
    }



    public static String getLevel_Possiblility(Integer input){
        switch (input){
            case 3:
                return "高";
            case 2:
                return "普通";
            case 1:
                return "低";
            default:
                return null;
        }
    }

    public static String getLevel_Influence(Integer input){
        switch (input){
            case 3:
                return "致命";
            case 2:
                return "较大";
            case 1:
                return "一般";
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Risk{" +
                "id=" + id +
                ", riskBrief='" + riskBrief + '\'' +
                ", riskDetail='" + riskDetail + '\'' +
                ", possibility=" + possibility +
                ", influence=" + influence +
                ", threshold='" + threshold + '\'' +
                ", count=" + count +
                '}';
    }
}
