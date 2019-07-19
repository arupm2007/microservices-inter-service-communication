package com.infolake.customer.service;

public class Account {
	
	private Integer customerId;
	
	private Integer accountId;
	
	private String accountType;
	
	private String balance;
	
	private String currencyCode;
	
	public Account() {}
	
	public Account(Integer customerId,Integer accountId,String accountType,String balance,String currencyCode) {		
		
		this.customerId = customerId;
		this.accountId=accountId;
		this.accountType=accountType;
		this.balance = balance;
		this.currencyCode=currencyCode;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	
	
}
