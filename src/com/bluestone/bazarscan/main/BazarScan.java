package com.bluestone.bazarscan.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bluestone.bazarscan.thread.Mobile;
import com.bluestone.bazarscan.util.Utility;

public class BazarScan {
	public ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);	
	static{
		PropertyConfigurator.configure(Utility.ReadPropertyFile("log4j"));
	}
	
	public static void main(String args[])
	{
		 Logger log=Logger.getLogger(BazarScan.class.getName());

	//	PropertyConfigurator.configure(Utility.ReadPropertyFile("log4j"));
		log.info("Initializing BazarScan");
		BazarScan bazarScan=new BazarScan();
		bazarScan.init();
		log.info("Exiting BazarScan");
	}
	public void init()
	{	  Logger log=Logger.getLogger(BazarScan.class.getName());

		log.info("Initializing MobileThread");
		Mobile mobile=new Mobile();
		scheduledExecutorService.scheduleAtFixedRate(mobile, 1000, 1000*1000, TimeUnit.MILLISECONDS);
		log.info("Exiting  MobileThread");
	}
}
