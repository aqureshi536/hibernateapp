package com.ahmad.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ApplicationConfig {

	public static ApplicationConfig applicationConfig;
	private static SessionFactory sessionFactory;

	private ApplicationConfig() {
		initializeApplication();
	}

	public static ApplicationConfig getInstance() {
		if (applicationConfig == null) {
			applicationConfig = new ApplicationConfig();
		}
		return applicationConfig;
	}

	private boolean initializeApplication() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		buildSession(cfg);
		return true;
	}

	private SessionFactory buildSession(Configuration cfg) {
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}

	public Session openSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

}
