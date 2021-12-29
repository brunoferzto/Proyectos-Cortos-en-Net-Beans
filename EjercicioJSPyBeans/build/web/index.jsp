<%-- 
    Document   : index
    Created on : 25-may-2020, 15:47:29
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio de JSP y Beans</title>
    </head>
    <body>
        <jsp:useBean id="rotadorMensaje" class="Beans.RotadorMensaje" scope="session" />

        <h1>Ejercicio de JSP y Beans</h1>
        
        <p><jsp:getProperty name ="rotadorMensaje" property="mensaje" /></p>
    </body>
</html>
