<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Delete Records</title>
</head>
<body>
<jsp:include page="index.jsp" />
<h1>Delete Records</h1>

<h2>Delete Car</h2>
<form action="Servlet" method="post" style="margin-bottom: 40px;">
  <input type="hidden" name="action" value="deleteCar">
  <label for="carId">Car ID:</label>
  <input type="text" id="carId" name="id" required><br>
  <button type="submit">Delete Car</button>
</form>

<h2>Delete Customer</h2>
<form action="Servlet" method="post" style="margin-bottom: 40px;">
  <input type="hidden" name="action" value="deleteCustomer">
  <label for="customerId">Customer ID:</label>
  <input type="text" id="customerId" name="id" required><br>
  <button type="submit">Delete Customer</button>
</form>

</body>
</html>
