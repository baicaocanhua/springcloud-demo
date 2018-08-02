package com.huang.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huang.springcloud.service.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	private HelloService helloService;
//	@Value("${aaa}")  //不用加载配置时将这句话注释掉即可，要就加上
	String aaa;

	@GetMapping("/hi")
	public String hello(@RequestParam("name") String name) {
		System.out.println("ServiceRibbon.");
		System.out.println("配置文件中的aaa=" + aaa);
	    return helloService.helloService(name);
	}
}
