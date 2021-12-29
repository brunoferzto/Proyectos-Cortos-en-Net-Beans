<%-- 
    Document   : contador
    Created on : 18-may-2020, 20:08:29
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JSTL - Contador</title>
    </head>
    <body>
        <h1>Ejemplo JSTL</h1>
        <h2>Contador</h2>
        
        <c:if test="${empty contador}">
            <c:set var="contador" scope="session" value="0"/>
        </c:if>
        
        <c:set var="contador" scope="session" value ="${contador + 1}"/>
        
        <p>Contador: ${contador}</p>
        
        <c:if test="${contador == 10}">
            <c:remove var="contador" scope ="session"/>
        </c:if>
        
    </body>
</html>
