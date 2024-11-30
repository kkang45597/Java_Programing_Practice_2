package com.mingi.Profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp_2 {
    public static void main(String[] args) {
        // 조건에 맞는 시스템 속성 설정
        System.setProperty("my.custom.property", "enabled");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        if (context.containsBean("myService")) {
            MyService myService = context.getBean(MyService.class);
            System.out.println("MyService Bean is available: " + myService.getClass().getName());
        } else {
            System.out.println("MyService Bean is not available");
        }
    }
}