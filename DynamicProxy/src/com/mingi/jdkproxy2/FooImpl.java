package com.mingi.jdkproxy2;

public class FooImpl implements Foo {

	@Override
	public Object bar(Object obj) throws BazException {

		if(obj == null ) {
			throw new BazException();
		}
		return null;
	}

}
