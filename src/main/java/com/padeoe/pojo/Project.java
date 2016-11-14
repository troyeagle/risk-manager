package com.padeoe.pojo;

/**
 * Created by zafara on 2016/11/14.
 */
public class Project {
    private String name;

    private String descriptoin;

    private Risk[] risklists;

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getDescriptoin(){
        return descriptoin;
    }

    public void setDescriptoin(){
        this.descriptoin = descriptoin;
    }

}
