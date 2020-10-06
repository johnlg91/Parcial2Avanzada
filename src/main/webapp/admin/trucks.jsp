<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Camionero - Camiones</title>
</head>
<body>

<a href="/">
    <img src="/img/logo.jpg">
</a>

<h1>Camiones</h1>

<p>${msg}</p>

<%--Formulario para guardar un nuevo camion--%>
<form action="/trucks" method="post">
    <table>
        <tr>
            <th>Patente</th>
            <th>Marca</th>
        </tr>

        <tr>
            <td>
                <input type="number" name="plate_number"/>
            </td>
            <td>
                <input type="text" name="brand"/>
            </td>
            <%-- todo mandar todos los otros datos--%>
            <td>
                <button type="submit">Agregar</button>
            </td>
        </tr>

        <c:forEach var="truck" items="${trucks}">
            <tr>
                <td>${truck.plateNumber}</td>
                <td>${truck.brand}</td>
                <%-- todo mostrar todos los otros datos--%>
                <td>
                    <form action="/trucks" method="delete">
                        <input type="hidden" name="id" value="${truck.plateNumber}"/>
                        <button type="submit">Borrar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>