package com.mingi.aspectjconfigure.dao;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.mingi.aspectjconfigure.service.MyService;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true, preConstruction = true)
public class Account {

	@Autowired
	private MyService myService;
	
	public void doSomething() {
		System.out.println("+Account::MyService:doSomething");
		
		if(myService != null) {
			myService.performService();
		}
		else {
			System.out.println("Account::doSomething:MyService is not injected");
		}
		
		System.out.println("-Account::MyService:doSomething");
	}
}
