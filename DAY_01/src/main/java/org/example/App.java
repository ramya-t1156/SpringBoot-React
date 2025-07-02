package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");

        Student s = (Student) context.getBean("st");
        s.internshipProgram();

        SpringBoot f = (SpringBoot) context.getBean("fun");
        f.hello("fun");

        Course1 c1 = (Course1) context.getBean("course1");
        c1.enrollment("aura");

        Course2 c2 = (Course2) context.getBean("course2");
        c2.enrollment("aura");

        Course3 c3 = (Course3) context.getBean("course3");
        c3.enrollment("aura");

        //System.out.println( "Hello World!" );
    }
}
