package com.mingi.Profile;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp_1 {
	public static void main(String[] args) {
    	// 프로파일 설정: "dev" 또는 "prod"
    	System.setProperty("spring.profiles.active", "dev");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println("Using DataSource: " + dataSource.getClass().getName());
	}
}