package com.mingi.DynamicProxy;

import java.lang.reflect.Proxy;

public class ProxyExample {
	
    public static void main(String[] args) {
        // 클래스 로더
        ClassLoader classLoader = ProxyExample.class.getClassLoader();

        // 프록시 생성 - 인터페이스 순서: FirstInterface, SecondInterface
        Object proxy1 = Proxy.newProxyInstance(
                classLoader,
                new Class<?>[]{FirstInterface.class, SecondInterface.class},
                new MyInvocationHandler()
        );

        // 프록시 생성 - 인터페이스 순서: SecondInterface, FirstInterface
        Object proxy2 = Proxy.newProxyInstance(
                classLoader,
                new Class<?>[]{SecondInterface.class, FirstInterface.class},
                new MyInvocationHandler()
        );

        // 동일한 인터페이스 조합이지만 순서가 다르면 서로 다른 프록시 클래스가 생성됨
        System.out.println("proxy1 class: " + proxy1.getClass());
        System.out.println("proxy2 class: " + proxy2.getClass());
        
        FirstInterface firstProxy1 = (FirstInterface) proxy1;
        // 프록시 인테페이스 중 하나를 통한 프록시 인스턴스 메서드 호출은 프록시 인스턴스의 
        // invocation handler 의 invoke 메서드로 호출된다.
        firstProxy1.firstMethod();
                
        SecondInterface secondProxy1 = (SecondInterface) proxy1;
        secondProxy1.secondMethod();
        
        FirstInterface firstProxy2 = (FirstInterface) proxy2;
        firstProxy2.firstMethod();
                
        SecondInterface secondProxy2 = (SecondInterface) proxy1;
        secondProxy2.secondMethod();
        
        // 두 프록시 클래스는 다름
        System.out.println("Are proxy1 and proxy2 classes the same? " + 
        		(proxy1.getClass() == proxy2.getClass()));
    }
}
