package com.bluestone.bazarscan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
	
	public static Logger log=Logger.getLogger(Utility.class.getName());
	public static SessionFactory getsessionfactory()
	{
		try{
		log.info("Creating Session factory");
		Properties prop = new Properties();
		InputStream input = new FileInputStream("/opt/oss/jbs/etc/properties");
		// load a properties file
		prop.load(input);
		log.info("get properties "+prop.getProperty("hibernetfile"));
		File hibernatePropsFile = new File(prop.getProperty("hibernetfile"));
		log.info("Completed hibernate.cfg.xml File Reading");
		SessionFactory sessionFactory = new Configuration().configure(
				hibernatePropsFile)
		.buildSessionFactory();
		log.info("Completed Creating SessionFactory");
		return sessionFactory;
		}catch(Exception e){
			log.info("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static Session getSession()
	{
		SessionFactory s=getsessionfactory();
		Session session=s.openSession();
		return session;
	}

}
