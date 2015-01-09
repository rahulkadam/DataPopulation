package com.bluestone.bazarscan.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
	
	public static SessionFactory getsessionfactory()
	{
		SessionFactory s;
		Configuration c=new Configuration().configure();
		s=c.buildSessionFactory();
		return s;
		
	}
	
	public static Session getSession()
	{
		SessionFactory s=getsessionfactory();
		Session session=s.openSession();
		return session;
	}

}
