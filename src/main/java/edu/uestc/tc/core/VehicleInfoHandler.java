package edu.uestc.tc.core;

import edu.uestc.tc.beans.VehicleInfo;

/** 
 * 车辆移动信息处理责任链抽象接口。
 * @author MingHe
 * 
 */
public interface VehicleInfoHandler {
	/**
	 * 职责链处理函数接口，过滤器和屏障器需要实现该函数。
	 * @param info 车辆移动信息数据
	 */
	void handle(VehicleInfo info);
}
