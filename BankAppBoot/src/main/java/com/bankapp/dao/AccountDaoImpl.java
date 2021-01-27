package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.Account;
import com.bankapp.entity.TransactionLog;
import com.bankapp.exceptions.AccountNotFoundException;

@Repository
public class AccountDaoImpl implements AccountDao {

	private EntityManager em;
	
	
	@Autowired
	public AccountDaoImpl(EntityManager em) {
	
		this.em = em;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return em.createQuery(" from Account ").getResultList();
	}
//"select a.accountid,a.name,a.balance,a.address,a.phone,a.email from Account a")
	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		em.persist(account);
		return account;
		
		
	}

	@Override
	public Account delAccount(int accountId) {
		// TODO Auto-generated method stub
		Account accToDel=getaccountById(accountId);
		em.remove(accToDel);
		return accToDel;
		
	}

	@Override
	public Account getaccountById(int accountId) {
		// TODO Auto-generated method stub
		Account account=em.find(Account.class, accountId);
		if(account==null) 
			throw new AccountNotFoundException("account with id"+accountId+"not found");
			
		return account;
		
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		em.persist(account);
		return account;
		
		
	}

	@Override
	public Account updateAccount(int id, Account account) {
				Account accountToUpdate = getaccountById(id);
			accountToUpdate.setAddress(account.getAddress());
			accountToUpdate.setPhone(account.getPhone());
			accountToUpdate.setEmail(account.getEmail());
			em.persist(accountToUpdate);
			return accountToUpdate;
		}

	@Override
	public List<TransactionLog> getTransLogs(int id) {
		// TODO Auto-generated method stub
		List<TransactionLog> logs=em.createQuery("select a.transactionlog from Account a").getResultList();
		return logs;
	}

	}

