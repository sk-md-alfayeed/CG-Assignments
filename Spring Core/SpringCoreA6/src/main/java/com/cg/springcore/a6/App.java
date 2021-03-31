package com.cg.springcore.a6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	static MessageSource messageSource;
    public static void main( String[] args ){
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Movies movies = (Movies)context.getBean("movies");
        System.out.println(movies);
        messageSource = (MessageSource)context.getBean("messageSource");
        String msg = messageSource.getMessage("message", null, "Default Message",null);
        System.out.println(msg);
    }
}
