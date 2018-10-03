package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Order;
import entities.Product;
import ulti.HibernateUtil;

public class MainManyToMany {
	
	final static SessionFactory factory = HibernateUtil.getFactory();
	
	public static void main(String[] args) {
		insertData();
	}
	
	private static void insertData() {
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			
			//3. insert
			Product newProduct = new Product();
			newProduct.setName("ABC1313");
			
			Order order = new Order();
			order.setName("ABC1313");
			
				// associate 
			newProduct.getOrders().add(order);
			order.getProducts().add(newProduct);
			
			session.save(order);
			session.save(newProduct);
			//4. transaction commit
			tx.commit();
			
			//5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
