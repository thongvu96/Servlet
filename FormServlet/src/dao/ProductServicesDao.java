/**
 * ProductServicesDao.java
 * Oct 1, 2018
 */
package dao;

import java.util.List;

import entities.Product;

/**
 * @author VuThong
 */
public interface ProductServicesDao {
	public void createProduct(Product product);
	public List<Product> getAllProduct();
}
