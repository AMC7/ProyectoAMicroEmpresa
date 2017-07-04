<%-- 
    Document   : Actualiza_precio
    Created on : 08-nov-2016, 20:07:29
    Author     : Antonio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Precio</title>
    </head>
    <body>
        <a href="../index.html ">Inicio</a>
        <h1>Actualizando Precio </h1>
        <%
            Persona p = new Persona();
            ArrayList<String> sucursales = new ArrayList<String>();
            
            p.conecta();
            sucursales = p.getSucursales();
            p.desconecta();
            
            if(sucursales.size() > 0){
                for(String a : sucursales)
                    out.write(a + "<br>");
            }else{
                out.write("No hay Sucursales Registradas");
            }
        %>
         <form action="Actualiza_precio_proceso.jsp" method="post"> 
            idSucursal <input type="text" required="true" name="idSucursal">
            <br>               
            <input type="submit" value="Siguiente">
        </form>
    </body>
</html>
