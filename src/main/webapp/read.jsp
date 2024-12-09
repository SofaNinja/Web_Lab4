<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Read Records</title>
</head>
<body>
<jsp:include page="index.jsp" />
<h1>Database Records</h1>

<sql:setDataSource var="dataSource" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/Web_Lab4"
                   user="postgres" password="postgres"/>

<h2>Cars</h2>
<sql:query dataSource="${dataSource}" var="carsQuery">
  SELECT id, name, brand, price FROM car;
</sql:query>
<table border="1">
  <tr><th>ID</th><th>Name</th><th>Brand</th><th>Price</th></tr>
  <c:forEach var="car" items="${carsQuery.rows}">
    <tr>
      <td>${car.id}</td>
      <td>${car.name}</td>
      <td>${car.brand}</td>
      <td>${car.price}</td>
    </tr>
  </c:forEach>
</table>

<h2>Customers</h2>
<sql:query dataSource="${dataSource}" var="customersQuery">
  SELECT id, name, email FROM customer;
</sql:query>
<table border="1">
  <tr><th>ID</th><th>Name</th><th>Email</th></tr>
  <c:forEach var="customer" items="${customersQuery.rows}">
    <tr>
      <td>${customer.id}</td>
      <td>${customer.name}</td>
      <td>${customer.email}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
