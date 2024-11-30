package com.mingi.beandefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	
//	@Autowired
//	private AccountRepository accountRepository; // 권장하지 않는 방법

	@Bean
//	public TransferService transferService() {
	public TransferService transferService(AccountRepository accountRepository) {
		return new TransferServiceImpl(accountRepository);
	}
}