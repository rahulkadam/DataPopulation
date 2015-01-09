package com.bluestone.bazarscan.testclient;


import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

import com.bluestone.bazarscan.dto.Product;
import com.bluestone.bazarscan.service.Service;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class MobileTestClient {

	/**
	 * @param args
	 * @throws JsonParseException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws HibernateException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		
		String file="/home/rahul/Desktop/jackson_Sample/src/sample.json";
		Service svc=new Service(); 
		Logger log=Logger.getLogger(MobileTestClient.class.getName());
		  log.warn("Warn Message!");
		log.info("printing log");

		List<Product> list=svc.readjson(file);
		svc.storeManufacturer(list);
		//svc.storeProduct_header(list);
		//svc.storeProduct_supplier(list);
	}
}