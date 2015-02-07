package com.bluestone.bazarscan.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.bluestone.bazarscan.dao.impl.BazarScanDaoImpl;
import com.bluestone.bazarscan.dto.BookDetails;
import com.bluestone.bazarscan.dto.BluestoneData;
import com.bluestone.bazarscan.dto.MobileDetails;
import com.bluestone.bazarscan.dto.Product_Header;
import com.bluestone.bazarscan.dto.Product_Line;
import com.bluestone.bazarscan.dto.Product_Supplier;
import com.bluestone.bazarscan.dto.manufacturer;
import com.bluestone.bazarscan.util.Utility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {
	
	

	public BazarScanDaoImpl bazarScanImpl=BazarScanDaoImpl.getInstance();

	//------------------------------------Mobile-------------------------------------
	public List<MobileDetails> readMobileJson(String filename) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<MobileDetails> mobileDetailsList = obj.readValue(
				new File(filename),
				obj.getTypeFactory().constructCollectionType(List.class,
						MobileDetails.class));
		return mobileDetailsList;

	}
	
	//To store Mobile manufacturer List in DB
	public void storeMobileManufacturer(List<MobileDetails> mobileDetailsList) {
		Set<String> manufacturerList = new TreeSet<String>();
		for (MobileDetails product : mobileDetailsList) {
			manufacturerList.add(product.getMfg());
		}
		for (String manufacturerName : manufacturerList) {
			long mfg_id=bazarScanImpl.getRowCount(manufacturer.class);
			mfg_id=mfg_id+1;
			manufacturer m = new manufacturer();
			m.setMfg_id("" + mfg_id);
			m.setMfg_name(manufacturerName);
			bazarScanImpl.storeManufacturer(m);
		}
	}
	
	//To store Mobile Product_Header List in DB
	public void storeMobileProduct_Header(List<MobileDetails> productList) {

		for (MobileDetails product : productList) {
			    long product_id=bazarScanImpl.getRowCount(Product_Header.class);
			    product_id=product_id+1;
				Product_Header product_Header = new Product_Header();
				product_Header.setMfg_model_id(product.getModelName().substring(0, 10));
				product_Header.setProduct_name("Mobile");
				product_Header.setId("" + product_id);
				product_Header.setMfg_id(bazarScanImpl.getManufacturerIdFromName(product.getMfg()));				
				product_Header.setProduct_color("RED");
				product_Header.setSub_category("mobile");
				bazarScanImpl.storeProduct_header(product_Header);
				}
		}
	//To store Mobile Product_Supplier List in DB
	public void storeMobileProduct_Supplier(List<MobileDetails> productList) {
		
		for (MobileDetails product : productList) {
				long supplierId=bazarScanImpl.getRowCount(Product_Supplier.class);
				supplierId=supplierId+1;
				Product_Supplier product_Supplier = new Product_Supplier();
				product_Supplier.setSupplier_id("" + supplierId);
				product_Supplier.setProduct_id("" + supplierId);
				product_Supplier.setProduct_url(product.getUrl());
				if (product.getGiftWrapAvailable() == "Available") {
					product_Supplier.setGift_wrap('Y');
				} else {
					product_Supplier.setGift_wrap('N');
				}
				if (product.getIsInStock() != null
						&& product.getIsInStock() != "") {
					product_Supplier.setIn_stock('Y');
				} else {
					product_Supplier.setIn_stock('N');
				}
				product_Supplier.setEmi_available(product.getIsEMiAvailable());

				bazarScanImpl.storeProduct_supplier(product_Supplier);
	}
  }

	public void storesubcategory(List<MobileDetails> productList) {

	}

	public void storeReviews(List<MobileDetails> productList) {

	}
