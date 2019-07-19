package com.infolake.customer.service;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="account-service" )//Service Id of account service
public interface AccountServiceProxy {
	
	 @RequestMapping("/rest/account/{customerId}")
	 public Collection<Account> getAccountByCustomerId(@PathVariable("customerId") Integer customerId);

}
