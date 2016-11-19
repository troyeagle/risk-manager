package com.padeoe.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padeoe.pojo.Risk;
import com.padeoe.pojo.RiskOperation;
import com.padeoe.pojo.RiskSearchResult;

/**
 * 用于检索特定的风险条目及其数量。
 * 
 * @author luohaoran
 */

@Component
public interface ISearchDao {
	List<RiskSearchResult> search(RiskOperation operation);
	
	List<Risk> searchExcludeProject(RiskOperation operation);
}
