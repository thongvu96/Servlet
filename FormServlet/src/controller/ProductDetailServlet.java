/**
 * ProductDetailServlet.java
 * Oct 3, 2018
 */
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.ProductDetail;
import services.ProductDetailServicesImpl;

/**
 * @author VuThong
 */
@WebServlet("/productDetail")
public class ProductDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idProduct = req.getParameter("selectedValue");
		
		ProductDetailServicesImpl productDetailServices = new ProductDetailServicesImpl();
		List<ProductDetail> productDetail = productDetailServices.getProductDetail(Integer.parseInt(idProduct));
		
		req.setAttribute("productDetail", productDetail);
		req.getRequestDispatcher("/productDetail.jsp").forward(req, resp);
	}
	
}
