package com.bluestone.bazarscan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_LINES")
public class Product_Line {
	@Id 
    @Column(name = "PRODUCT_LINE_ID")
	private String product_Line_Id;
    @Column(name = "VALUE")
	private String value;
    @Column(name = "SUMMARY")
	private String summary; 
    @Column(name = "PRODUCT_ID")
	private String product_Id;
    @Column(name = "GROUP_ID")
	private String group_Id;
    @Column(name = "GROUP_LINE_ID")
	private String group_Line_Id;
	public String getProduct_Line_Id() {
		return product_Line_Id;
	}
	public void setProduct_Line_Id(String product_Line_Id) {
		this.product_Line_Id = product_Line_Id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}
	public String getGroup_Id() {
		return group_Id;
	}
	public void setGroup_Id(String group_Id) {
		this.group_Id = group_Id;
	}
	public String getGroup_Line_Id() {
		return group_Line_Id;
	}
	public void setGroup_Line_Id(String group_Line_Id) {
		this.group_Line_Id = group_Line_Id;
	}
	@Override
	public String toString() {
		return "Product_Line [product_Line_Id=" + product_Line_Id + ", value="
				+ value + ", summary=" + summary + ", product_Id=" + product_Id
				+ ", group_Id=" + group_Id + ", group_Line_Id=" + group_Line_Id
				+ "]";
	}

}
