package com.mingi.aspectjconfigure;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import com.mingi.aspectjconfigure.config.AppConfig;
import com.mingi.aspectjconfigure.dao.Account;
import com.mingi.aspectjconfigure.service.EntitlementCalculationService;
import com.mingi.aspectjconfigure.service.StubEntitlementCalculationService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);	
		
		Account account = new Account();
		account.doSomething();
		
//		EntitlementCalculationService service =
//				context.getBean(EntitlementCalculationService.class); // 버그로 숨김
		
		EntitlementCalculationService service =
				new StubEntitlementCalculationService();
		
		service.calculateEntitlement();
	}

}
