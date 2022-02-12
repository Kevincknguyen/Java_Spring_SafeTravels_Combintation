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

	
			<h1>Edit an expense</h1>
	<form:form action="/expense/${expense.id}" method="post" modelAttribute="expense">
	<input type="hidden" name="_method" value="put">
				<p>
					<form:label path="name">Expense Name</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input path="name" />
				</p>
					<form:label path="vendor">Vendor</form:label>
					<form:errors path="vendor" class="text-danger"/>
					<form:input path="vendor" />
				<p>
					<form:label path="amount">Amount</form:label>
					<form:errors type="number" path="amount" class="text-danger"/>
					<form:input path="amount" />
				</p>
				<p>
					<form:label path="description">Description</form:label>
					<form:errors path="description" class="text-danger"/>
					<form:input path="description" />
				</p>
				<p>
					<input type=submit value="Submit"/>
				</p>
				
				
	</form:form>
	
	
</body>
</html>
