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

    public String getPossibility() {
        return possibility;
    }

    public void setPossibility(String possibility) {
        this.possibility = possibility;
    }

    public String getInfluce_level() {
        return influce_level;
    }

    public void setInfluce_level(String influce_level) {
        this.influce_level = influce_level;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public User getCommiter() {
        return Commiter;
    }

    public void setCommiter(User commiter) {
        Commiter = commiter;
    }

    public User[] getFollower() {
        return follower;
    }

    public void setFollower(User[] follower) {
        this.follower = follower;
    }
}
