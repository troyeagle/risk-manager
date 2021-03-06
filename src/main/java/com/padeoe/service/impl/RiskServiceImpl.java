package com.padeoe.service.impl;

import com.padeoe.dao.IRiskDao;
import com.padeoe.pojo.Risk;
import com.padeoe.service.IRiskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zafara on 2016/11/14.
 */
@Service("riskService")
public class RiskServiceImpl implements IRiskService{
    @Resource
    private IRiskDao riskDao;

    @Override
    public Risk getRiskById(int userId) {
        return riskDao.selectByPrimaryKey(userId);
    }


    @Override
    public Integer saveRisk(Risk risk) {
        riskDao.insert(risk);
        return risk.getId();
    }

    @Override
    public void deleteRiskById(Integer id) {
        riskDao.deleteByPrimaryKey(id);

    }

    @Override
    public void updateRisk(Risk risk) {
        riskDao.updateByPrimaryKeySelective(risk);
    }

    @Override
    public List<Risk> searchRisk(Risk risk) {
        return riskDao.selectByCondition(risk);
    }


	@Override
	public Set<Integer> getNonremovableRisks() {
		Set<Integer> result = new TreeSet<Integer>();
		for(Risk risk : riskDao.selectNonremovable())
			result.add(risk.getId());
		return result;
	}
}
