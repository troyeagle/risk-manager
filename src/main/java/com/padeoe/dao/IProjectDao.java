package com.padeoe.dao;

import com.padeoe.pojo.Project;
import org.springframework.stereotype.Component;

@Component
public interface IProjectDao {
    int deleteByPrimaryKey(String name);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}