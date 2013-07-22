package edu.uestc.tc.core;

import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.utils.VehicleInfoQueue;


/**
 * Filter���
 */
public class VehicleInfoHandleEntry implements Runnable {

	private VehicleInfoHandler filterHandler = null;
	private VehicleInfoQueue vehicleInfobuff = null;
	private VehicleInfo vehicleInfo = null;

	/**
	 * �������������
	 * �߳�2
	 */
	public void run() {
		// ȡ�����������ݽ���filterHandler����
		assert (filterHandler != null);
		while (true) {
			try {
				vehicleInfo = vehicleInfobuff.poll();
				filterHandler.handle(vehicleInfo);
			} catch (InterruptedException e) {
				System.out.println("�Ӷ�����ȡ��ԭʼ���ݱ��ж�");
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
