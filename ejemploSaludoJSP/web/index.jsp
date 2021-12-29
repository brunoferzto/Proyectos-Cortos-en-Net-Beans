<%-- 
    Document   : index
    Created on : 14-may-2020, 0:13:12
    Author     : Bruno
--%>
<%-- Esta directiva solo se procesa una vez (no en c/request)--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- Scriplets declaración (Estaran disponibles en el servlet que se generará
a partir de este documento jsp--%>
<%!
    private String accion, nombre; 

    private String finDocumento(){return "Fin del Documento";}
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludo en JSP</title>
    </head>
    <body>
        <%
            accion = request.getParameter("accion");
            nombre = request.getParameter("nombre");
            
            if(session.getAttribute("primerMensaje") == null){
            session.setAttribute("primerMensaje", "Bienvenido/a a Java Web");
            session.setAttribute("segundoMensaje", "Esperamos que lo disfrutes");}
            %>
            
            <jsp:include page="Titulo">
                <jsp:param name="subtitulo" value = "S" />               
            </jsp:include>
            
            <form>
                <P> <label for="nombre">Escribe tu Nombre</label>
                    <input type ="text" name="nombre" id="nombre"/>
                    <input type="submit" name="accion" value="Saludar" />
                </P>
            </form>
            
            <% if("Saludar".equals(accion) && nombre != null && nombre.length() > 0) { %>
            <%-- Estoy dentro del if pero no en codigo Java, puedo cambiar de modo Scriplets a modo Java, JSP en cualquier
                momento--%>
                <p>¡Hola! <%= nombre %> </p>
            <%-- Expresion EL obtenemos el parametro que llega en el request--%>
            <p>¡Chau! ${param.nombre}</p>
            <% } %>
            <%-- Mostrar lo de la Session--%>
            <p><%= session.getAttribute("primerMensaje") %></p>
            
            <p>${segundoMensaje }</p>
            
            <p><%=finDocumento() %></p>
            
    </body>
</html>
