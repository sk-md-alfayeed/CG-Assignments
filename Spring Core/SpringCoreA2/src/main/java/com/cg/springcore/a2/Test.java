package com.cg.springcore.a2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	
   	 @SuppressWarnings("resource")
	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
   	ListQuestion listq =(ListQuestion) context.getBean("listQuestion");
   	System.out.println(listq);
   	
   	MapQuestion mapq =(MapQuestion) context.getBean("mapQuestion");
   	System.out.println(mapq);
   	
   	SetQuestion setq =(SetQuestion) context.getBean("setQuestion");
   	System.out.println(setq);
    }
}
