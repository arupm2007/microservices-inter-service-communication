package com.infolake.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
	
    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);
    
    private List<Customer> customers;
    
  
    public CustomerService() {
        customers = new ArrayList<>();
        customers.add(new Customer("Adam",1,"35 K.N.Road,Delhi,India","9874050505","writetome@gmail.com,","Regular"));
        customers.add(new Customer("Shaheen",2,"35 K.D.Road,Delhi,India","9874050507","write2me@gmail.com,","Regular"));
        customers.add(new Customer("Kanu",2,"35 K.D.S.Road,Delhi,India","9874050509","writeme@gmail.com,","Premium"));
    }
 
    public List<Customer> getCustomers() {
    	logger.info("Method getCustomers() is called.");
    	return customers;
    }
    
   public Customer getCustomerById(Integer customerId) {
	   logger.info("Method getCustomerById() is called.");
	   logger.info("Get customer by ID :"+ customerId );
	   List<Customer> custList= customers.stream().filter(o -> o.getCustomerId().equals(customerId)).collect(Collectors.toList());
	   return custList.isEmpty()? null :custList.get(0); 
    }
}
	


