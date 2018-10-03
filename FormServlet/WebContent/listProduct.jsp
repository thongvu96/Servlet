<%@page import="java.util.ArrayList"%>
<%@page import="entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
		<tr>
			<th>Name</th>
			<th>Desciption</th>
			<th>Image</th>
		</tr>
	</thead>
	<tbody>
		<!-- <tr>
			<td>${product.name}</td>
			<td>${product.description}</td>
			<td>${product.image}</td>
		</tr> -->
		
		<%	List<Product> listProduct = (ArrayList) request.getAttribute("listProduct");
				for (Product product : listProduct) {
					out.print("<tr><td>" + product.getId() + "</td>");
					out.print("<td><a href = \"productDetail"+ "?selectedValue=" + product.getId() +"\" >" + product.getName() + "</a></td>");
					out.print("<td>" + product.getImage() + "</td>");
					out.print("<td>" + product.getCategory() + "</td>");
					out.print("<td>" + product.getDescription() + "</td></tr>");
				}
			%>
	</tbody>
</table>
	
</body>
</html>