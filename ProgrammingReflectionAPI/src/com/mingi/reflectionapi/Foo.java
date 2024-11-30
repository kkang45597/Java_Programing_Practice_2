package com.mingi.reflectionapi;

public class Foo {
	String name;
	private Foo() {
		name = "hello";
	}
	public Foo(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
