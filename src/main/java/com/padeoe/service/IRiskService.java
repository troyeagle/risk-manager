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

    /**
     *
     * @param risk 将搜索的条件输入risk中，各个条件为并集。
     * @return
     */
    public List<Risk> searchRisk(Risk risk);
}
