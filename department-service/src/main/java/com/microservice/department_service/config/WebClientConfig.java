package com.microservice.department_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.microservice.department_service.client.EmployeeClient;
import com.microservice.department_service.controller.DepartmentController;


@Configuration
public class WebClientConfig {

	private static final Logger log = LoggerFactory.getLogger(WebClientConfig.class);
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;


    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://employee-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public EmployeeClient employeeClient() {
    	log.debug("WebClientConfig1");
		HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(employeeWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }
}