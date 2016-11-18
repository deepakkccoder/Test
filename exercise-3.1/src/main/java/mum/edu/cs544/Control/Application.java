package mum.edu.cs544.Control;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mum.edu.cs544.model.BidirectionalManyToMany.Course;
import mum.edu.cs544.model.BidirectionalManyToMany.Student;
import mum.edu.cs544.model.BidirectionalOneToMany.Department;
import mum.edu.cs544.model.BidirectionalOneToMany.Employee;
import mum.edu.cs544.model.BidirectionalOneToMany.Office;
import mum.edu.cs544.model.UnidirectionalManyToOne.Book;
import mum.edu.cs544.model.UnidirectionalManyToOne.Publisher;


public class Application {
private static EntityManagerFactory emf;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static void main(String[] args) throws IOException {
		addCourse();
		addBook();
		addDepartment();
		//printMoviesReport();
		emf.close();
	}
	private static void addDepartment() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {	
				
			List<Employee> employee = new ArrayList<Employee>();
		
			Employee employee1 = new Employee();
			employee1.setName("Deepak K C");
		
			Employee employee2 = new Employee();
			employee1.setName("Deep K C");
			
			Employee employee3 = new Employee();
			employee1.setName("Deepu K C");
			
			Department dept1 = new Department();
			
			dept1.setName("Customer Care");
			
			employee.add(employee1);
			dept1.setEmployee(employee);
			
			employee1.setDepartment(dept1);
			
			Office office = new Office();
			office.setBuildingName("Verill");
			office.setRoomNo(210);
			office.setEmployees(employee);
			
			employee1.setOffice(office);
			em.persist(office);
			em.persist(dept1);
			em.persist(employee1);
			tx.commit();
		}
		
		catch (Throwable e) {
			e.printStackTrace();
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} 
		finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		}

	private static void addBook() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				
				Publisher publisher1 = new Publisher();
				Publisher publisher2 = new Publisher();
				Publisher publisher3 = new Publisher();
				
				publisher1.setName("International Publication");
				publisher2.setName("Oxford Publication");
				publisher3.setName("Namuna Publication");
				
				Book book1 = new Book();
				Book book2 = new Book();
				
				book1.setIsbn("234-256-986");
				book1.setAuthor("Laxmi Prasad Devkota");
				book1.setTitle("Muna Madan");
				book1.setPublisher(publisher1);
			
				
				
				book2.setIsbn("134-756-986");
				book2.setAuthor("Jhamak Ghimire");
				book2.setTitle("Mahima");
				book2.setPublisher(publisher2);
			
				em.persist(publisher1);
				em.persist(publisher2);
				em.persist(publisher3);
				em.persist(book1);
				em.persist(book2);
				
				
				tx.commit();
		}
		
		catch (Throwable e) {
			e.printStackTrace();
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} 
		finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		}

	private static void addCourse() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
			tx.begin();
			try {
				
				
				Course course1 = new Course();
				course1.setName("EA");
				course1.setCourseNo("CS544");
				Student student1 = new Student();
				student1.setfName("Deepak");
				student1.setlName("K C");
				student1.getCourseList().add(course1);
				course1.getStudents().add(student1);
				
				em.persist(course1);
				em.persist(student1);
				
				
				tx.commit();
		}
		
		catch (Throwable e) {
			e.printStackTrace();
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} 
		finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		}

	
	
	}

