package com.padeoe.service;

import java.util.Date;
import java.util.List;

import com.padeoe.pojo.Risk;
import com.padeoe.pojo.RiskSearchResult;

public interface ISearchService {
	/**
	 * 进行项目的统计。
	 * 
	 * @param state 为null时，不进行筛选，为1时，根据识别数量进行排序，为2时，根据转变为问题数量排序。
	 * @param projectName 为null时，不进行筛选，为某一项目名时，已经出现过的风险不会再出现
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return 风险及其出现次数
	 */
	
	public List<RiskSearchResult> searchByCondition(Integer state, 
			String projectName, Date startDate, Date endDate);
	
	/**
	 * @param projectName 项目名
	 * @return 项目中未出现过的风险。
	 */
	
	public List<Risk> selectExcludeProject(String projectName);
}
