package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.Account;
import com.bankapp.entity.TransactionLog;
import com.bankapp.entity.TxType;

@Repository
public class TransactionLogDaoImpl implements TransactionLogDao{

	
	private EntityManager em;
	
	
	
	@Autowired
	public TransactionLogDaoImpl(EntityManager em) {
		
		this.em = em;
	}

	@Override
	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount,String txType) {
		// TODO Auto-generated method stub
		TransactionLog log=new TransactionLog(txInfo,amount,txType);
		em.persist(log);
		return log;
	}

	
	@Override
	public List<TransactionLog> getTransactionLogs() {
		// TODO Auto-generated method stub
		return em.createQuery("from TransactionLog").getResultList();
		
	}

	@Override
	public TransactionLog TransactionLogById(int id) {
		TransactionLog log=em.find(TransactionLog.class, id);
		return log;
		
		
		
		
	}
	
}