package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.TransactionLogDao;
import com.bankapp.entity.TransactionLog;
import com.bankapp.entity.TxType;


@Service
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService{

	private TransactionLogDao txLogDao;
	
	
	@Autowired
	public TransactionLogServiceImpl(TransactionLogDao txLogDao) {
		
		this.txLogDao = txLogDao;
	}

	@Override
	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, String txType) {
		// TODO Auto-generated method stub
		return txLogDao.addTransactionLog(accountId,txInfo, amount, txType);
	}

	@Override
	public List<TransactionLog> getTransactionLogs() {
		// TODO Auto-generated method stub
		return txLogDao.getTransactionLogs();
	}

	@Override
	public TransactionLog TransactionLogById(int id) {
		// TODO Auto-generated method stub
		return txLogDao.TransactionLogById(id);
	}

}