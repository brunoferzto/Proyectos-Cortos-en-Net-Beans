<%-- 
    Document   : PaginaProhibida
    Created on : 15-may-2020, 18:16:58
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Prohibida</title>
    </head>
    <body>
        <%
            if(!("admin".equals(request.getParameter("usuario"))&& "admin".equals(request.getParameter("contrasena"))))
            {
                response.sendError(403);
            }
            
            %>
        <h1>Página Prohibida</h1>
        <p>Esta es una página prohibida al público</p>
    </body>
</html>
