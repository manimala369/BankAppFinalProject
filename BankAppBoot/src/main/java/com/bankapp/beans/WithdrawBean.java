package com.bankapp.beans;

public class WithdrawBean {

	private int accountId;
	private double amount;
	
	public WithdrawBean() {}

	public WithdrawBean(int accountId, double amount) {
		
		this.accountId = accountId;
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	
}
