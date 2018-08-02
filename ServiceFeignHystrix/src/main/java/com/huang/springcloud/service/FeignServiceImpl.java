package com.huang.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

	@Override
	public String helloFromClientOne(String name) {
		return "sorry " + name;
	}

}
