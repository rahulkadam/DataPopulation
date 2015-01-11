package com.bluestone.bazarscan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		File hibernatePropsFile = new File(Utility.ReadPropertyFile("hibernetfile"));
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
	
	public static String ReadPropertyFile(String key) 
	{
		try{
		Properties prop = new Properties();
		// load a properties file
		InputStream input = new FileInputStream("/opt/oss/jbs/etc/properties");
		prop.load(input);
		log.info("get properties for "+key+"  : "+prop.getProperty(key));
		return prop.getProperty(key);
		}catch(Exception e)
		{
			log.info("Error "+e);
			e.printStackTrace();
			return null;
		}
	}
}
