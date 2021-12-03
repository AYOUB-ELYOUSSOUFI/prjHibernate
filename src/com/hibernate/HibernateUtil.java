package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.models.Etudiant;
import com.models.Filiere;



public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			
			configuration.addAnnotatedClass(Etudiant.class);
			configuration.addAnnotatedClass(Filiere.class);
			
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(Throwable th) {
			System.err.println("Enitial SessionFactory creation faild " + th);
			throw new ExceptionInInitializerError(th);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
