package com.company;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

@SuppressWarnings("deprecation")
public class Main {

    private Configuration cfg;
    private SessionFactory factory;

    public Main(){
        cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
    }

    public static void main(String[] args) {
	// write your code here
    }
}
