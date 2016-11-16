package com.padeoe.service.impl;

import com.padeoe.dao.IRiskDao;
import com.padeoe.pojo.Risk;
import com.padeoe.pojo.User;
import com.padeoe.service.IRiskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zafara on 2016/11/14.
 */
@Service("riskService")
public class RiskServiceImpl implements IRiskService{
    @Resource
    private IRiskDao riskDao;

    private static AtomicInteger id = new AtomicInteger();
    private static Map<Integer, Risk> riskMap = new HashMap<>();
    @Override
    public Risk getRiskById(int userId) {
        return riskMap.get(userId);
    }

    @Override
    public Risk[] getRiskByUser(User user) {
        Risk[] risks;

        return null;
    }

    @Override
    public void saveRisk(Risk risk) {
        riskDao.insert(risk);
    }

    @Override
    public void deleteRisk(Risk risk) {
    }

    @Override
    public void changeRisk(Risk risk) {

    }

    @Override
    public void searchRisk(Risk risk) {

    }



}
