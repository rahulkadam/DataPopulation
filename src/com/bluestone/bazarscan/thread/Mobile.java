package com.bluestone.bazarscan.thread;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bluestone.bazarscan.dto.Product;
import com.bluestone.bazarscan.service.Service;
import com.bluestone.bazarscan.testclient.MobileTestClient;
import com.bluestone.bazarscan.util.Utility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Mobile implements Runnable {

	@Override
	public void run() {
		
		String file=Utility.ReadPropertyFile("mobiledata");   //"/opt/oss/jbs/data/MobileData.json";
		Service svc=new Service(); 
		Logger log=Logger.getLogger(Mobile.class.getName());
		log.warn("Warn Message!");
		log.info("printing log");
		List<Product> list = null;
		try {
			list = svc.readjson(file);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Read json file ");
		svc.storeManufacturer(list);
		svc.storeProduct_header(list);
		log.info("store product into Db ");
		svc.storeProduct_supplier(list);
		
	}

}
