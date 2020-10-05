<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<header>
    <c:if test="${sessionScope.user != null}">
        Bienvenido, ${sessionScope.user.userName}!
    </c:if>

    <nav>
        <c:choose>
            <%-- Si no hay usuario, que pueda ir al login --%>
            <c:when test="${sessionScope.user == null}">
                <a href="/login">Login</a>
            </c:when>

            <%-- Menu para el usuario que es admin --%>
            <c:when test="${sessionScope.user.admin}">
                <a href="/trucks">Camiones</a> |
                <a href="/drivers">Choferes</a> |
                <a href="/truck-drivers">Choferes de camiones</a> |
                <a href="/trips">Viajes</a> |
                <a href="/logout">Logout</a>
            </c:when>

            <%-- Menu para el usuario que es chofer --%>
            <c:otherwise>
                <a href="my-trips">Mis Viajes</a> |
                <a href="/logout">Logout</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>
