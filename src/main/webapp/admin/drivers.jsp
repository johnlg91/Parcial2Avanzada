<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Camionero - Choferes</title>
</head>
<body>

<a href="/">
    <img src="/img/logo.jpg">
</a>

<h1>Choferes</h1>

<p>${msg}</p>


<table>
    <tr>
        <th>DNI</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Fecha Nacimiento</th>
        <th>Licencia</th>
        <th>Celular</th>
    </tr>

    <%--Formulario de AB de los choferes--%>
    <form action="drivers" method="post">

        <tr>
            <td><input type="number" name="dni"/></td>
            <td><input type="text" name="first_name"/></td>
            <td><input type="text" name="last_name"/></td>
            <td><input type="date" name="birth_date"/></td>
            <td><select name="license_category">
                <option value="HEAVY">HEAVY</option>
                <option value="MEDIUM">MEDIUM</option>
                <option value="LIGHT">LIGHT</option>
            </select> </td>
            <td><input type="number" name="cellphone"/></td>
            <td><button type="submit">Agregar</button></td>
        </tr>
    </form>
    <c:forEach var="driver" items="${drivers}">

        <tr>
            <td>${driver.dni}</td>
            <td>${driver.firstName}</td>
            <td>${driver.lastName}</td>
            <td>${driver.birthDate}</td>
            <td>${driver.licenseCategory}</td>
            <td>${driver.cellphone}</td>
            <td>
                    <%--Hace un post pero q despues lo checkea con un if para llamar al doDelete--%>
                <form action="drivers" method="post">
                    <input type="hidden" name="id" value="${driver.dni}"/>
                    <button type="submit">Borrar</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>