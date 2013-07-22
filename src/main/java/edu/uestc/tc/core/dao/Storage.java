package edu.uestc.tc.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.uestc.tc.beans.CrowdnessArea;
import edu.uestc.tc.beans.CrowdnessGrid;
import edu.uestc.tc.utils.CrowdnessGridQueue;

public class Storage implements Runnable {

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private int columnNum;
	private CrowdnessGridQueue crowdnessGridQueue = null;
	private int rowNum;
	private SessionFactory sessionFactory;

	public void run() {
		if (crowdnessGridQueue == null) {
			System.out.println("队列未初始化");
			return;
		}
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			while (true) {
				CrowdnessGrid crowdnessGrid = crowdnessGridQueue.poll();
				System.out.println(crowdnessGrid.getCurrentDate());
				rowNum = crowdnessGrid.getRowNum();
				columnNum = crowdnessGrid.getColunmNum();
				for (int i = 0; i <= rowNum - 1; i++) {
					for (int j = 0; j <= columnNum - 1; j++) {
						if (crowdnessGrid.getCrowdnessAreaArray()[i][j] != null
								&& crowdnessGrid.getCrowdnessAreaArray()[i][j]
										.getAreaCrowdness() != 0) {
							session.save(crowdnessGrid.getCrowdnessAreaArray()[i][j]);
						}
					}
				}
				tx.commit();
				tx = session.beginTransaction();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupt");
		}
		session.close();
	}

	public void setCrowdnessGridQueue(CrowdnessGridQueue crowdnessGridQueue) {
		this.crowdnessGridQueue = crowdnessGridQueue;
	}

}
