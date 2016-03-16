package com.png.sample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
	/*	HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
		hw.getMessage();
		
		
		MyWorld mw = (MyWorld) context.getBean("myWorld");
		mw.getMessage();
		context.registerShutdownHook();*/
		
	/*	TextEditor editor = (TextEditor) context.getBean("textEditor");
		editor.spellCheck();*/
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("AOPBeans.xml");
		
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		
		student.printThrowException();
		
	
	}

}
