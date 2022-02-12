<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>
			Expense Details for: <c:out value="${expense.name}" ></c:out>
			</h1>
			
			
			<p>Description:<c:out value="${expense.description}" ></c:out></p>
			<p>Amount: <c:out value="${expense.amount}" ></c:out></p>
			<p>Vendor: <c:out value="${expense.vendor}" ></c:out></p>

			<a href="http://localhost:8080/expense">Return home</a>
	
</body>
</html>