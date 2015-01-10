package com.bluestone.bazarscan.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.bluestone.bazarscan.thread.Mobile;

public class BazarScan {
	public ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(1);	
	public static void main(String args[])
	{
		BazarScan bazarScan=new BazarScan();
		bazarScan.init();
	}
	public void init()
	{
		Mobile mobile=new Mobile();
		scheduledExecutorService.scheduleAtFixedRate(mobile, 1000, 1000*1000, TimeUnit.MILLISECONDS);
	}
}
