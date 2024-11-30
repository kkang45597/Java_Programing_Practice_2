package com.mingi.reflectionapi;

import static java.lang.System.out;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class ConsoleCharset {
	
	public static void getFooField() throws NoSuchMethodException, SecurityException {

		Constructor<?>[] ctors = Foo.class.getDeclaredConstructors();
		Constructor<?> ctor = null;
		
		for(int i = 0; i < ctors.length; i++) {
			ctor = ctors[i];
			if (ctor.getGenericExceptionTypes().length == 0) { break; }
		}
		
		try {
			boolean isSet = ctor.trySetAccessible();
			if(isSet) {
				ctor.setAccessible(true);
//				Foo foo = new Foo(); // 디폴트가 package-private이라 안된다.
				Foo c = (Foo)ctor.newInstance();
			    Field f = c.getClass().getDeclaredField("name");
			    
			    if(isSet = f.trySetAccessible() ) {
			    	 f.setAccessible(true);
					 out.format("Console charset         :  %s%n", f.get(c));
					 out.format("Charset.defaultCharset():  %s%n", Charset.defaultCharset());
			    }
			}
	
	    // production code should handle these exceptions more gracefully
		} catch (InstantiationException x) {
		    x.printStackTrace();
	 	} catch (InvocationTargetException x) {
	 	    x.printStackTrace();
		} catch (IllegalAccessException x) {
		    x.printStackTrace();
		} catch (NoSuchFieldException x) {
		    x.printStackTrace();
		} catch (InaccessibleObjectException x) {
			x.printStackTrace();
		}
	}
	
    public static void main(String... args) throws NoSuchMethodException, SecurityException {
    	 getFooField();
    }
}