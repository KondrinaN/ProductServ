<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: natalia
  Date: 22.11.18
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Service</title>
</head>
<body>
<h2>Сервис продуктов rest</h2>
<%-- ${hello}--%>

<form id="productsAdd" method="POST">
    <p><input type="text" name="name"/></p>
    <p><input type="text" name="count"/></p>
    <p><input type="text" name="price"/></p>
    <p><input type="submit" name="SaveProduct" value="Сохранить продукт"/></p>
</form>

</body>
</html>
