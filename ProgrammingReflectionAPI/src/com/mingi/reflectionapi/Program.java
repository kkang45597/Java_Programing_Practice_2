package com.mingi.reflectionapi;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

enum E { A, B }

public class Program {
	
	public static void getObjectgetClass() {
		
		// Class<?>, Class<? extends String> 상속이 아닌 계층 구조를 가진다.
		Class c1 = "foo".getClass(); // 권장되지 않는 raw 타입
		
		Class<String> c2 = (Class<String>) "foo".getClass(); // FM 방식
		
		Class c3 = E.A.getClass();
		
		byte[] bytes = new byte[1024];
		Class c4 = bytes.getClass();
		
		String[] Strs = new String[10];
		Class c5 = bytes.getClass();
		
		try {
			Class cDoubleArray = Class.forName("[D");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// <? extens set>
		Set<String> s = new HashSet<String>();
		Class c6 = s.getClass();
		
		Class<? extends String> c7 = "foo".getClass();

	}
	
	public static void getClassSyntax() {
		Class c1 = String.class;
		Class c2 = Double.class;
		Class c3 = PrintStream.class;
	}
	
	// 런타임때 Program.class 파일의 가상 머신의 클래스 로더에 의해 로드가 되는 시점에서 호출/실행된다.
	// main.class 보다 먼저 호출된다.
	// 익명 클래스이다. Program 클래스의 내부 클래스이다.
	public class MyClass {
	    static Object o = new Object() { 
	        public void m() {} 
	    };
	    static Class<?> c = o.getClass().getEnclosingClass();
	}

	public static void main(String[] args) {
//		getObjectgetClass();
//		getClassSyntax();
		
//		Class<?>[] cs = Character.class.getClasses();
//		for (Class clazz:cs) {
//		    System.out.println(clazz.getTypeName());
//		}
		
//		// 해당 클래스의 멤버를 호출
//		Class<?>[] c = Child.class.getClasses();
//		for (Class clazz:c) {
//		    System.out.println(clazz.getTypeName());
//		}
		
		// Program 클래스의 스태틱 필드은 c 와 shadow 되지 않음.
		Class c = Thread.State.class.getEnclosingClass();
	}
}
