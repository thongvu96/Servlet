package main;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Product;
import entities.ProductDetail;
import ulti.HibernateUtil;

public class MainOneToOne {
	
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
			newProduct.setName("ABC13");
			
			
			ProductDetail productDetail = new ProductDetail();
			productDetail.setContent("ABC23");
			
			productDetail.setProduct(newProduct);
			newProduct.setProductDetail(productDetail);
			
			session.save(newProduct); //cascade = CascadeType.ALL auto update id for detail
			//4. transaction commit
			tx.commit();
			
			//5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
