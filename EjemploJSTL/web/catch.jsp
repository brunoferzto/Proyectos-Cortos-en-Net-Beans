<%-- 
    Document   : catch
    Created on : 18-may-2020, 20:01:47
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JSTL - catch</title>
    </head>
    <body>
        <h1>Ejemplo de JSTL</h1>
        <h2>catch</h2>
        
        <form>
            <p>
                <input type="text" name ="valor"/>
                <input type="submit" value ="Enviar"/></p>
        </form>
        
        <c:catch var="ex">
         <c:if test="${param.valor > 100}">
            <p>El valor es bastante grande...</p>
         </c:if>
        </c:catch>
            
            <c:if test="${ex != null}">
                <p>Se produjo una excepcion de tipo: ${ex}</p>
                <p>Mensaje de la excepcion: ${ex.message}</p>
            </c:if>
            
    </body>
</html>
