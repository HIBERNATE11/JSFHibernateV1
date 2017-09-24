package com.mitocode.util;



import javax.naming.InitialContext;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {

//	private static final SessionFactory sessionFactory;
	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file. Si el cfg.xml esta en la raiz (default-package), el configure seria "()"
			//sessionFactory = new AnnotationConfiguration().configure("com/mitocode/xml/hibernate.cfg.xml").buildSessionFactory();
			
        	//Lo anterior es antiguo (v3. funciona). Lo mas reciente es (v4):
        	Configuration configuration = new Configuration();
        	configuration.configure("com/mitocode/xml/hibernate.cfg.xml");
        	serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
        	sessionFactory = configuration.buildSessionFactory(serviceRegistry);			
			
        } catch (Throwable ex) {            
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
		return sessionFactory;
    }
}
