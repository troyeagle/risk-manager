package com.padeoe.service.impl;

import com.padeoe.pojo.Risk;
import com.padeoe.pojo.User;
import com.padeoe.service.IRiskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zafara on 2016/11/14.
 */
@Service("riskService")
public class RiskServiceImpl implements IRiskService{
    @Resource

    @Override
    public User getRiskById(int userId) {
        return null;
    }

    @Override
    public User getRiskByUser(User user) {
        return null;
    }

    @Override
    public void saveRisk(Risk risk) {

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
