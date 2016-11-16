package com.padeoe.pojo;

/**
 * Project 类定义了项目，包含项目名称和项目描述
 * @author padeoe
 * Date: 2016/11/16
 */
public class Project {

    private Integer id;
    /**
     * 项目名称，是唯一区分项目的属性
     */
    private String name;

    /**
     * 项目描述
     */
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
