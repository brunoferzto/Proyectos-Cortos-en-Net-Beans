<%-- 
    Document   : forEachPaso
    Created on : 18-may-2020, 19:01:50
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JSTL - foreach con Paso</title>
    </head>
    <body>
        <h1>Ejemplo de JSTL</h1>
        <h2>ForEach con Paso</h2>
        
         <form>
            <p>
                <input type="text" name ="valor"/>
                <input type="submit" value ="Enviar"/>
            </p>
        </form>
        
        <p>
        <c:forEach begin="1" end ="${param.valor}" step="2" var ="vuelta">
            Vuelta Nro. ${vuelta} <br/>            
        </c:forEach>
        </p>
    </body>
</html>
