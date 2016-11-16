package com.padeoe.service;


import com.padeoe.pojo.Risk;

import java.util.List;

public interface IRiskService {
    public Risk getRiskById(int riskId);

    /**
     * 返回riskId
     * @param risk
     * @return
     */
    public Integer saveRisk(Risk risk);

    public void deleteRiskById(Integer id);

    public void updateRisk(Risk risk);

    public List<Risk> searchRisk(Risk risk);
}
