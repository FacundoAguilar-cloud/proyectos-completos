package com.msvc.students.msvc_students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class MsvcStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcStudentsApplication.class, args);
	}

}
