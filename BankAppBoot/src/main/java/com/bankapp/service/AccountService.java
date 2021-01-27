package com.bankapp.service;

import java.util.List;

import com.bankapp.entity.Account;
import com.bankapp.entity.TransactionLog;

public interface AccountService {

	public List<Account> getAllAccounts();
	public void deposit(int accountId,double amount);
	public void withdraw(int accountId,double amount);
	public void transfer(int fromAccountId,int toAccountId,double amount);
	public void updateAccount(int id,Account account);
	public Account delAccount(int accountId);
	public Account getaccountById(int accountId);
	public Account addAccount(Account account);
	public List<TransactionLog> getTransLogs(int id);
}