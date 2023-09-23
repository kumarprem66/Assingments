package com.masai.school.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masai.school.bean.practice.MyBusinessClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBusinessClass mbc = ctx.getBean(MyBusinessClass.class,"mbc");
        mbc.fun1();
        
        
    }
}
