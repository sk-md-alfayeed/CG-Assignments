package com.cg.springcore.a7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
         System.out.println( "This is a SPEL" );
    	@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("configSPEL.xml");
    	demo d1=(demo) context.getBean("demo");
    	System.out.println(d1);
    }
}
