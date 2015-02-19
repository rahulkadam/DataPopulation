package com.bluestone.bazarscan.category;

import java.util.List;

import org.apache.log4j.Logger;

import com.bluestone.bazarscan.dto.BluestoneData;
import com.bluestone.bazarscan.service.Service;
import com.bluestone.bazarscan.util.Utility;

public class JewelleryDataManager implements Runnable {

		
		@Override
		public void run() {
			String file=Utility.ReadPropertyFile("bluestonedata");   //"/opt/oss/jbs/data/MobileData.json";
			Service svc=new Service(); 
			Logger log=Logger.getLogger(JewelleryDataManager.class.getName());
			List<BluestoneData> list = null;
				list = svc.readJewelleryJson(file);
				//System.out.println(list);
				//log.info("printing log bluestone");
				//svc.storeBluestoneProduct_header(list);
				svc.storeBluestoneLineDetails(list);
				System.out.println("size :"+list.size());
				//svc.storeBlueStoneproductSupplier(list);
				//System.out.println(list);
				//log.info("printing log bluestone");
			//log.info("Read json file ");
			//svc.storeManufacturer(list);
			//svc.storeProduct_header(list);
			//log.info("store bluestone product into Db ");
			//svc.storeProduct_supplier(list);

		}


}
