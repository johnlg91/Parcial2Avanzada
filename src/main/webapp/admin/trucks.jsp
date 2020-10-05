<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Camionero - Camiones</title>
</head>
<body>

<jsp:include page="/common/header.jsp"/>

<h1>Camiones</h1>

<section>
    ${msg}
</section>

<section>
    <table>
        <thead>
            <tr>
                <th>
                    Patente
                </th>
                <th>
                    Marca
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="track" items="${trucks}">
                <tr>
                    <td>${track.plateNumber}</td>
                    <td>${track.model}</td>
                    <td>
                        <form action="/trucks" method="delete">
                            <button type="submit">Borrar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<section>
    <form action="/trucks" method="post">
        <div>
            <label>Patente:</label>
            <input type="number" name="plate_number"/>
        </div>
        <div>
            <label>Marca:</label>
            <input type="text" name="brand"/>
        </div>
        <button type="submit">Guardar</button>
    </form>
</section>

</body>
</html>