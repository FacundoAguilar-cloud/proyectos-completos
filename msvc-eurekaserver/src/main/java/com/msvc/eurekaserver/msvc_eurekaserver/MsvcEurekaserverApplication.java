package com.msvc.eurekaserver.msvc_eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MsvcEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcEurekaserverApplication.class, args);
	}

}
