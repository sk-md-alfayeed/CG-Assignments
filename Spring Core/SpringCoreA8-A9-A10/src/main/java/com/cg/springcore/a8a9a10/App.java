package com.cg.springcore.a8a9a10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello" );
    	@SuppressWarnings("resource")
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    	Book1 b1=(Book1) context.getBean("book1");
    	System.out.println(b1);
    	context.registerShutdownHook();
 
    	Book2 b2=(Book2) context.getBean("book2");
    	System.out.println(b2);
    //	context.registerShutdownHook();

    	Book3 b3=(Book3) context.getBean("book3");
    	System.out.println(b3);
    //	context.registerShutdownHook();



    	
    }
}
