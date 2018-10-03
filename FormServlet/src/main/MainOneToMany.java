package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Category;
import entities.Product;
import ulti.HibernateUtil;

public class MainOneToMany {
	// load config "hibernate.cfg.xml"
	final static SessionFactory factory = HibernateUtil.getFactory();
	public static void main(String[] args) {
		showData();
		// insertData();
	}
	
	private static void showData() {
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			//3. select hql
			List<Category> categories = session.createQuery("FROM Category").list();
			
			for (Category category : categories) {
				System.out.println(category.getName());
				for (Product product : category.getProducts()) {
					System.out.println("\t" + product.getName());
				}
			}
			
			//4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void insertData() {
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			
			//3. insert
			Category newCategory = new Category();
			newCategory.setName("new category323");
			session.save(newCategory);
			
			Product newProduct = new Product();
			newProduct.setName("ABC");
			newProduct.setCategory(newCategory);
			session.save(newProduct);
			
			newCategory.getProducts().add(newProduct);
			session.save(newCategory);
			//4. transaction commit
			tx.commit();
			
			//5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
