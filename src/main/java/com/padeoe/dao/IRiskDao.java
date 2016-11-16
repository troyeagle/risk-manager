package com.padeoe.dao;

import com.padeoe.pojo.Risk;

import java.util.List;

/**
 * com.padeoe.dao
 *
 * @author troy_diao on 2016/11/16
 */
public interface IRiskDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Risk record);

    int insertSelective(Risk record);

    Risk selectByPrimaryKey(Integer id);

    List<Risk> selectByCondition(Risk query);

    int updateByPrimaryKeySelective(Risk record);

    int updateByPrimaryKey(Risk record);

}
