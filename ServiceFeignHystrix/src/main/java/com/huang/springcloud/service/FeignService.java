package com.huang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", fallback = FeignServiceImpl.class) //指定调用哪个服务,和fallback的指定类
public interface FeignService {
	@RequestMapping("/hello")
	String helloFromClientOne(@RequestParam("name") String name);
}
