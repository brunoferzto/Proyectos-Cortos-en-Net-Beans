<%-- 
    Document   : if
    Created on : 18-may-2020, 18:34:41
    Author     : Bruno
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>+
<%-- Referencio biblioteca de TAGS--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de JSTL - if</title>
    </head>
    <body>
        
        <h1>Ejemplo de JSTL</h1>
        <h2>if</h2>
        

        <form>
            <p>
                <input type="text" name ="valor"/>
                <input type="submit" value ="Enviar"/>
            </p>
        </form>
        <%-- Si se cumple entra al tag if--%>  
        <c:if test="${param.valor > 100}">
            <p>El valor es bastante grande...</p>
        </c:if>
        
    </body>
</html>
