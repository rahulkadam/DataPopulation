package com.bluestone.bazarscan.category;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bluestone.bazarscan.dto.BookDetails;
import com.bluestone.bazarscan.dto.BluestoneData;
import com.bluestone.bazarscan.service.Service;
import com.bluestone.bazarscan.util.Utility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class BookDataManager implements Runnable {

	@Override
	public void run() {
		

		String file=Utility.ReadPropertyFile("bookdata");   //"/opt/oss/jbs/data/MobileData.json";
		Service svc=new Service(); 
		Logger log=Logger.getLogger(JewelleryDataManager.class.getName());
		List<BookDetails> bookDetails = null;
		try {
			bookDetails = svc.readBookJson(file);
			
			System.out.println(bookDetails);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Read json file ");
		//svc.storeMobileManufacturer(JewelleryDetails);
		//svc.storeMobileProduct_Header(JewelleryDetails);
		log.info("store product into Db ");
		//svc.storeMobileProduct_Supplier(JewelleryDetails);

	}

}
