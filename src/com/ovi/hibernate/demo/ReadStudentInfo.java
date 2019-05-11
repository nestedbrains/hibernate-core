package com.ovi.hibernate.demo;

import com.ovi.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentInfo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/ovi/jdbc/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            System.out.println("Creating news Student Object..");
            Student tempStudent = new Student("ovi", "islam", "ovi@gmail.com");

            session.beginTransaction();
            System.out.println("saving The Student");
            session.save(tempStudent);

            Student student =session.get(Student.class , tempStudent.getId());
            System.out.println("Id is :" + student);
            session.getTransaction().commit();
            System.out.println("Done");


        } finally {

            session.close();
             {
        }}
    }
}
