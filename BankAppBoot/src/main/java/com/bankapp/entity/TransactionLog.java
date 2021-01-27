package com.bankapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="txlog_table")
public class TransactionLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer txId;
	private String txInfo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	private Double amount;
	
	
	private String txType;
	
	public Integer getTxId() {
		return txId;
	}
	public void setTxId(Integer txId) {
		this.txId = txId;
	}
	public String getTxInfo() {
		return txInfo;
	}
	public void setTxInfo(String txInfo) {
		this.txInfo = txInfo;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getTxType() {
		return txType;
	}
	public void setTxType(String txType) {
		this.txType = txType;
	}
	public TransactionLog() {}
	
	
	public TransactionLog(String txInfo, Double amount, String txType) {
		
		this.txInfo = txInfo;
		this.timestamp=new Date();
		this.amount = amount;
		this.txType = txType;
	}
	@Override
	public String toString() {
		return "TransactionLog [txId=" + txId + ", txInfo=" + txInfo + ", timestamp=" + timestamp + ", amount=" + amount
				+ ", txType=" + txType + "]";
	}
	
}
	