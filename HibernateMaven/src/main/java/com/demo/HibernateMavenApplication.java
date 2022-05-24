package com.demo;

import java.sql.Date;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateMavenApplication {

	static User userObj;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
 

	public static void main(String[] args) {
		SpringApplication.run(HibernateMavenApplication.class, args);
		System.out.println("Hibernate one to many (Annotation)");
		Session session = Util.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
	        stock.setStockCode("1001");
	        stock.setStockName("HAMAM");
	        session.save(stock);
	        
	        StockDailyRecord stockDailyRecords = new StockDailyRecord();
	        stockDailyRecords.setPriceOpen(new Float("1.2"));
	        stockDailyRecords.setPriceClose(new Float("1.1"));
	        stockDailyRecords.setPriceChange(new Float("10.0"));
	        stockDailyRecords.setVolume(3000000L);
	        stockDailyRecords.setDate(new Date(System.currentTimeMillis()));
	        
	        stockDailyRecords.setStock(stock);        
	        stock.getStockDailyRecords().add(stockDailyRecords);

	        session.save(stockDailyRecords);

		session.getTransaction().commit();
		System.out.println("Done");	}

}
