package com.mingi.aspectj.combinedpointcut.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	public void performBusinessLogic() {
		System.out.println("MyService: performBusinessLogice");
	}
}