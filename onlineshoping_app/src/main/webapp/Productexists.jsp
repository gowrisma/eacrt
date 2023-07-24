<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Insert title here</title>
<%@include file="includes/head.jsp"%>

<style>
#row {
	baground-color: green;
}
</style>

</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="alert alert-warning">Product Already Exists in
		Cart.....</div>
	<a class="btn btn-primary" href="allProducts">Continue Shopping</a>

</body>
</html>