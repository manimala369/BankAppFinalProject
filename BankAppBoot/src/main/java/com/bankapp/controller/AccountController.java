package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.AuthResponse;
import com.bankapp.beans.DepositBean;
import com.bankapp.beans.TransferBean;
import com.bankapp.beans.WithdrawBean;
import com.bankapp.entity.Account;
import com.bankapp.entity.TransactionLog;
import com.bankapp.service.AccountService;
import com.bankapp.service.TransactionLogService;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	private AccountService accountService;
	private TransactionLogService transactionLogService;

	
	@Autowired
	public AccountController(AccountService accountService, TransactionLogService transactionLogService) {
		
		this.accountService = accountService;
		this.transactionLogService = transactionLogService;
	}


	//http://localhost:8081/bankapp/account
	
		@GetMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Account> allAccounts(){
			List<Account> accounts=accountService.getAllAccounts();
			return accounts;
		}
		
	
	@GetMapping(path = "account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account getAnAccount(@PathVariable(name = "accountId") int id){
		Account account=accountService.getaccountById(id);
		return account;
	}
	 
	@PostMapping(path="account", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public Account addAccount( @RequestBody Account account) {
		Account acc=accountService.addAccount(account);
		return acc;
	}
	
	
	
	
	@PutMapping(path="account/{accountId}", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public void updateAccount(@PathVariable(name = "accountId") int id,
			@RequestBody Account account) {
		accountService.updateAccount(id, account);
		
	}

	@DeleteMapping(path = "account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account deleteAnAccount(@PathVariable(name = "accountId") int id){
		Account account=accountService.delAccount(id);
		return account;
	}
	@PostMapping(path="account/transfer", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public String transferFund( @RequestBody TransferBean bean) {
		accountService.transfer(bean.getFromAccountId(), bean.getToAccountId(), bean.getAmount());
		return "fund transfered succesfully!";
	}
	
	@PostMapping(path="account/deposit", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public String deposit( @RequestBody DepositBean dbean) {
		accountService.deposit(dbean.getAccountId(),dbean.getAmount());
		return "amount deposited";
	}
	
	@PostMapping(path="account/withdraw", produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE )
	    public String withdraw( @RequestBody WithdrawBean wbean) {
		accountService.withdraw(wbean.getAccountId(),wbean.getAmount());
		return "withdraw successfull";
	}
	@GetMapping(path = "account/trans/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransactionLog> Transactions(@PathVariable(name = "id") int id){
		return accountService.getTransLogs(id);
		
	}
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public AuthResponse validateLogin() {
			return new AuthResponse("User successfully authenticated");
	}
		
}
