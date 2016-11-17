package com.padeoe.dao;

import com.padeoe.pojo.RiskOperation;

public interface IRiskOperationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RiskOperation record);

    int insertSelective(RiskOperation record);

    RiskOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RiskOperation record);

    int updateByPrimaryKey(RiskOperation record);
}