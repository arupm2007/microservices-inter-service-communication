# microservices-inter-service-communication
Micro-services inter service communication based on Feign Client and Rest Template

This example shows both the approach 

1. Inter service communication using Rest Template
2. Inter service communication using declarative Feign Client

How to run the sample projects? 
  1. Download source code from the Github link source code
  2. Import all the three projects into Eclipse as Gradle project.
  3. Refresh Gradle project if any compilation error.
  4. Start microservice customer-service by running the class CustomerServiceApplication.java
  5. Run the class AccountServiceApplication.java of the microservice account-service and it will be started.
  6. Start microservice api-gateway-zuul by running the class ApiGatewayApplication.java. Running this service is optional and you can ignore it.
  7. Now all the services are up and running.
  
  Example–
    A. account-service has a rest API called getAccountsByCustomerById(Integer customerId).
    B. This service will return all the accounts of an existing customer in a JSON array format.
    C. The actual implementation of the service is in the account-service.
    D. Customer-service internally calls account service and return the result.
    E. Call the service by using any of the REST clients, say web browser.
    
    
    
GET htttp://localhost:8080/customer-service/rest/feign/customer/account/1
Once a call is made on api-gateway-zuul service , it will check the routing path and forward it to the mapped destination. 

In this case routing path is /customer-service/** and the routing destination ishttp://localhost:8081/customer-service/rest/feign/customer/account/1 
customer-service interanlly call account-service and will return the result.

Similarly , you can same account detail using REST client. For example –
GET htttp://localhost:8080/customer-service/rest/customer/account/1
It will return all the available accounts in a JSON format. 
