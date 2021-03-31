package com.cg.springcore.a1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test 
{
    
	public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );
    	 @SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	Customer customer1 =(Customer) context.getBean("customer1");
    	System.out.println(customer1);
    	
    	System.out.println("Using Constructors :");
    	Customer customer2 =(Customer) context.getBean("customer2");
    	System.out.println(customer2);
    
    	
    }
}
