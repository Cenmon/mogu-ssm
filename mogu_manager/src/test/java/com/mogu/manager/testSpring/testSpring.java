package com.mogu.manager.testSpring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {

	@Test
	public void testSpringfram() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String string : definitionNames) {
			System.out.println(string);
		}
		System.out.println("总计："+applicationContext.getBeanDefinitionCount());
	}
}
