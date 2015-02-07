package com.bluestone.bazarscan.category;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bluestone.bazarscan.dto.MobileDetails;
import com.bluestone.bazarscan.service.Service;
import com.bluestone.bazarscan.testclient.MobileTestClient;
import com.bluestone.bazarscan.util.Utility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class MobileDataManager implements Runnable {

	@Override
	public void run() {
		
		String file=Utility.ReadPropertyFile("mobiledata");   //"/opt/oss/jbs/data/MobileData.json";
		Service svc=new Service(); 
		Logger log=Logger.getLogger(MobileDataManager.class.getName());
		log.warn("Warn Message!");
		log.info("printing log");
		List<MobileDetails> mobileDetailsList = null;
		try {
			mobileDetailsList = svc.readMobileJson(file);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Read json file ");
		svc.storeMobileManufacturer(mobileDetailsList);
		svc.storeMobileProduct_Header(mobileDetailsList);
		log.info("store product into Db ");
		svc.storeMobileProduct_Supplier(mobileDetailsList);
		
	}

}