///--------------------------------Jwellary----------------------
	public List<BluestoneData> readJewelleryJson(String filename) throws JsonParseException,
	JsonMappingException, IOException {
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
List<BluestoneData> jewelleryDetailsList = objectMapper.readValue(
		new File(filename),
		objectMapper.getTypeFactory().constructCollectionType(List.class,
				BluestoneData.class));
return jewelleryDetailsList;
}
	
	public void storeBluestoneProduct_header(List<BluestoneData> productList) {

		for (BluestoneData product : productList) {
			   // long product_id=bazarScanImpl.getRowCount(Product_Header.class);
			    //product_id=product_id+1;
				Product_Header product_Header = new Product_Header();
				//product_Header.setMfg_model_id(product.getModelName().substring(0, 10));
				if(product.getProduct_code()[0].startsWith("Product code"))
				{
					product_Header.setId(product.getProduct_code()[0].substring(13));
				}else{
				product_Header.setId(product.getProduct_code()[0]);
				}
				product_Header.setProduct_name(product.getTitle()[0]);
				product_Header.setMfg_id(bazarScanImpl.getManufacturerIdFromName("BLUESTONE"));				
				//product_Header.setProduct_color("RED");
				product_Header.setSub_title(product.getSub_title()[0]);
				product_Header.setHeight(product.getLine_product_details().get("Height"));
				product_Header.setWidth(product.getLine_product_details().get("Width"));
				product_Header.setWeight(product.getLine_product_details().get("Product Weight (Approx.)".trim()));
			   
				if(!bazarScanImpl.isProductExists(product_Header.getId()))
			     {
			    	 bazarScanImpl.storeProduct_header(product_Header);
			     }
			     else{
			    	 System.out.println("update product header for id :"+product_Header.getId());
			    	 bazarScanImpl.updateProduct_header(product_Header);
			    	 
			     }
				System.out.println("Product Header   :"+product_Header);
				}
		}
	public void storeBluestoneLineDetails(List<BluestoneData> bluestoneDataList)
	{
    	Map<String,String> groupLineMap=bazarScanImpl.getGroup_Line();	
    	Map<String,String> groupsMap=bazarScanImpl.getGroups();	
	  for(BluestoneData bluestoneData:bluestoneDataList)
	  {
		  Map<String,String> stone_details=bluestoneData.getStone_details();
		  Set<String> keys=stone_details.keySet();
		  for(String key:keys)
		  {
			  if(!key.equals("Title"))
			  {
				  try{
				  Product_Line product_Line=new Product_Line();
				  if(bluestoneData.getProduct_code()[0].startsWith("Product code"))
					{
					  product_Line.setProduct_Id(bluestoneData.getProduct_code()[0].substring(13));
					}else{
						  product_Line.setProduct_Id(bluestoneData.getProduct_code()[0]);
					}
				  product_Line.setGroup_Line_Id(groupLineMap.get(key)); //bazarScanImpl.getGroup_Line_Id(key.trim()));
				  product_Line.setGroup_Id(groupsMap.get(stone_details.get("Title"))); //bazarScanImpl.getGroup_Id(stone_details.get("Title")));
				  product_Line.setValue(stone_details.get(key));
				  long line_id=bazarScanImpl.getRowCount(Product_Line.class);
				  line_id=line_id+1;
				  product_Line.setProduct_Line_Id(String.valueOf(line_id));
				  bazarScanImpl.storeLineDetails(product_Line);
				  System.out.println("Product_Line   :"+product_Line);
				  }catch(Exception e)
				  {
					  e.printStackTrace();
				  }
			  }
		  }
	  }
	}

	public void storeBlueStoneproductSupplier(List<BluestoneData> bluestoneDataList)
	{
		
		for(BluestoneData bluestoneData:bluestoneDataList)
		  {
			Product_Supplier product_Supplier=new Product_Supplier(); 
			product_Supplier.setPrice(Double.valueOf(bluestoneData.getPrice()[0]));
			if(bluestoneData.getProduct_code()[0].startsWith("Product code"))
			{
				product_Supplier.setProduct_id(bluestoneData.getProduct_code()[0].substring(13));
			}else{
				product_Supplier.setProduct_id(bluestoneData.getProduct_code()[0]);
			}
			product_Supplier.setCurrency("INR");
			product_Supplier.setSupplier_id(String.valueOf(bazarScanImpl.getRowCount(Product_Supplier.class)+1));
			product_Supplier.setMfgId(186);
			product_Supplier.setProduct_url(bluestoneData.getUrl());
			bazarScanImpl.storeProduct_supplier(product_Supplier);
			System.out.println(product_Supplier);
		  }
	}
//---------------Book----------------------------------------------
	
	public List<BookDetails> readBookJson(String filename) throws JsonParseException,
	JsonMappingException, IOException {
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
List<BookDetails> bookDetailsList = objectMapper.readValue(
		new File(filename),
		objectMapper.getTypeFactory().constructCollectionType(List.class,
				BookDetails.class));
return bookDetailsList;
}
	

}
