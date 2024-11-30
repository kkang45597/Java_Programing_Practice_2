package com.mingi.aspectjconfigure.service;

import org.springframework.stereotype.Service;

//@Service // 버그로 숨김
public class StubEntitlementCalculationService implements EntitlementCalculationService {

	@Override
	public void calculateEntitlement() {
		System.out.println("+StubEntitlementCalculationService::calculateEntitlement");
		
		try {
			Thread.sleep(1000);
			System.out.println("Calculating entitlement");
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("-StubEntitlementCalculationService::calculateEntitlement");
	}
}
