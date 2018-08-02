package com.huang.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	
	//注入ioc容器的restTemplate来消费eureka-client服务的“/hello”接口
	@Autowired
	public RestTemplate restTemplate;
	
	//对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
	@HystrixCommand(fallbackMethod = "helloError")
	public String helloService(String name) {
		//调用服务接口
		//用服务名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
		return restTemplate.getForObject("http://eureka-client/hello?name=" + name, String.class);
	}
	
	public String helloError(String name) {
		return "hi," + name + ",sorry,error!";
	}
}
