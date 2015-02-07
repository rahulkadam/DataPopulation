package com.bluestone.bazarscan.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_SPEC_GRPS")
public class Product_Spec_Grps {

	@Id
	@Column(name="GROUP_ID")
	private String groupId;
	@Column(name="SEPECIFICATION_GROUP")	
	private String specificationGroup;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSpecificationGroup() {
		return specificationGroup;
	}
	public void setSpecificationGroup(String specificationGroup) {
		this.specificationGroup = specificationGroup;
	}
	@Override
	public String toString() {
		return "PRODUCT_SPEC_GRPS [groupId=" + groupId
				+ ", specificationGroup=" + specificationGroup + "]";
	}
	
	
}
