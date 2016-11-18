package com.padeoe.service;

import com.padeoe.pojo.*;

import java.util.List;
/**
 * com.padeoe.service
 *
 * @author troy_diao on 2016/11/17
 */
public interface IRiskOperationService {

    public int saveRiskOperation(RiskOperation riskOperation);

    public void updateRiskOperation(RiskOperation riskOperation);
    
    /**
     * 查询一个项目的所有风险条目的最新状态
     */
    public List<RiskOperation> queryByProjectLatest(String projectName);

    /**
     * 查询曾经被发现/演变为问题/被解决最多的风险条目
     */
    public List<Risk> queryByState(int state);

    /**
     * 查询当前处在被发现/转变为问题/被解决最多的风险
     */
    public List<Risk> queryByStateLatest(int state);

    /**
     * 万能接口：查看由某个人发现的，某个项目的，当前状态为某个值的等一系列符合条件的最新的风险条目
     * 参数选填，包装为一个{@link RiskOperation}实体
     */
    public List<RiskOperation> queryByConditionLatest(RiskOperation condition);

    /**
     * 万能接口：查看由某个人发现的，某个项目的，曾经有过状态为某个值的等一系列符合条件的风险条目
     * 参数选填，包装为一个{@link RiskOperation}实体
     */
    public List<RiskOperation> queryByCondition(RiskOperation condition);
}
