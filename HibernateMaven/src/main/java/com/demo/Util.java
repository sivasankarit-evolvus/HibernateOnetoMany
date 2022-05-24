package com.demo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Util {
	 private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	        	
	        	Configuration myConfig = new Configuration();
	        	myConfig.configure("hibernate.cfg.xml");
	        	//myConfig.setProperty("hibernate.bytecode.use_reflection_optimizer", "false");
	        	//myConfig.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	        	//myConfig.setProperty("hibernate.connection.password", "password");
	        	//myConfig.setProperty("hibernate.connection.url", "cjdbc:mysql://localhost:3306/demo");
	        	//myConfig.setProperty("hibernate.connection.username", "demo_user");
	        	//myConfig.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        	//myConfig.setProperty("show_sql", "true");
	        	return myConfig.buildSessionFactory();
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    public static void shutdown() {
	    	// Close caches and connection pools
	    	getSessionFactory().close();
	    }

}
