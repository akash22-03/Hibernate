package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
	
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Project Started...");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	Student st = new Student(101,"JOHN","DELHI");
    	System.out.println(st);
    	
    	FileInputStream fis = new FileInputStream("src/main/java/DSC00781.jpg");
    	byte[] data = new byte[fis.available()];
    	fis.read(data);
    	
    	Address ad = new Address("street1", "Delhi", true, 1234.35 ,new Date(),data);
    	
    	Session session = factory.openSession();   	
    	
    	/*
	    	session.beginTransaction();
	    	session.save(st);
	    	session.getTransaction().commit();
    	*/
    	
    	Transaction tx = session.beginTransaction();
    	session.save(st);
    	session.save(ad);
    	
    	tx.commit();
    	
    	session.close();
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
  
}
