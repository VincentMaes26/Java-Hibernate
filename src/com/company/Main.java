package com.company;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

        Main jpa = new Main();
        try {
            jpa.setUp();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

        public void setUp() throws Exception {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            try{
                Student student1 = new Student("Vincent", "Maes", "vincent-maes-@hotmail.com", "+32474778073");
                session.save(student1);

                MarksDetails marksDetails1 = new MarksDetails("English", 20, 16, "Pass");
                marksDetails1.setStudent(student1);
                session.save(marksDetails1);

                MarksDetails marksDetails2 = new MarksDetails("Java Advanced", 20, 14, "Pass");
                marksDetails2.setStudent(student1);
                session.save(marksDetails2);

                tx.commit();
                session.close();
                System.out.println("The records have been successfully added to the database");
            }
            catch (Exception e){
                if (tx != null) {
                    tx.rollback();
                }
                System.out.println(e.getMessage());
            }
            finally {
                session.close();
            }
        }

}
