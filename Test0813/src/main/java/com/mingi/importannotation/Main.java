package com.mingi.importannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);

		// now both beans A and B will be available...
		A a = context.getBean(A.class);
		B b = context.getBean(B.class);
		
		System.out.println("Hello world");
	}
}
