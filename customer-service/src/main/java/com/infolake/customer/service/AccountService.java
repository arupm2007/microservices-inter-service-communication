package com.infolake.customer.service;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Configuration
@Component
public class AccountService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	@Value("${account.service.name}")
	private String serviceName;
	
	private static final String ACCOUNT_BY_CUSTOMER_URI ="/rest/account/";
	private static final String PROTOCOL_HTTP ="http://";
	
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);
			
	/**
	 * This function is used to call account service remotely
	 * format
	 */
	 public List<Account> getAccountByCustomerId(String customerId) {
		
		String replaceURI = ACCOUNT_BY_CUSTOMER_URI+ customerId;
		logger.info("URL after replacement :" + replaceURI);
		
		//get full service url
		String url = getServiceURL(serviceName, replaceURI);
		
		logger.info("Full URL :" + url);
		
		return doRemoteRESTCall(url);
	}
	
	
	/**
     * This method is used for calling account service on service registry
     * @param url
     * @return List<Account>
     */
	 private List<Account> doRemoteRESTCall(String url) {

		try {

			ResponseEntity<List<Account>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Account>>() {
					});
			return response.getBody();

		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
		return Collections.emptyList();
	  }
	
	

	/**
	 * This method enquire the service registry the fetch the url
	 * 
	 * @param serviceName
	 * @return String
	 */
	private String getServiceURL(String serviceName, String uri) {

		//query based on service registry
		Application application = eurekaClient.getApplication(serviceName);

		if (application != null && !application.getInstances().isEmpty()) {

			InstanceInfo instanceInfo = application.getInstances().get(0);
			String hostname = instanceInfo.getHostName();
			int port = instanceInfo.getPort();

			return PROTOCOL_HTTP.concat(hostname).concat(":") + port + uri;
		}

		if (logger.isDebugEnabled()) {
			logger.warn(MessageFormat.format(
					"Service {0} is not registered with eureka or may be down", serviceName));
		}

		return null;
	}

}
