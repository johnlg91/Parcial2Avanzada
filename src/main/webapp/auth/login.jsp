<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Camionero Login</title>
</head>
<body>

<form action="/login" method="post">
    <div>
        ${msg}
    </div>
    <div>
        <label>Username:</label>
        <input type="text" name="username"/>
    </div>
    <div>
        <label>Password:</label>
        <input type="password" name="password"/>
    </div>
    <button type="submit">Login</button>
</form>

</body>
</html>