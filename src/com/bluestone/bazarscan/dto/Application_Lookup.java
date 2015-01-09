package com.bluestone.bazarscan.dto;

public class Application_Lookup {
	public String lookip_id; 
	public String description;
	public String meaning;
	public String getLookip_id() {
		return lookip_id;
	}
	public void setLookip_id(String lookip_id) {
		this.lookip_id = lookip_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	@Override
	public String toString() {
		return "Application_Lookup [lookip_id=" + lookip_id + ", description="
				+ description + ", meaning=" + meaning + "]";
	}
	
	

}
