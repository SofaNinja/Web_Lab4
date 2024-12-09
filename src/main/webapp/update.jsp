<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Update Records</title>
</head>
<body>
<jsp:include page="index.jsp" />
<h1>Update Existing Records</h1>

<h2>Update Car</h2>
<form action="Servlet" method="post" style="margin-bottom: 40px;">
  <input type="hidden" name="action" value="updateCar">
  <label for="carId">Car ID:</label>
  <input type="text" id="carId" name="id" required><br>
  <label for="carName">Name:</label>
  <input type="text" id="carName" name="name"><br>
  <label for="brand">Brand:</label>
  <input type="text" id="brand" name="brand"><br>
  <label for="price">Price:</label>
  <input type="text" id="price" name="price"><br>
  <button type="submit">Update Car</button>
</form>

<h2>Update Customer</h2>
<form action="Servlet" method="post" style="margin-bottom: 40px;">
  <input type="hidden" name="action" value="updateCustomer">
  <label for="customerId">Customer ID:</label>
  <input type="text" id="customerId" name="id" required><br>
  <label for="customerName">Name:</label>
  <input type="text" id="customerName" name="name"><br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email"><br>
  <button type="submit">Update Customer</button>
</form>

</body>
</html>
