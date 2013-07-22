package edu.uestc.tc.utils;

import edu.uestc.tc.beans.VehicleInfo;


/** 
 * 车辆信息缓存接口。
 * @author MingHe
 * 
 */
public interface VehicleInfoQueue {
	/**
	 * 将车辆移动信息数据添加到缓存中
	 * @param info 车辆移动信息数据
	 */
	void add(VehicleInfo info) throws InterruptedException;
	/**
	 * 获取一个车辆移动信息数据
	 * @return 车辆移动信息对象
	 */
	VehicleInfo poll() throws InterruptedException;
	/**
	 * 判断一个队列是否为空
	 * @return 队列状态
	 */
  // boolean isEmpty();
}
