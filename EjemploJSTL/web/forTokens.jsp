<%-- 
    Document   : forTokens
    Created on : 18-may-2020, 19:57:29
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de JSTL - forTokens</title>
    </head>
    <body>
        <h1>Ejemplo de JSTL</h1>
        <h2>forTokens</h2>
        
        <p>
            <c:forTokens items ="Argentina,Brasil,Paraguay,Uruguay,Venezuela" delims ="," var="pais">
                ${pais}<br/>
            </c:forTokens>
        </p>
    </body>
</html>
