<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Outstanding Loans</title>
</head>
<body>

<h2>List of Out-standings</h2>
<table border="1" >
<thead>
<tr>
<td>Loan Account </td>
<td>Customer Name</td>
<td>EMI</td>
<td>Rate of Interest</td>
</tr>
</thead>
<tbody>
<c:forEach items="${loans}" var="x">
<tr>
	<td>${x.loanId}</td>
	<td> ${x.customerName }</td>
	<td> ${x.emi }</td>
	<td>${x.rateOfInterest }</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>