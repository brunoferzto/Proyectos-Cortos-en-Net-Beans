<%-- 
    Document   : ProvocarOtroError
    Created on : 15-may-2020, 18:01:03
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="OtroError.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Ejemplo de Pagina de Error - Provocar Otro Error</title>
    </head>
    <body>
        <%
            if("Provocar Error".equals(request.getParameter("accion"))){
            int resultado = 1 / 0;
            }
        %>
        <h1>Ejemplo de Página de Error - Provocar Otro Error</h1>
        <form>
            <p><input type="submit" name="accion" value ="Provocar Error" /></p>
        </form>
    </body>
</html>
