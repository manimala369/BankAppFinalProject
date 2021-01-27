package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entity.Account;
import com.bankapp.entity.AccountType;
import com.bankapp.entity.Employee;
import com.bankapp.entity.TransactionLog;
import com.bankapp.entity.TxType;
import com.bankapp.service.AccountService;
import com.bankapp.service.EmployeeService;
import com.bankapp.service.TransactionLogService;

@SpringBootApplication
public class BankAppBootApplication implements CommandLineRunner{

	@Autowired
	private AccountService as;
	@Autowired
	private TransactionLogService ts;
	
	@Autowired
	private EmployeeService es;
	
	public static void main(String[] args) {
		SpringApplication.run(BankAppBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Account a=new Account("mani", 6000.00, "bvrm","9803869146", "mani@g.com",
		 * AccountType.SAVINGS); //as.addAccount(a); Account a1=new Account("vedu",
		 * 7000.00, "rjy","789890567", "m@g.com", AccountType.SAVINGS);
		 * //as.addAccount(a1); Account a2=new Account("vinne", 8000.00,
		 * "vjy","543897890", "v@t.com", AccountType.SAVINGS); //as.addAccount(a2);
		 * Account a3=new Account("hema", 7000.00, "vjy","8456789345", "g@g.com",
		 * AccountType.SAVINGS); //as.addAccount(a3);
		 * 
		 * TransactionLog t=new TransactionLog("txInfo",100.00, TxType.DEPOSIT);
		 * a.getTransactionlog().add(t); as.addAccount(a);
		 */
		/*
		 * Employee e1=new Employee("mani", "mani1368", new String[]
		 * {"ROLE_MGR","ROLE_EMP"}); Employee e2=new Employee("vedu", "vedu123", new
		 * String[] {"ROLE_EMP"}); Employee e3=new Employee("vinne", "vinne456", new
		 * String[] {"ROLE_EMP"});
		 * 
		 * es.addUser(e1); es.addUser(e2); es.addUser(e3);
		 * 
		 * System.out.println("employess added");
		 */
		
		 
	}

}
