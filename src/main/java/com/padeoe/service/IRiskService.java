package com.padeoe.service;


import com.padeoe.pojo.Risk;

import java.util.List;

public interface IRiskService {
    public Risk getRiskById(int riskId);

    public Integer saveRisk(Risk risk);

    public Integer deleteRiskById(Integer id);

    public Integer updateRisk(Risk risk);

    public List<Risk> searchRisk(Risk risk);
}
