package test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import test2.DefaultServiceLocator;

@Configuration
public class AppConfig {

	@Bean
    public ThingOne beanOne() {
		
		ThingOne thing = new ThingOne(ThingTwo(), ThingThree());
        return thing;
    }

	private Object ThingThree() {
		ThingThree thing = new ThingThree();
		return thing;
	}

	private Object ThingTwo() {
		ThingTwo thing = new ThingTwo();
		return thing;
	}
	

}
