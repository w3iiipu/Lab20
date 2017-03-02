
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
${userReg}
<form action="processItem" method="post" style="margin: 0 auto"> <br>
    Item ID <input type="text" name="ItemID"> <br>
    Item Name <input type="text" name="ItemName"> <br>
    Description <input type="email" name="Desc"> <br>
    Quantity <input type="tel" name="Quantity"> <br>
    Retail Price <input type="password" name="RPrice"> <br>
    Cost Price <input type="password" name="CPrice"> <br>
    <input type="submit" value="Add to Inventory"> <br>

</form>

</body>
</html>
