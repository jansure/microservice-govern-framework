package com.test.spring.cloud.service;


import org.springframework.stereotype.Component;

import com.test.spring.cloud.bean.User;

@Component
public class HelloServiceHiHystric implements FeignConsumerService{

	@Override
	public String hello2(String name) {
		// TODO Auto-generated method stub
		return "error in hello2, sorry " + name;
	}

	@Override
	public User hello3(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return "error";
	}

}
