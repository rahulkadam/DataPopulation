package com.bluestone.bazarscan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_SPEC_GRP_LINES")
public class Product_Spec_Grp_Lines {
	@Id
	@Column(name="GROUP_LINE_ID")
	private String groupLineId;
	@Column(name="SPECIFICATION_NAME")
	private String specificationName;
	@Column(name="GROUP_ID")
	private String groupId;
	public String getGroupLineId() {
		return groupLineId;
	}
	public void setGroupLineId(String groupLineId) {
		this.groupLineId = groupLineId;
	}
	public String getSpecificationName() {
		return specificationName;
	}
	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	@Override
	public String toString() {
		return "Product_Spec_Grp_Lines [groupLineId=" + groupLineId
				+ ", specificationName=" + specificationName + ", groupId="
				+ groupId + "]";
	}

	
	
}
