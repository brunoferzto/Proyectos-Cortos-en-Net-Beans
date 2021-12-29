<%-- 
    Document   : forEachColeccion
    Created on : 18-may-2020, 19:21:35
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JSTL - ForEach con Colección</title>
    </head>
    <body>
        <h1>Ejemplo de JSTL</h1>
        <h2>ForEach con Colección </h2>
        <%-- creo variable dias la guardo en scope page y le doy el valor, luego lo muesto--%>
        <c:set var ="dias" scope="page" value="${fn:split('Lunes,Martes,Miercoles,Jueves,Viernes,Sabado,Domingo', ',')}" />
        <p>
            <c:forEach items="${dias}" var ="dia">
                ${dia} <br />
                
                
            </c:forEach>
                
                
        </p>
    </body>
</html>
