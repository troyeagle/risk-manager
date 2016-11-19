package com.padeoe.service.impl;

import com.padeoe.dao.IRiskOperationDao;
import com.padeoe.pojo.Risk;
import com.padeoe.pojo.RiskOperation;
import com.padeoe.service.IRiskOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * com.padeoe.service.impl
 *
 * @author troy_diao on 2016/11/17
 */
@Service("riskOperationService")
public class RiskOperationServiceImpl implements IRiskOperationService{
    @Resource
    private IRiskOperationDao riskOperationDao;

    @Override
    public int saveRiskOperation(RiskOperation riskOperation) {
        riskOperationDao.insertSelective(riskOperation);
        return riskOperation.getId();
    }

    @Override
    public List<RiskOperation> queryByProjectLatest(String projectName) {
        return riskOperationDao.selectByProjectLatest(projectName);
    }

    @Override
    public List<Risk> queryByState(int state) {
        return riskOperationDao.queryByState(state);
    }

    @Override
    public List<Risk> queryByStateLatest(int state) {
        return riskOperationDao.queryByStateLatest(state);
    }

    @Override
    public List<RiskOperation> queryByConditionLatest(RiskOperation condition) {
        return riskOperationDao.selectByConditionLatest(condition);
    }

    @Override
    public List<RiskOperation> queryByCondition(RiskOperation condition) {
        return riskOperationDao.selectByCondition(condition);
    }

	@Override
	public RiskOperation selectById(Integer id) {
		return riskOperationDao.selectByPrimaryKey(id);
	}
}
