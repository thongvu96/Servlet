/**
 * ProductDetailServices.java
 * Oct 3, 2018
 */
package dao;

import java.util.List;

import entities.Product;
import entities.ProductDetail;

/**
 * @author VuThong
 */
public interface ProductDetailServicesDao {
	public void createProductDetail(ProductDetail productDetail);
	public List<ProductDetail> getAllProductDetail();
	public List<ProductDetail> getProductDetail(int idProduct);
}
