package com.bankapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="account_table")
public class Account {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountid;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Double balance;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;
	
	
	private String accountType;
	
	
	@JsonIgnore
	
	@JoinColumn(name="acc_Id_fk")
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
	
	  private List<TransactionLog> transactionlog=new ArrayList<>();
	 
	
	//  private String accountStatus;
	  
 
	  
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	/*
	 * public String getAccountStatus() { return accountStatus; }
	 * 
	 * public void setAccountStatus(String accountStatus) { this.accountStatus =
	 * accountStatus; }
	 */
	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
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

	
	
	  public List<TransactionLog> getTransactionlog() { return transactionlog; }
	  
	  public void setTransactionlog(List<TransactionLog> transactionlog) {
	  this.transactionlog = transactionlog;
	  }
	 
	public Account() 
	{
		
	}
	

	//@Autowired
	public Account(String name, Double balance, String address, String phone, String email, String accountType) {
		
		this.name = name;
		this.balance = balance;
		this.address = address;
		this.phone = phone;
		this.email = email;
		
		this.accountType = accountType;
	}



	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", name=" + name + ", balance=" + balance + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + "]";
	}

	

	
	
	
	
	
	
}

	  