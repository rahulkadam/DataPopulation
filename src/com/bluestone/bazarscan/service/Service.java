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

import com.bluestone.bazarscan.dao.impl.BazarScanImpl;
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
	
	

	public BazarScanImpl bazarScanImpl=BazarScanImpl.getInstance();
	
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
		bazarScanImpl.storeManufacturer(manufacturerList);
	}

	public void storeProduct_header(List<Product> productList) {
		bazarScanImpl.storeProduct_header(productList);
		}

	public void storeProduct_supplier(List<Product> productList) {
		bazarScanImpl.storeProduct_supplier(productList);

	}

	public void storesubcategory(List<Product> productList) {

	}

	public void storeReviews(List<Product> productList) {

	}


}
