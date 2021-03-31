package com.cg.springcore.a3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello" );
      	 @SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        	BankAccountController obj =(BankAccountController) context.getBean("bankAccountController");
        	System.out.println(obj);
    }
}
