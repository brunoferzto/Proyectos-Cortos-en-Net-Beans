<%-- 
    Document   : ProvocarUnError
    Created on : 15-may-2020, 17:32:34
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Pagina de Error - Provocar un Error</title>
    </head>
    <body>
        <%
            if("Provocar Error".equals(request.getParameter("accion"))){
            int resultado = 1 / 0;
            }
        %>
        <h1>Ejemplo de Página de Error - Provocar un Error</h1>
        <form>
            <p><input type="submit" name="accion" value ="Provocar Error" /></p>
        </form>
    </body>
</html>
