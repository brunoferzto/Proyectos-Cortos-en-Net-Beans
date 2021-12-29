<%-- 
    Document   : out
    Created on : 18-may-2020, 18:16:43
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de JSTL - out</title>
    </head>
    <body>
        <h1>Ejemplo de JSTL</h1>
        <h2>out</h2>
        
        <form>
            <p>
                <input type="text" name ="valor"/>
                <input type="submit" value ="Enviar"/></p>
        </form>
        <p>Parametro Valor: <%-- Si no enevia el parametro valor se mustra x defecto--%>
            <c:out value="${param.valor}" default="¡Atención! Para probar el ejemplo debe escribir algo" />
        </p>
        
    </body>
</html>
