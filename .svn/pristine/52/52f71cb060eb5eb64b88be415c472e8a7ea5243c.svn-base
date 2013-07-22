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
 * 从数据库中取出原始数据存于队列中
 *
 */
public class Convert implements Runnable {

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private VehicleInfoQueue vehicleInfoBuff;
	private SessionFactory sessionFactory;
	int getNumOneTime = 10000; //每次从数据库中取出的数量

	/**
	 * 启动转换层，开始从数据库中取出数据，转换成对象存储于队列中。
	 * 线程1
	 */
	public void run() {
		int getCount = 0;//从数据库取的次数
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
					System.out.println("向队列存入原始数据被中断");
				}
			}
		}
	}

	public void setVehicleInfoBuff(VehicleInfoQueue buffer) {
		this.vehicleInfoBuff = buffer;
	}

}
