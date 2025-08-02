package com.railse.hiring.workforcemgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.railse.hiring")
public class WorkforceManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkforceManagementApiApplication.class, args);
	}

}
