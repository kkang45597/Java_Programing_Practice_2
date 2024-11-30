package com.mingi.DynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

interface InterfaceA {
    void duplicateMethod();
}

interface InterfaceB {
    void duplicateMethod();
}


class ClassA implements InterfaceA {
    @Override
    public void duplicateMethod() {
        System.out.println("ClassA: duplicateMethod");
    }
}

class ClassB implements InterfaceB {
    @Override
    public void duplicateMethod() {
        System.out.println("ClassB: duplicateMethod");
    }
}

public class MyInvocationHandler implements InvocationHandler {
    private final Object objA;
    private final Object objB;

    public MyInvocationHandler(Object objA, Object objB) {
        this.objA = objA;
        this.objB = objB;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoked method: " + method.getName());

        if (method.getDeclaringClass().isAssignableFrom(InterfaceA.class)) {
            return method.invoke(objA, args);
        } else if (method.getDeclaringClass().isAssignableFrom(InterfaceB.class)) {
            return method.invoke(objB, args);
        }

        return null;
    }
}