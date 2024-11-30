package test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.BeanFactory;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);

        ClientService clientService = context.getBean(ClientService.class);
        AccountService accountService = context.getBean(AccountService.class);

        // ClientService 및 AccountService 사용
        clientService.doSomething();
        accountService.performAction();
        
        BeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        Class<?> clientServiceType = beanFactory.getType("clientService");
        System.out.println("Runtime type of 'clientService' bean: " + clientServiceType.getName());
    }

}
