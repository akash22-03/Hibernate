package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchClass 
{
	public static void main(String[] args) {
		//get load
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	//get
    	Student student = (Student)session.get(Student.class, 101);
    	System.out.println(student);
    	
    	//load
    	Student student1 = (Student)session.load(Student.class, 101);
    	System.out.println(student1.getName());
    	
    	session.close();
    	factory.close();
	}
}
