<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Item ID</th>
        <th>Item</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <c:forEach var="inventory" items="${cInventory}">
        <tr>
            <td>${inventory.itemID}</td>
            <td>${inventory.name}</td>
            <td>${inventory.description}</td>
            <td>${inventory.quantity}</td>
            <td>${inventory.rprice}</td>
            <td>${inventory.cprice}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
