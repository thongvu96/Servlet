/**
 * ProductServlet.java
 * Sep 21, 2018
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Product;
import entities.ProductDetail;
import model.Error;
import services.ProductDetailServicesImpl;
import services.ProductServicesImpl;

/**
 * @author VuThong
 */
@WebServlet("/formdemo")
public class ProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/createProduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		// 1.Retrieve data
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String content = req.getParameter("content");
		String image = req.getParameter("image");
		
		 // 2.Validate form
		if ("".equals(name.trim()) || "".equals(description.trim()) || "".equals(image.trim()) || "".equals(content.trim())) {
			// 2.1 Error => Back
			String noti = "Chua nhap du thong tin";
			Error error = new Error();
			error.setMsg(noti);
			req.setAttribute("error", error);
			req.getRequestDispatcher("createProduct.jsp").forward(req, resp);
		} else {
			// 2.2 Not Error => show data
			
			ProductServicesImpl productServices = new ProductServicesImpl();
			
			// insert
			Product product = new Product();
			product.setName(name);
			product.setDescription(description);
			product.setImage(image);
			
			ProductDetail productDetail = new ProductDetail();
			productDetail.setContent(content);
			
			product.setProductDetail(productDetail);
			productDetail.setProduct(product);
			
			productServices.createProduct(product);
			
			// showdata
			List<Product> listProduct = new ArrayList<>();
			listProduct = productServices.getAllProduct();
			
			req.setAttribute("listProduct", listProduct);
			req.getRequestDispatcher("/listProduct.jsp").forward(req, resp);
			
			// showdata
		}
					
	}
	
}
