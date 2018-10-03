/**
 * ProductDetailServicesImpl.java
 * Oct 3, 2018
 */
package services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ProductDetailServicesDao;
import entities.Product;
import entities.ProductDetail;
import ulti.HibernateUtil;

/**
 * @author VuThong
 */
public class ProductDetailServicesImpl implements ProductDetailServicesDao{
	final static SessionFactory factory = HibernateUtil.getFactory();
	/* (non-Javadoc)
	 * @see dao.ProductDetailServices#createProductDetail(entities.ProductDetail)
	 */
	@Override
	public void createProductDetail(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			
			//3. insert
			session.save(productDetail);
			
			//4. transaction commit
			tx.commit();
			
			//5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see dao.ProductDetailServices#getAllProductDetail()
	 */
	@Override
	public List<ProductDetail> getAllProductDetail() {
		// TODO Auto-generated method stub
		List<ProductDetail> productDetail = null;
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			
			//3. select hql
			productDetail = session.createQuery("FROM ProductDetail").list();
			
			//4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDetail;
	}

	/* (non-Javadoc)
	 * @see dao.ProductDetailServicesDao#getProductDetail(java.lang.String)
	 */
	@Override
	public List<ProductDetail> getProductDetail(int idProduct) {
		// TODO Auto-generated method stub
		List<ProductDetail> productDetail = null;
		try {
			//1. create session
			Session session = factory.openSession();
			
			//2. begin transaction
			Transaction tx = session.beginTransaction();
			
			//3. select hql
			javax.persistence.Query query = session.createQuery("FROM ProductDetail where id = :code");
			query.setParameter("code", idProduct);
			productDetail = query.getResultList();
			//4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDetail;
	}
	
}
