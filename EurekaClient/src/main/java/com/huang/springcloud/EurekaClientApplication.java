package com.huang.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run( EurekaClientApplication.class, args );
	}
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hello")
	public String hello(@RequestParam("name") String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		return name + ",from port: " + port;
	}
}
