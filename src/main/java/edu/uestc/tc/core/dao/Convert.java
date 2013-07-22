package edu.uestc.tc.core.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Where;

import edu.uestc.tc.beans.CrowdnessGrid;
import edu.uestc.tc.beans.VehicleInfo;
import edu.uestc.tc.utils.VehicleInfoQueue;


/**
 * �����ݿ���ȡ��ԭʼ���ݴ��ڶ�����
 *
 */
public class Convert implements Runnable {

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private VehicleInfoQueue vehicleInfoBuff;
	private SessionFactory sessionFactory;
	int getNumOneTime = 10000; //ÿ�δ����ݿ���ȡ��������

	/**
	 * ����ת���㣬��ʼ�����ݿ���ȡ�����ݣ�ת���ɶ���洢�ڶ����С�
	 * �߳�1
	 */
	public void run() {
		int getCount = 0;//�����ݿ�ȡ�Ĵ���
		assert (vehicleInfoBuff != null);
		Session session = sessionFactory.openSession();
		while (true) {
			Query query = session
					.createQuery("from VehicleInfo");
			query.setFirstResult(getCount*getNumOneTime);
			query.setMaxResults(getNumOneTime);
			getCount++;
			List<VehicleInfo> infoList = query.list();
			if (infoList.size() == 0) {
				System.out.println("break");
				break;
			}
			for (VehicleInfo vehicleInfo : infoList) {
				try {
					vehicleInfoBuff.add(vehicleInfo);
				} catch (InterruptedException e) {
					System.out.println("����д���ԭʼ���ݱ��ж�");
				}
			}
		}
	}

	public void setVehicleInfoBuff(VehicleInfoQueue buffer) {
		this.vehicleInfoBuff = buffer;
	}

}
