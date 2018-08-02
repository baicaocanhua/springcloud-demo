package com.huang.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huang.springcloud.service.FeignService;

@RestController
public class FeignController {
	
	@Autowired
	private FeignService feignService;
	
	@GetMapping("/hi")
	public String hello(@RequestParam("name") String name) {
		return feignService.helloFromClientOne(name);
	}
}
