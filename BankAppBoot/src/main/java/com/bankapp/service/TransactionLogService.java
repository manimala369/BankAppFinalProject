package com.bankapp.service;

import java.util.List;

import com.bankapp.entity.TransactionLog;
import com.bankapp.entity.TxType;

public interface TransactionLogService {

	public TransactionLog addTransactionLog(int accountId,String txInfo,Double amount,String txType);
	public List<TransactionLog> getTransactionLogs();
	public TransactionLog TransactionLogById(int id);
	
}