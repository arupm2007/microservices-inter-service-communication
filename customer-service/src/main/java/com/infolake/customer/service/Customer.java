package com.infolake.customer.service;

public class Customer {
	
	private String customerName;
	
	private Integer customerId;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private String type;
	
	public Customer() {}
	
	public Customer(String customerName,Integer customerId,String address,String phone,String email,String type) {		
		
		this.customerName = customerName;
		this.customerId=customerId;
		this.address=address;
		this.phone = phone;
		this.email=email;
		this.type=type;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
