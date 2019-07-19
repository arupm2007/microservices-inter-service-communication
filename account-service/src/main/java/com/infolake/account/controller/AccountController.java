package com.infolake.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infolake.account.service.Account;
import com.infolake.account.service.AccountService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(AccountController.REST)
public class AccountController {
	
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
	public static final String REST="/rest" ;
	
	@Autowired
	private AccountService accountService;
 
    @RequestMapping("/account/list")
    public List<Account> getCustomers() {
        return accountService.getAccounts();
    }
    
    @RequestMapping(value = "/account/{customerId}")
    public List<Account> getAccountsByCustomerId(@PathVariable("customerId") Integer customerId) {
    	logger.info("Method getAccountsByCustomerId is called");
        return accountService.getAccountByCustomerId(customerId);
    }
    
    @RequestMapping(value = "/account/{customerId}/{accountId}")
    public Account getAccountByCustomerIdAndAccountId(@PathVariable("customerId") Integer customerId,@PathVariable("accountId") Integer accountId) {
    	logger.info("Method getAccountByCustomerIdAndAccountId is called");
        return accountService.getAccountByCustomerIdAndAccountId(customerId,accountId);
    }

}
	


