package com.bluestone.bazarscan.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.bluestone.bazarscan.dao.impl.BazarScanDaoImpl;
import com.bluestone.bazarscan.dto.Product;
import com.bluestone.bazarscan.dto.Product_Header;
import com.bluestone.bazarscan.dto.Product_Supplier;
import com.bluestone.bazarscan.dto.manufacturer;
import com.bluestone.bazarscan.util.Utility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {
	
	

	public BazarScanDaoImpl bazarScanImpl=BazarScanDaoImpl.getInstance();
	
	public List<Product> readjson(String filename) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Product> st = obj.readValue(
				new File(filename),
				obj.getTypeFactory().constructCollectionType(List.class,
						Product.class));
		return st;

	}
	
	//To store manufacturer List in DB
	public void storeManufacturer(List<Product> productList) {
		Set<String> manufacturerList = new TreeSet<String>();
		for (Product product : productList) {
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

	public void storeProduct_header(List<Product> productList) {

		for (Product product : productList) {
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
	public void storeProduct_supplier(List<Product> productList) {
		
		for (Product product : productList) {
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

	public void storesubcategory(List<Product> productList) {

	}

	public void storeReviews(List<Product> productList) {

	}


}
