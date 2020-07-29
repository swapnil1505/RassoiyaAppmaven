package com.rasoiyya.dto.common;

import java.io.Serializable;

public class AddressResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	public AddressResponse() {
		
	}

	private String address_id;
	private String address_line1;
	private String address_line2;
	private String district;
	private String state;
	private String city;
	private String pin_code;
	private String address_type;
	private String geo_location;
	private String is_current_address;
	private String created_date;
	private String modified_date;
	private String created_by;
	private String modified_by;
	
	
	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public String getAddress_id() {
		return address_id;
	}
	
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public String getGeo_location() {
		return geo_location;
	}
	public void setGeo_location(String geo_location) {
		this.geo_location = geo_location;
	}
	public String getIs_current_address() {
		return is_current_address;
	}
	public void setIs_current_address(String is_current_address) {
		this.is_current_address = is_current_address;
	}
	@Override
	public String toString() {
		return "AddressResponse [address_id=" + address_id + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", district=" + district + ", state=" + state + ", city=" + city + ", pin_code="
				+ pin_code + ", address_type=" + address_type + ", geo_location=" + geo_location
				+ ", is_current_address=" + is_current_address + "]";
	}
}
