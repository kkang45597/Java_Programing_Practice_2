package com.mingi.jdkproxy2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DebugProxy implements java.lang.reflect.InvocationHandler {

    private Object obj;
    
    
    // 자바에선 배열을 클래스로 취급한다.
    private DebugProxy(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
            obj.getClass().getClassLoader(),
            obj.getClass().getInterfaces(),
            new DebugProxy(obj));
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    	
        Object result;
        try {
            System.out.println("before method " + m.getName());
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                                       e.getMessage());
        } finally {
            System.out.println("after method " + m.getName());
        }
        return result;
    }
}