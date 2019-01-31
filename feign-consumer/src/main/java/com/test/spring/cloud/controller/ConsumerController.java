package com.test.spring.cloud.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.spring.cloud.bean.User;
import com.test.spring.cloud.service.FeignConsumerService;

@RestController
public class ConsumerController {

	private final Logger logger = Logger.getLogger(ConsumerController.class);

	@Resource
	private FeignConsumerService consumerService;

	@GetMapping("/feign-consumer")
	public String index() {

		return consumerService.hello();
	}
	
	@GetMapping("/feign-consumer-user")
    public String feignConsumer(String name) {
		System.out.println(name);
		return consumerService.hello2(name);
    }
	
	@GetMapping("/feign-consumer-user2")
    public User feignConsumer2(User user) {
		System.out.println(user);
        consumerService.hello2(user.getName());
        return consumerService.hello3(user);
    }

}
