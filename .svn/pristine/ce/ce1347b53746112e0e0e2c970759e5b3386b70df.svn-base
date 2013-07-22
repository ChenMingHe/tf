package edu.uestc.tc.core.filter;

import java.util.ArrayList;
import java.util.List;

import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.core.VehicleInfoHandler;
import edu.uestc.tc.core.filter.FilterRules;

/**
 * 实现单个数据报文的过滤操作。
 * 
 */
public class Filter implements VehicleInfoHandler {

	private List<FilterRules> ruleList;
	private VehicleInfoHandler successor;

	public void setRuleList(List<FilterRules> ruleList) {
		this.ruleList = ruleList;
	}

	public void setSuccessor(VehicleInfoHandler successor) {
		this.successor = successor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uestc.tc.core.VehicleInfoHandler#handle(edu.uestc.tc.beans.VehicleInfo
	 * )
	 */
	public void handle(VehicleInfo info) {
		for (FilterRules rule : ruleList) {
			try {
				rule.check(info);
			} catch (Exception e) {
				return;
			}
		}
		if (successor != null) {
			successor.handle(info);
		}
	}
}
