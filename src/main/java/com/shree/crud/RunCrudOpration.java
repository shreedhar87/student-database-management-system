package com.shree.crud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shree.entity.Student;

public class RunCrudOpration {

	public static void main(String[] args) {
		while(true) {

			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();

			Session session=factory.getCurrentSession();

			System.out.println("WELCOME TO THE STUDENT DATA BASE");
			System.out.println("1.Add student data");
			System.out.println("2.Read student data based on id");
			System.out.println("3.Updata student data based on id");
			System.out.println("4.Delete student data based on id ");
			System.out.println("5.Get all the student data");
			System.out.println("6.Exit");
			System.out.println("\nEnter your choice");

			Scanner scan=new Scanner(System.in);
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				try {
					Student student=new Student();
					System.out.println("Enter first name");
					student.setFirstName(scan.next());

					System.out.println("Enter last name");
					student.setLastName(scan.next());

					System.out.println("Enter marks");
					student.setMarks(scan.nextInt());

					session.beginTransaction();
					session.save(student);

					session.getTransaction().commit();
					System.out.println("Added succesfully");

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					session.close();
					factory.close();
				}
				break;
			case 2:
				try {
					System.out.println("Enter the id");
					int iid=scan.nextInt();

					session.beginTransaction();
					Student student1=session.get(Student.class, iid);

					//	System.out.println(session.get(Student.class, iid));
					System.out.println(student1);

					session.getTransaction().commit();
					System.out.println("Done..");

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("Enter the id");
					int iid=scan.nextInt();

					session.beginTransaction();
					Student student1=session.get(Student.class, iid);

					System.out.println("Enter the first name");
					student1.setFirstName(scan.next());

					System.out.println("Enter the last name");
					student1.setLastName(scan.next());

					System.out.println("Enter the marks");
					student1.setMarks(scan.nextInt());


					session.getTransaction().commit();
					System.out.println("Done..");

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println("Enter the student id");
					session.beginTransaction();
					Student student=session.get(Student.class, scan.nextInt());

					session.delete(student);

					session.getTransaction().commit();
					System.out.println("deleted succesfully");

				}
				catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					session.close();
					factory.close();
				}
				break;
			case 5:	
				try {
					session.beginTransaction();

					List<Student> theStudent=session.createQuery("from Student").list();

					for(Student tempStudent:theStudent) {
						System.out.println(tempStudent);
					}


					session.getTransaction().commit();
					System.out.println("Added succesfully");

				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					session.close();
					factory.close();
				}
				break;
			case 6:
				System.out.println("Thank You");
				System.exit(0);

				break;
			default:
				System.out.println("Enter valid choice");

			}

		}
	}

}
