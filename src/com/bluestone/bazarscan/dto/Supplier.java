package com.bluestone.bazarscan.dto;

public class Supplier {
	public String supplier_id;
	public String contact_id;
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getContact_id() {
		return contact_id;
	}
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", contact_id="
				+ contact_id + "]";
	}

	
}
