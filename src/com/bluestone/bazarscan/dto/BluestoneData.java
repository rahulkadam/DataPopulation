package com.bluestone.bazarscan.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BluestoneData {
	private String title[];
	private String product_code[];
	private String price[]; 
	private String sub_title[]; 
	private Map<String,String> price_breakup;
	private List<List<String>> metal_purity_options;
	private List<String> diamond_quality_options; 
	private Map<String,String> line_product_details;
	private Map<String,String> stone_details;
	private String metal_detail_type[];
	private String metal_detail_value[];
	private String url;
	public String[] getTitle() {
		return title;
	}
	public void setTitle(String[] title) {
		this.title = title;
	}
	public String[] getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String[] product_code) {
		this.product_code = product_code;
	}
	public String[] getPrice() {
		return price;
	}
	public void setPrice(String[] price) {
		this.price = price;
	}
	public String[] getSub_title() {
		return sub_title;
	}
	public void setSub_title(String[] sub_title) {
		this.sub_title = sub_title;
	}
	public Map<String, String> getPrice_breakup() {
		return price_breakup;
	}
	public void setPrice_breakup(Map<String, String> price_breakup) {
		this.price_breakup = price_breakup;
	}
	public List<List<String>> getMetal_purity_options() {
		return metal_purity_options;
	}
	public void setMetal_purity_options(List<List<String>> metal_purity_options) {
		this.metal_purity_options = metal_purity_options;
	}
	public List<String> getDiamond_quality_options() {
		return diamond_quality_options;
	}
	public void setDiamond_quality_options(List<String> diamond_quality_options) {
		this.diamond_quality_options = diamond_quality_options;
	}
	public Map<String, String> getLine_product_details() {
		return line_product_details;
	}
	public void setLine_product_details(Map<String, String> line_product_details) {
		this.line_product_details = line_product_details;
	}
	public Map<String, String> getStone_details() {
		return stone_details;
	}
	public void setStone_details(Map<String, String> stone_details) {
		this.stone_details = stone_details;
	}
	public String[] getMetal_detail_type() {
		return metal_detail_type;
	}
	public void setMetal_detail_type(String[] metal_detail_type) {
		this.metal_detail_type = metal_detail_type;
	}
	public String[] getMetal_detail_value() {
		return metal_detail_value;
	}
	public void setMetal_detail_value(String[] metal_detail_value) {
		this.metal_detail_value = metal_detail_value;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "\n\nBluestoneData [title=" + Arrays.toString(title)
				+ ", product_code=" + Arrays.toString(product_code)
				+ ", price=" + Arrays.toString(price) + ", sub_title="
				+ Arrays.toString(sub_title) + ", price_breakup="
				+ price_breakup + ", metal_purity_options="
				+ metal_purity_options + ", diamond_quality_options="
				+ diamond_quality_options + ", line_product_details="
				+ line_product_details + ", stone_details=" + stone_details
				+ ", metal_detail_type=" + Arrays.toString(metal_detail_type)
				+ ", metal_detail_value=" + Arrays.toString(metal_detail_value)
				+ ", url=" + url + "]";
	}
	
}