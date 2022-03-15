package com.mapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main(String[] args) 
	{
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	Question q = new Question();
    	q.setQuestionId(1212);
    	q.setQuestion("What is Java ?");
    	
    	Answer a = new Answer();
    	a.setAnswerId(343);
    	a.setAnswer("Java is a Programing Language");
    	
    	a.setQns(q);
    	
    	q.setAnswer(a);
    	
    	Session s = factory.openSession();
    	Transaction tx = s.beginTransaction();
    	
    	s.save(q);
    	s.save(a);
    	
    	tx.commit();
    	
    	Question bewQ = (Question)s.get(Question.class, 1212);
    	System.out.println(bewQ.getQuestion());
    	System.out.println(bewQ.getAnswer().getAnswer());
    	
    	s.close();
    	
    	factory.close();
	}
}
