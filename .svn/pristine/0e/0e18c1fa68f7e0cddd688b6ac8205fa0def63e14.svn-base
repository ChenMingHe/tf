package edu.uestc.tc.core.filter.ruleimpl;

import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.core.filter.FilterRules;

/**
 * 实现对车辆信息位置的过滤
 */
public final class AreaValidityFiltering implements FilterRules {

	private int highestLat;
	private int lowestLat;
	private int highestLong;
	private int lowestLong;
    
	
	/* (non-Javadoc)
	 * @see edu.uestc.tc.core.filter.FilterRules#check(edu.uestc.tc.beans.VehicleInfo)
	 */
	public void check(VehicleInfo info) throws Exception {

		boolean outRange = info.getiLong() > highestLong
				|| info.getiLong() < lowestLong || info.getiLat() > highestLat
				|| info.getiLat() < lowestLat;
		if (outRange) {
			throw new Exception("不在区域范围内");
		}

	}

	public void setHighestLat(int highestLat) {
		this.highestLat = highestLat;
	}

	public void setHighestLong(int highestLong) {
		this.highestLong = highestLong;
	}

	public void setLowestLat(int lowestLat) {
		this.lowestLat = lowestLat;
	}

	public void setLowestLong(int lowestLong) {
		this.lowestLong = lowestLong;
	}
}
