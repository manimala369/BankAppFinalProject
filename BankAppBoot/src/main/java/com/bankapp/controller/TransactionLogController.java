package com.bankapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entity.TransactionLog;
import com.bankapp.service.TransactionLogService;

//@CrossOrigin(origins = "http://localhost:4200")

@CrossOrigin(origins = "*")

@RestController
public class TransactionLogController {

	
	private TransactionLogService  transactionLogService;

	@Autowired
	public TransactionLogController(TransactionLogService transactionLogService) {
		
		this.transactionLogService = transactionLogService;
		
	}
	
	@GetMapping("transactions")
	public List<TransactionLog> transactions() {
		List<TransactionLog> logs=transactionLogService.getTransactionLogs();
		return logs;
	}
	
	@GetMapping("transactions/{id}")
	public TransactionLog accTransactions(@PathVariable("id") int id) {
		TransactionLog log=transactionLogService.TransactionLogById(id);
		return log;
	}
}
