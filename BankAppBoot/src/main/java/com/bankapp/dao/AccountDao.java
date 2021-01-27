package com.bankapp.dao;

import java.util.List;

import com.bankapp.entity.Account;
import com.bankapp.entity.TransactionLog;

public interface AccountDao {

	public List<Account> getAllAccounts();
	public Account updateAccount(Account account);
	public Account updateAccount(int id,Account account);
	public Account delAccount(int accountId);
	public Account getaccountById(int accountId);
	public Account addAccount(Account account);
	public List<TransactionLog> getTransLogs(int id);
}