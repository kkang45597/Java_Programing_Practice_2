package com.mingi.jdkproxy2;

import java.lang.reflect.Proxy;

import com.mingi.jdkproxy.Delegator;

public class Program {

	public static void main(String[] args) throws BazException {
		
		Class<?>[] proxyInterfaces = new Class[] { Foo.class };
		Object[] objs = new Object[] { FooImpl.class }; 
		Object proxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				proxyInterfaces, 
				new Delegator(proxyInterfaces, objs));
		
		Foo foo = (Foo) proxy;
		
		String str = "hello";
		System.out.println(foo.bar(str));
		
		System.out.println(proxy.toString());
		System.out.println(proxy.hashCode());
		System.out.println(proxy.equals(foo));
	}

}
