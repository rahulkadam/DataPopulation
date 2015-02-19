package com.bluestone.bazarscan.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bluestone.bazarscan.category.BookDataManager;
import com.bluestone.bazarscan.category.JewelleryDataManager;
import com.bluestone.bazarscan.category.MobileDataManager;
import com.bluestone.bazarscan.dto.BluestoneData;
import com.bluestone.bazarscan.util.Utility;

public class BazarScan {
	public ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);	
	static{
		PropertyConfigurator.configure(Utility.ReadPropertyFile("log4j"));
	}
	public static Logger log=Logger.getLogger(BazarScan.class.getName());
	
	public static void main(String args[])
	{
		PropertyConfigurator.configure(Utility.ReadPropertyFile("log4j"));
		log.info("Initializing BazarScan");
		BazarScan bazarScan=new BazarScan();
		bazarScan.init();
		log.info("Exiting BazarScan");
	}
	public void init()
	{
		//log.info("Initializing MobileDataManager");
		//MobileDataManager mobileDataManager=new MobileDataManager();
	//	//scheduledExecutorService.scheduleAtFixedRate(mobileDataManager, 1000, 1000*1000, TimeUnit.MILLISECONDS);
	//	log.info("Exiting  MobileDataManager");
	//	log.info("Initializing BookDataManager");
		//BookDataManager bookDataManager=new BookDataManager();
		//scheduledExecutorService.scheduleAtFixedRate(bookDataManager, 1000, 1000*1000*90, TimeUnit.MILLISECONDS);
		//log.info("Exiting  BookDataManager");
		log.info("Initializing JewelleryDataManager");
		JewelleryDataManager jewelleryDataManager=new JewelleryDataManager();
		scheduledExecutorService.scheduleAtFixedRate(jewelleryDataManager, 1000, 1000*1000, TimeUnit.MILLISECONDS);
		log.info("Exiting  JewelleryDataManager");
	}
}
