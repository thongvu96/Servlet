<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${error.msg}</p>
	<form action="formdemo" method="POST">
		<p>Name: <input name="name"/></p>
		<p>Description: <textarea name="description" rows="4" cols="50"></textarea></p>
		<p>Post for Product<textarea name="content" rows="4" cols="50"></textarea></p>
		<p>Image: <input name="image" type="file"/></p>
		<p><input type="submit" value="Submit"/></p>
	</form>
</body>
</html>