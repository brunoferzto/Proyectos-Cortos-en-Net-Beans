<%-- 
    Document   : CambiarProducto
    Created on : 20-may-2020, 20:27:41
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar Producto</title>
    </head>
    <body>
        <%-- Obtengo los valores--%>
        <jsp:useBean id="producto" class="beans.Producto" scope="session" />
        
        <jsp:setProperty name="producto" property="codigo" />
        <jsp:setProperty name="producto" property="descripcion" />
        <jsp:setProperty name="producto" property="precio" />
        
        <%-- Todos--%>
    <%--    <jsp:setProperty name="producto" property="*" />  --%>
    
    <jsp:forward page="index.jsp"/>
    </body>
</html>
