<%-- 
    Document   : Error
    Created on : 25-may-2020, 19:18:37
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejercicio JSP, Servlets y Beans</h1>
        <h2>Error</h2>
        
        <p>Se ha producido el siguiente error:</p>
        <p>${pageContext.exception.message}</p>
    </body>
</html>
