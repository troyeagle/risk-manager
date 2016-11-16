package com.padeoe.service.impl;

import com.padeoe.dao.IRiskDao;
import com.padeoe.pojo.Risk;
import com.padeoe.service.IRiskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zafara on 2016/11/14.
 */
@Service("riskService")
public class RiskServiceImpl implements IRiskService{
    @Resource
    public IRiskDao riskDao;

    private static AtomicInteger id = new AtomicInteger();
    private static Map<Integer, Risk> riskMap = new HashMap<>();
    @Override
    public Risk getRiskById(int userId) {
        return riskMap.get(userId);
    }


    @Override
    public Integer saveRisk(Risk risk) {
        return riskDao.insert(risk);
    }

    @Override
    public Integer deleteRiskById(Integer id) {
        riskDao.deleteByPrimaryKey(id);
        return 0;

    }

    @Override
    public Integer updateRisk(Risk risk) {
        return riskDao.updateByPrimaryKeySelective(risk);
    }

    @Override
    public List<Risk> searchRisk(Risk risk) {
        return riskDao.selectByCondition(risk);
    }



}
