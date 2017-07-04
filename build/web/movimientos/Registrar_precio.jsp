<%-- 
    Document   : Registrar_precio
    Created on : 09-nov-2016, 17:11:52
    Author     : Antonio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <a href="../index.html">Inicio</a>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrando Precio</title>
    </head>
    <body>
        <%
            String precio = request.getParameter("precio");
            String idProducto = request.getParameter("idProducto");
            String idSucursal = request.getParameter("idSucursal");
            Persona p = new Persona();
            p.conecta();
            p.setPrecio(idProducto,precio);
            p.desconecta();
         %>
        <h1>Nuevo Precio Actualizado!</h1>
    </body>
</html>
