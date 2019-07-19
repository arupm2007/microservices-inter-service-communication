package com.infolake.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountService {
	
    private static Logger logger = LoggerFactory.getLogger(AccountService.class);
    
    private List<Account> customers;
    
  
    public AccountService() {
        customers = new ArrayList<>();
        customers.add(new Account(1,1,"Domestic","10000","INR"));
        customers.add(new Account(1,2,"Domestic","1000000","INR"));
        customers.add(new Account(2,1,"Domestic","100000","INR"));
        customers.add(new Account(3,1,"NRI","100000000","INR"));
    }
 
    public List<Account> getAccounts() {
    	logger.info("Method getAccounts() is called.");
    	return customers;
    }
    
   public List<Account> getAccountByCustomerId(Integer customerId) {
	   logger.info("Method getAccountByCustomerId() is called.");
	   logger.info("Get customer by ID :"+ customerId );
	   return customers.stream().filter(o -> o.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }
   
   public Account getAccountByCustomerIdAndAccountId(Integer customerId,Integer accountId) {
	   logger.info("Method getAccountByCustomerIdAndAccountId() is called.");
	   List<Account> custList= customers.stream().filter(o -> (o.getCustomerId().equals(customerId) && o.getAccountId().equals(accountId))).collect(Collectors.toList());
	   return custList.isEmpty()? null :custList.get(0); 
    }
}
	


