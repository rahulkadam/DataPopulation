package com.bluestone.bazarscan.dao;

import java.util.List;
import java.util.Set;

import com.bluestone.bazarscan.dto.Product;
import com.bluestone.bazarscan.dto.Product_Header;
import com.bluestone.bazarscan.dto.Product_Supplier;
import com.bluestone.bazarscan.dto.manufacturer;

public interface BazarScanDao {

	public long getRowCount(Class obj);
	public boolean isManufacturereExists(String mfgName);
	public void storeManufacturer(manufacturer manufactrer);
	public void storeProduct_header(Product_Header product_Header);
	public void storeProduct_supplier(Product_Supplier product_Supplier);
	public void storesubcategory(List<Product> productList);
	public void storeReviews(List<Product> productList);
	public boolean isProductExists(String product_name,String modelId);
	public String getManufacturerIdFromName(String productName);

	
}
