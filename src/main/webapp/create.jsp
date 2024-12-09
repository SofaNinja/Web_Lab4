<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Create Records</title>
</head>
<body>
<jsp:include page="index.jsp" />
<h1>Create New Records</h1>

<h2>Add Car</h2>
<form action="Servlet" method="post" style="margin-bottom: 40px;">
  <input type="hidden" name="action" value="addCar">
  <label for="carName">Name:</label>
  <input type="text" id="carName" name="name" required><br>
  <label for="brand">Brand:</label>
  <input type="text" id="brand" name="brand" required><br>
  <label for="price">Price:</label>
  <input type="text" id="price" name="price" required><br>
  <button type="submit">Add Car</button>
</form>

<h2>Add Customer</h2>
<form action="Servlet" method="post" style="margin-bottom: 40px;">
  <input type="hidden" name="action" value="addCustomer">
  <label for="customerName">Name:</label>
  <input type="text" id="customerName" name="name" required><br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required><br>
  <button type="submit">Add Customer</button>
</form>

</body>
</html>
