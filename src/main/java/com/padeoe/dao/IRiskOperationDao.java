package com.padeoe.dao;

import com.padeoe.pojo.Risk;
import com.padeoe.pojo.RiskOperation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IRiskOperationDao {
    List<RiskOperation> selectByCondition(RiskOperation query);

    List<RiskOperation> selectByConditionLatest(RiskOperation query);

    List<Risk> queryByState(Integer state);

    List<Risk> queryByStateLatest(int state);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskOperation record);

    int insertSelective(RiskOperation record);

    RiskOperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RiskOperation record);

    int updateByPrimaryKey(RiskOperation record);


}