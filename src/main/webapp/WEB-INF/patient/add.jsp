<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 04/09/2024
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajout patient</h1>
<form action="add" method="post">
  <div class="mb-3">
    <label for="firstName" class="form-label">Name:</label>
    <input type="text" name="firstName" id="firstName" class="form-control">
  </div>
  <div class="mb-3">
    <label for="lastName" class="form-label">Breed:</label>
    <input type="text" name="lastName" id="lastName" class="form-control">
  </div>
  <div class="mb-3">
    <label for="dateOfBirth" class="form-label">Birth date:</label>
    <input type="date" name="dateOfBirth" id="dateOfBirth" class="form-control">
  </div>
  <button type="submit">Submit</button>
</form>
</body>
</html>
