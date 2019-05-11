package com.ovi.hibernate.demo;

import com.ovi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {


        //Create Session Factory

        SessionFactory factory = new Configuration().configure("com/ovi/jdbc/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        //Create Session
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating news Student Object..");
            Student tempStudent = new Student("Parvez", "Vaia", "vaia@bitmascot.com");

            session.beginTransaction();
            System.out.println("saving The Student");
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }
}