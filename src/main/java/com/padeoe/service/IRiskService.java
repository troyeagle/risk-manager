package com.padeoe.service;


import com.padeoe.pojo.Risk;
import com.padeoe.pojo.User;

public interface IRiskService {
    public Risk getRiskById(int riskId);

    public Risk[] getRiskByUser(User user);

    public void saveRisk(Risk risk);

    public void deleteRisk(Risk risk);

    public void changeRisk(Risk risk);

    public void searchRisk(Risk risk);
}
