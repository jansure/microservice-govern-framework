package com.test.spring.cloud.controller;

import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.cloud.bean.User;
import com.test.spring.cloud.service.HelloService;

@RestController
public class HelloController implements HelloService{

	private final Logger logger = Logger.getLogger(HelloController.class);
	
	@Resource
	private DiscoveryClient client;
	
	@GetMapping("/hello")
	public String index() {
		
		ServiceInstance instance = client.getLocalServiceInstance();
		
		// 让处理线程等待几秒钟
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:"+sleepTime);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		logger.info("hello host:" + instance.getHost() + " ,serverId:" + instance.getServiceId());
		return "Hello Word!";
	}

	@Override
	public String hello2(@RequestParam("name") String name) {
		
		int[] array = {2300, 1400, 900};
		int index = new Random().nextInt(3);
		logger.info("sleepTime:" + array[index]);
		// 让处理线程等待几秒钟
        try {
            Thread.sleep(array[index]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("hello2...");
		return "hello:" + name;
	}

	@Override
	public User hello3(@RequestBody User user) {
		return user;
	}
	
}
