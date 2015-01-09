package com.bluestone.bazarscan.dto;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="MANUFACTURER")
public class manufacturer {
	@Id 
	@Column(name="MFG_ID")
	public String mfg_id;
	@Column(name="NAME")
	public String mfg_name;
	public String getMfg_id() {
		return mfg_id;
	}
	public void setMfg_id(String mfg_id) {
		this.mfg_id = mfg_id;
	}
	public String getMfg_name() {
		return mfg_name;
	}
	public void setMfg_name(String mfg_name) {
		this.mfg_name = mfg_name;
	}
	@Override
	public String toString() {
		return "manufacturer [mfg_id=" + mfg_id + ", mfg_name=" + mfg_name
				+ "]";
	}
	

}
