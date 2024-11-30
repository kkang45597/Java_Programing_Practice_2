package com.mingi.aspectjconfigure.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	// ProfilingAspect가 적용되지 않는 이유는 Account.doSomething에서 performService를 호출하기 때문이다.
	public void performService() {
		System.out.println("MyService::performService:Service is performing an operation");
	}
}
