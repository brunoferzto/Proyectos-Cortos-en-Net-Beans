<%-- 
    Document   : MostrarProducto
    Created on : 25-may-2020, 19:11:37
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <jsp:useBean id="producto" class ="beans.Producto" scope="request" />

        <h1>Mostrar Producto</h1>
        
        
        <p><strong>Código:</strong><jsp:getProperty name="producto" property="codigo"/></p>
        <p><strong>Descipción:</strong><jsp:getProperty name="producto" property="descripcion"/></p>
        <p><strong>Costo:</strong><jsp:getProperty name="producto" property="costo"/></p>
        <p><strong>Stock:</strong><jsp:getProperty name="producto" property="stock"/></p>
        
        <br />
        <p><strong>Descripcion</strong> <%= producto.getDescripcion() %></p>
        <br />
        <p><strong>Descripcion</strong> ${producto.descripcion}</p>


    </body>
</html>
