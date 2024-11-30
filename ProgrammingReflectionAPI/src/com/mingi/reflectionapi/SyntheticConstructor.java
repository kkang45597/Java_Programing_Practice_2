package com.mingi.reflectionapi;

import java.lang.reflect.Constructor;

public class SyntheticConstructor {
    private SyntheticConstructor() {}
    
    class Inner {
    	// Compiler will generate a synthetic constructor since
    	// SyntheticConstructor() is private.
    	Inner() { new SyntheticConstructor(); }
    }
    
    public static void main(String[] args) { // Chat GTP로 추가
        try {
            Constructor<?>[] constructors = ConstructorAccess.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
                System.out.println("  [ synthetic=" + constructor.isSynthetic() + "  var_args=" + constructor.isVarArgs() + " ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}