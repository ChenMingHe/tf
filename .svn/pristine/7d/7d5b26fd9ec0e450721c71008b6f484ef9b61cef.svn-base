package edu.uestc.tc.utils;


import java.util.concurrent.LinkedBlockingQueue;

import edu.uestc.tc.beans.VehicleInfo;


/** 
 * 车辆移动位置信息Fifo缓存实现。支持线程安全。
 * @author MingHe
 * 
 */
public class VehicleInfoLinkedBlockingQueue implements VehicleInfoQueue {

	private LinkedBlockingQueue<VehicleInfo> vehicleInfoQueue;
	
	
	public void setVehicleInfoQueue(
			LinkedBlockingQueue<VehicleInfo> vehicleInfoQueue) {
		this.vehicleInfoQueue = vehicleInfoQueue;
	}

	/* (non-Javadoc)
	 * @see edu.uestc.tc.utils.VehicleInfoFifoBuffer#push(edu.uestc.tc.beans.VehicleInfo)
	 */
	public void add(VehicleInfo info) throws InterruptedException {
		vehicleInfoQueue.put(info);
	}

	/* (non-Javadoc)
	 * @see edu.uestc.tc.utils.VehicleInfoFifoBuffer#pop()
	 */
	public VehicleInfo poll() throws InterruptedException {
		return vehicleInfoQueue.take();
	}

}
