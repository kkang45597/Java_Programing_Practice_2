package com.mingi.beandefinitions;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
	
	private final DataSource dataSource;
	
	public RepositoryConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean
	public AccountRepository accountRepository(DataSource dataSource) {
		return new JdbcAccountRepository(dataSource);
	}
}