package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("Reflection");
        Object ob1 = ac.getBean("hello");
        System.out.println(ob1);

        Object ob2 = ac.getBean("random");
        Object ob22 = ac.getBean("random");

        System.out.println(ob22);
        System.out.println(ob2);

        Object ob3 = ac.getBean("dateTime");
        Object ob33 = ac.getBean("dateTime");
        System.out.println(ob33);
        System.out.println(ob3);
    }
}
