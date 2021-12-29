<%-- 
    Document   : choose
    Created on : 18-may-2020, 18:49:16
    Author     : Bruno
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JSTL - choose</title>
    </head>
    <body>
        <h1>Ejemplo JSTL</h1>
        <h2>choose</h2>
        
        <form>
            <p>
                <input type="text" name ="valor"/>
                <input type="submit" value ="Enviar"/></p>
        </form>
        <%-- Choose varios cambinos posible, cada camino un when--%>
        <c:choose>
            <c:when test ="${param.valor < 10.0}">
                <p>El valor es menor a 10</p>
            </c:when>
                <c:when test ="${param.valor > 10.0}">
                <p>El valor es mayor a 10</p>
            </c:when>
                <c:when test ="${param.valor == 10.0}">
                <p>El valor es  10</p>
            </c:when>
            <c:otherwise>
                <p>Parece que no ingreso ningun valor xD</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>
