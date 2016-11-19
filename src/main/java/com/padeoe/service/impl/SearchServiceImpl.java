package com.padeoe.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.padeoe.dao.ISearchDao;
import com.padeoe.pojo.Risk;
import com.padeoe.pojo.RiskOperation;
import com.padeoe.pojo.RiskSearchResult;
import com.padeoe.service.ISearchService;

@Service("searchService")
public class SearchServiceImpl implements ISearchService {
	@Resource ISearchDao search;
	
	@Override
	public List<RiskSearchResult> searchByCondition(Integer state, String projectName, Date startDate, Date endDate) {
		RiskOperation param = new RiskOperation();
		param.setState(state);
		param.setProjectName(projectName);
		param.setStartTime(startDate);
		param.setEndTime(endDate);
		return search.search(param);
	}

	@Override
	public List<Risk> selectExcludeProject(String projectName) {
		RiskOperation param = new RiskOperation();
		param.setProjectName(projectName);
		return search.searchExcludeProject(param);
	}
}
