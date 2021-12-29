<%-- 
    Document   : index
    Created on : 20-may-2020, 20:07:29
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de JSP y Beans</title>
        <link rel="stylesheet" href="css/estilos.css" />
    </head>
    <body>
        <jsp:useBean  id="producto" class="beans.Producto" scope="session">
            
            <jsp:setProperty name ="producto" property="codigo" value="1"/>
             <jsp:setProperty name ="producto" property="descripcion" value="Reloj Cucú"/>   
            <jsp:setProperty name ="producto" property="precio" value="300"/>
            
        </jsp:useBean>
        
        <h1>Ejemplo de JSP y Beans </h1>
        
        <h2>Producto Actual:</h2>
        
        <p>Codigo: <jsp:getProperty name="producto" property="codigo" /></p>
        <p>Descripcion: <jsp:getProperty name="producto" property="descripcion" /></p>
        <p>Precio: <jsp:getProperty name="producto" property="precio" /></p>
        
        <h2>Cambiar por: </h2>
        <form action="CambiarProducto.jsp" method="post" accept-charset="ISO-8859-1">
            <div>
                <label for="codigo">Codigo:</label>
                <input type="text" name="codigo" id="codigo" />                
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <input type="text" name="descripcion" id="descripcion" />                
            </div>
            <div>
                <label for="codigo">Precio</label>
                <input type="text" name="precio" id="precio" />                
            </div>
              <div>
                <input type="submit" name="accion" value="Cambiar Producto" />                
            </div>
        </form>
    </body>
</html>
