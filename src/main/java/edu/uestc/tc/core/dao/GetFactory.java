package edu.uestc.tc.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetFactory {
	private static SessionFactory factory = null;
	static Configuration cfg  = new Configuration().configure();
	public static SessionFactory getFactory() {
		if (factory == null) {
			factory = cfg.buildSessionFactory();
		}
		return factory;
	}
}
