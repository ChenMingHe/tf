package edu.uestc.tc.core;

import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.utils.VehicleInfoQueue;


/**
 * Filter入口
 */
public class VehicleInfoHandleEntry implements Runnable {

	private VehicleInfoHandler filterHandler = null;
	private VehicleInfoQueue vehicleInfobuff = null;
	private VehicleInfo vehicleInfo = null;

	/**
	 * 启动处理链入口
	 * 线程2
	 */
	public void run() {
		// 取出缓存中数据交由filterHandler处理
		assert (filterHandler != null);
		while (true) {
			try {
				vehicleInfo = vehicleInfobuff.poll();
				filterHandler.handle(vehicleInfo);
			} catch (InterruptedException e) {
				System.out.println("从队列中取出原始数据被中断");
			}
		}
	}

	public void setFilterHandler(VehicleInfoHandler filterHandler) {
		this.filterHandler = filterHandler;
	}

	public void setVehicleInfobuff(VehicleInfoQueue vehicleInfobuff) {
		this.vehicleInfobuff = vehicleInfobuff;
	}

}
