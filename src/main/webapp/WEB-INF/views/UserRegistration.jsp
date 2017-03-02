
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
${userReg}
<form action="processForm" method="post" style="margin: 0 auto"> <br>
    First Name <input type="text" name="FName"> <br>
    Last Name <input type="text" name="LName"> <br>
    Email <input type="email" name="Email"> <br>
    Phone Number <input type="tel" name="TelNum"> <br>
    Password <input type="password" name="PWord"> <br>
    Confirm Password <input type="password" name="checkPWord"> <br>
    <input type="submit" value="Register"> <br>

</form>

</body>
</html>
