package com.padeoe.service;

import java.util.Date;
import java.util.List;

import com.padeoe.pojo.Risk;
import com.padeoe.pojo.RiskSearchResult;

public interface ISearchService {
	public List<RiskSearchResult> searchByCondition(Integer state, 
			String projectName, Date startDate, Date endDate);
	
	public List<Risk> selectExcludeProject(String projectName);
}
