<%-- 
    Document   : OtroError
    Created on : 15-may-2020, 17:12:11
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Pagina de Error - Otro Error</title>
    </head>
    <body style="background-color: orange; color:white;">
        <h1>¡Otro Error!</h1>
        <p>Se ha producido el sigiente error:</p>
        <p>${pageContext.errorData.throwable} </p>
    </body>
</html>
