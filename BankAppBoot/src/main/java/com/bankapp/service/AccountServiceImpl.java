package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.AccountDao;
import com.bankapp.entity.Account;
import com.bankapp.entity.TransactionLog;
import com.bankapp.entity.TxType;


@Service(value="as")
@Transactional
public class AccountServiceImpl implements AccountService{

	
	private AccountDao accountDao;
	
	private TransactionLogService transactionLogService;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao, TransactionLogService transactionLogService) {
	
		this.accountDao = accountDao;
		this.transactionLogService = transactionLogService;
	}


	
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountDao.getAllAccounts();
	}

	@Override
	public void deposit(int accountId, double amount) {
		// TODO Auto-generated method stub
		Account account=accountDao.getaccountById(accountId);
		account.setBalance(account.getBalance()+amount);
		accountDao.updateAccount(account);
		account.getTransactionlog().add(transactionLogService.addTransactionLog(accountId,"deposit amount", amount , "DEPOSIT"));
		
	}

	@Override
	public void withdraw(int accountId, double amount) {
		// TODO Auto-generated method stub
		
		Account account=accountDao.getaccountById(accountId);
		account.setBalance(account.getBalance()-amount);
		accountDao.updateAccount(account);
		//transactionLogService.addTransactionLog(accountId,"withdraw amount", amount , TxType.WITHDRAW);
		account.getTransactionlog().add(transactionLogService.addTransactionLog(accountId,"withdraw amount", amount , "WITHDRAW")); 
	}
	
	

	@Override
	public void updateAccount(int id, Account account) {
		
		accountDao.updateAccount(id,account);
		
	}

	@Override
	public Account delAccount(int accountId) {
		// TODO Auto-generated method stub
		return accountDao.delAccount(accountId);
	}

	@Override
	public Account getaccountById(int accountId) {
		// TODO Auto-generated method stub
		return accountDao.getaccountById(accountId);
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.addAccount(account);
	}



	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) {
		// TODO Auto-generated method stub
		Account frmAcc=accountDao.getaccountById(fromAccountId);
		Account toAcc=accountDao.getaccountById(toAccountId);
		
		frmAcc.setBalance(frmAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		
		accountDao.updateAccount(frmAcc);
		accountDao.updateAccount(toAcc);
		
		frmAcc.getTransactionlog().add(transactionLogService.addTransactionLog(fromAccountId,"transfered amount", amount , "TRANSFER"));
		toAcc.getTransactionlog().add(transactionLogService.addTransactionLog(toAccountId,"received amount", amount , "CREDITED"));
		
	}



	@Override
	public List<TransactionLog> getTransLogs(int id) {
		// TODO Auto-generated method stub
		return accountDao.getTransLogs(id);
	}
	
	
	
}