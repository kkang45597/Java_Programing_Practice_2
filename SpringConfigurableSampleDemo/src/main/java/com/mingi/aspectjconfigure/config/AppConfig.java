package com.mingi.aspectjconfigure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.instrument.classloading.LoadTimeWeaver;

@Configuration
@EnableSpringConfigured
@EnableLoadTimeWeaving/*(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.AUTODETECT)*/ // 버그로 숨김
@ComponentScan(basePackages = "com.mingi.aspectjconfigure")
public class AppConfig implements LoadTimeWeavingConfigurer {

	@Override
	public LoadTimeWeaver getLoadTimeWeaver() {
		return null;
	}

}
