package com.test.spring.cloud.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.spring.cloud.bean.User;

//@RequestMapping("/refactor")
public interface HelloService {

//    @RequestMapping("/hello2")
    @PostMapping("/hello2")
    public String hello2(@RequestParam("name") String name);
    
//    @RequestMapping("/hello3")
    @PostMapping("/hello3")
    public User hello3(@RequestBody User user);
}