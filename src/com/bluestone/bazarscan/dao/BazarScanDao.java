package com.bluestone.bazarscan.dao;

import java.util.List;

import com.bluestone.bazarscan.dto.Product;

public interface BazarScanDao {

	public long getRowCount(Class obj);
	public boolean isManufacturereExists(String mfgName);
	public void storeManufacturer(List<Product> productList);
	public void storeProduct_header(List<Product> productList);
	public void storeProduct_supplier(List<Product> productList);
	public void storesubcategory(List<Product> productList);
	public void storeReviews(List<Product> productList);
	
}
