package com.bluestone.bazarscan.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.bluestone.bazarscan.thread.Mobile;
import com.bluestone.bazarscan.util.Utility;

public class BazarScan {
	public ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);	
	public static Logger log=Logger.getLogger(BazarScan.class.getName());

	public static void main(String args[])
	{
		log.info("Initializing BazarScan");
		BazarScan bazarScan=new BazarScan();
		bazarScan.init();
		log.info("Exiting BazarScan");
	}
	public void init()
	{
		log.info("Initializing MobileThread");
		Mobile mobile=new Mobile();
		scheduledExecutorService.scheduleAtFixedRate(mobile, 1000, 1000*1000, TimeUnit.MILLISECONDS);
		log.info("Exiting  MobileThread");
	}
}
