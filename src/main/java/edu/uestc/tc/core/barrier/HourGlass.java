/**
 * 
 */
package edu.uestc.tc.core.barrier;

import edu.uestc.tc.beans.VehicleInfo;

/**
 * ʱ��ɳ©�����ڹ���ʱ������
 * @author MingHe
 *
 */
public interface HourGlass {
	/**
	 * ��ȡʱ����
	 * @param info ������Ϣ����
	 * @return ʱ������־
	 */
	int timerInterval(VehicleInfo info);
}
