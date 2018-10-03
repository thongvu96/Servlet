/**
 * ProductServices.java
 * Oct 1, 2018
 */
package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ProductServicesDao;
import entities.Product;
import ulti.HibernateUtil;

/**
 * @author VuThong
 */
public class ProductServicesImpl implements ProductServicesDao{
	
	final static SessionFactory factory = HibernateUtil.getFactory();
	
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			
			//3. insert
			session.save(product);
			
			//4. transaction commit
			tx.commit();
			
			//5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProduct() {
		List<Product> products = null;
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			
			//3. select hql
			products = session.createQuery("FROM Product").list();
			
			//4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
