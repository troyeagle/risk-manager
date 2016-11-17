package com.padeoe.dao;

import com.padeoe.pojo.Project;

public interface IProjectDao {
    int deleteByPrimaryKey(String name);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}