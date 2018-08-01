package com.huang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client") //指定调用哪个服务
public interface FeignService {
	@RequestMapping("/hello")
	String helloFromClientOne(@RequestParam("name") String name);
}
