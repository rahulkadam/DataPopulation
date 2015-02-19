package com.bluestone.bazarscan.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bluestone.bazarscan.dto.MobileDetails;
import com.bluestone.bazarscan.dto.Product_Header;
import com.bluestone.bazarscan.dto.Product_Line;
import com.bluestone.bazarscan.dto.Product_Spec_Grp_Lines;
import com.bluestone.bazarscan.dto.Product_Supplier;
import com.bluestone.bazarscan.dto.manufacturer;

public interface BazarScanDao {

	public long getRowCount(Class obj);
	public boolean isManufacturereExists(String mfgName);
	public void storeManufacturer(manufacturer manufactrer);
	public void storeProduct_header(Product_Header product_Header);
	public void storeProduct_supplier(Product_Supplier product_Supplier);
	public void storesubcategory(List<MobileDetails> productList);
	public void storeReviews(List<MobileDetails> productList);
	public boolean isProductExists(String productId);
	public String getManufacturerIdFromName(String productName);
	public void storeLineDetails(Product_Line product_Line);

	
	//group Line Detials
	public String getGroup_Line_Id(String Group_Line_Id);
	public String getGroup_Id(String Group_Id);
	
	public void updateProduct_header(Product_Header product_Header);
	public Map<Product_Spec_Grp_Lines, String> getGroup_Line();
	public Map<String,String> getGroups();

}
