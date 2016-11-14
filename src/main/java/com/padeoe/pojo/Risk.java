package com.padeoe.pojo;

/**
 * Created by zafara on 2016/11/14.
 */
public class Risk {

    private  String risk_content = ""; //风险内容

    private  String possibility = ""; //可能性

    private  String influce_level = ""; //影响程度

    private  String threshold = ""; //阈值

    private User Commiter; //提交者

    private User follower[]; //跟踪者

    public String getRisk_content() {
        return risk_content;
    }

    public void setRisk_content(String risk_content) {
        this.risk_content = risk_content;
    }
}
