package com.mingi.reflectionapi;

public class Child extends Parent {

	public Integer age;
	
	// Class<T>.getClasses 메서드는 해당 클래스의 Static Nested Class 또는 Innter Class의 정보를 리턴한다
	// public 인 경우에만 해당된다.
	// Member 클래스
	public static class staticNestedClassOfChild {
		
	}
	
	private static class innerClassOfChild {
		
	}
}
