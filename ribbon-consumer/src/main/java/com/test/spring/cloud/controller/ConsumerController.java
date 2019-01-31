package com.test.spring.cloud.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.spring.cloud.service.HelloService;

@RestController
public class ConsumerController {

	private final Logger logger = Logger.getLogger(ConsumerController.class);

	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private HelloService helloService;

	@GetMapping("/ribbon-consumer1")
	public String index() {

		return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
	}

	@RequestMapping(value = "ribbon-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		
		return helloService.helloService();
	}

}
