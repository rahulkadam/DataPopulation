package com.bluestone.bazarscan.dto;

import org.hibernate.annotations.Entity;

@Entity
public class Sub_Category {
	
	public String sub_category_id;
	public String name;
	public String category_lookup_id;
	public String getSub_category_id() {
		return sub_category_id;
	}
	public void setSub_category_id(String sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory_lookup_id() {
		return category_lookup_id;
	}
	public void setCategory_lookup_id(String category_lookup_id) {
		this.category_lookup_id = category_lookup_id;
	}
	@Override
	public String toString() {
		return "Sub_Category [sub_category_id=" + sub_category_id + ", name="
				+ name + ", category_lookup_id=" + category_lookup_id + "]";
	}
	
	

}
