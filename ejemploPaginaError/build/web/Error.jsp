<%-- 
    Document   : Error
    Created on : 15-may-2020, 17:08:18
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Pagina de Error - Error</title>
    </head>
    <body style="background-color: red; color:white;">
        <h1>¡Error!</h1>
        <p>Se ha producido el sigiente error:</p>
        <p>${pageContext.errorData.throwable} </p>
    </body>
</html>
