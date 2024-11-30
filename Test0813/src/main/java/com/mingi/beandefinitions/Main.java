package com.mingi.beandefinitions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SystemTestConfig.class);

		TransferService transferService = context.getBean(TransferService.class);
		transferService.transfer(100.00, "A123", "C456");
	}

}
