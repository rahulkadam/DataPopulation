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
	@Override
	public int hashCode() {
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product_Spec_Grp_Lines other = (Product_Spec_Grp_Lines) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (specificationName == null) {
			if (other.specificationName != null)
				return false;
		} else if (!specificationName.equals(other.specificationName))
			return false;
		return true;
	}
	
	

	
	
}
