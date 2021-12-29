<%-- 
    Document   : forEach
    Created on : 18-may-2020, 18:56:05
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JSTL - forEach</title>
    </head>
    <body>
        <h1>Ejemplo JSTL </h1>
        <h2>forEach</h2>
        
         <form>
            <p>
                <input type="text" name ="valor"/>
                <input type="submit" value ="Enviar"/></p>
        </form>
        <%-- Cuenta desde 1 hasta lo que diga el Usuario--%>
        <c:forEach begin="1" end ="${param.valor}" var ="vuelta">
            Vuelta Nro. ${vuelta} <br/>            
        </c:forEach>
    </body>
</html>
