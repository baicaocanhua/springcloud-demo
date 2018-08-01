package com.huang.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huang.springcloud.service.HelloService;

@RestController
public class HelloController {
	
	 @Autowired
	 private HelloService helloService;
	 
	 @GetMapping("/hi")
	 public String hello(@RequestParam("name") String name) {
		 System.out.println("ServiceRibbon.");
		 return helloService.helloService(name);
	 }
}
