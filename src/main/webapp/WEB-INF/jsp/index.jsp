<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: natalia
  Date: 22.11.18
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Service</title>
</head>
<body>
    <h2>Сервис продуктов</h2>
   <%-- ${hello}--%>
    <form id="productsForm">
        <table border="5">
            <thead>
                <tr>
                    <th>Название продукта</th>
                    <th>Количество</th>
                    <th>Цена</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.count}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>

</body>
</html>
