package com.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.warehouse", "com.common.api", "com.mystore2.data"})
@SpringBootApplication
public class WarehouseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

}
