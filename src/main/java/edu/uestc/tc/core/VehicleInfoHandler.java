package edu.uestc.tc.core;

import edu.uestc.tc.beans.VehicleInfo;

/** 
 * �����ƶ���Ϣ��������������ӿڡ�
 * @author MingHe
 * 
 */
public interface VehicleInfoHandler {
	/**
	 * ְ�����������ӿڣ�����������������Ҫʵ�ָú�����
	 * @param info �����ƶ���Ϣ����
	 */
	void handle(VehicleInfo info);
}
