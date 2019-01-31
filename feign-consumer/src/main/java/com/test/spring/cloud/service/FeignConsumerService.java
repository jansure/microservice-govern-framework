package com.test.spring.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "hello-service", fallback = HelloServiceHiHystric.class)
public interface FeignConsumerService extends HelloService {
 
	@GetMapping("/hello")
	String hello();

}