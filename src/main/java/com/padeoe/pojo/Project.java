package com.padeoe.pojo;

/**
 * Project 类定义了项目，包含项目名称和项目描述
 * @author padeoe
 * Date: 2016/11/16
 */
public class Project {
    /**
     * 项目名称，是唯一区分项目的属性
     */
    private String name;

    /**
     * 项目描述
     */
    private String descriptoin;

    /**
     * 创建项目
     * @param name 项目名称
     * @param descriptoin 项目描述
     */
    public Project(String name, String descriptoin) {
        this.name = name;
        this.descriptoin = descriptoin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptoin() {
        return descriptoin;
    }

    public void setDescriptoin(String descriptoin) {
        this.descriptoin = descriptoin;
    }
}
