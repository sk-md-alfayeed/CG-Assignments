package com.cg.springcore.a5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       @SuppressWarnings("resource")
	ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
       Book book=(Book)context.getBean("Book");
       System.out.println(book);
    }
}
