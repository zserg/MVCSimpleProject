<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Objects page</title>
</head>
<body>
	<h1>List of cars</h1>
	<p>
		${message}<br />
	<p>Here you can add a new car.</p>
	<form:form method="POST" commandName="device"
		action="${pageContext.request.contextPath}/">
		<table>
			<tbody>
				<tr>
					<td>Car Model:</td>
					<td><form:input path="carModel" /></td>
				</tr>
				<tr>
					<td>Owner Name:</td>
					<td><form:input path="ownerName" /></td>
				</tr>
				<tr>
					<td>License Plate:</td>
					<td><form:input path="licensePlate" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="10%">id</th>
				<th width="15%">Car Model</th>
				<th width="10%">Owner Name</th>
				<th width="10%">License Plate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="car" items="${cars}">
				<tr>
					<td>${car.id}</td>
					<td>${car.carModel}</td>
					<td>${car.ownerName}</td>
					<td>${car.licensePlate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	</p>
</body>
</html>
