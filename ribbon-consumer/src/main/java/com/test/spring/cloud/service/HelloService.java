package com.test.spring.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService() {

		long beginTime = System.currentTimeMillis();
		String body = restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
		long endTime = System.currentTimeMillis();
		System.out.println("Spend Time : " + (endTime - beginTime));

		return body;
	}

	public String helloFallback() {
		return "error";
	}
}