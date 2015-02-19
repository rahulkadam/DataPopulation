package com.bluestone.bazarscan.dto;


import javax.persistence.*;

@Entity
@Table(name="PRODUCT_HEADER")
public class Product_Header {
	@Id 
    @Column(name = "PRODUCT_ID")
	public String id;        
	@Column(name = "SUB_CATEGORY_ID")
	public String sub_category;  
	@Column(name = "MFG_MODEL_ID")
	public String mfg_model_id; 
	@Column(name = "COLOR")
	public String product_color;  
	@Column(name = "MFG_ID")
	public String mfg_id;
	@Column(name = "NAME")
	public String product_name;
	@Column(name = "HEIGHT")
	public String height;
	@Column(name = "WIDTH")
	public String width;
	@Column(name = "WEIGHT")
	public String weight;
	@Column(name = "SUB_TITLE")
	public String sub_title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSub_category() {
		return sub_category;
	}
	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}
	public String getMfg_model_id() {
		return mfg_model_id;
	}
	public void setMfg_model_id(String mfg_model_id) {
		this.mfg_model_id = mfg_model_id;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public String getMfg_id() {
		return mfg_id;
	}
	public void setMfg_id(String mfg_id) {
		this.mfg_id = mfg_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	@Override
	public String toString() {
		return "Product_Header [id=" + id + ", sub_category=" + sub_category
				+ ", mfg_model_id=" + mfg_model_id + ", product_color="
				+ product_color + ", mfg_id=" + mfg_id + ", product_name="
				+ product_name + ", height=" + height + ", width=" + width
				+ ", weight=" + weight + ", sub_title=" + sub_title + "]";
	}
	
}
