package com.png.sample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("After initialization of the " +bean.getClass()+ " in the postProcessorAfterInitializationMethod");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("before initialization of the " +bean.getClass()+ " in the postProcessorBeforeInitializationMethod");
		return bean;
	}


}
