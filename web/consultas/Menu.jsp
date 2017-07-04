<%-- 
    Document   : Menu
    Created on : 06-nov-2016, 19:19:59
    Author     : Spark
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>
        <h1>Menu Disponible</h1>
        <%
            Persona p = new Persona();
            ArrayList<String> Sucursales = new ArrayList<String>();
            p.conecta();
            Sucursales = p.getSucursales();
            p.desconecta();
            if(Sucursales.size() > 0){
                for(String a : Sucursales)
                    out.write(a + "<br>");
            }else{
                out.write("No hay Sucursales Registradas");
            }
        %>
        <form action="Menu_proceso.jsp" method="post"> 
                    Numero de Sucursal  <input type="text" required="true" name="sucursal">
                    <input type="submit" value="Buscar">
        </form>
    </body>
</html>
