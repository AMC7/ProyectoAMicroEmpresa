<%-- 
    Document   : Actualiza_precio_proceso
    Created on : 08-nov-2016, 21:44:15
    Author     : Antonio
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualiza Precio</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>
        <h1>Actualiza Precio</h1>
        <%
            String idSucursal = request.getParameter("idSucursal");
            Persona p = new Persona();
            ArrayList<String> Productos = new ArrayList<String>();
            p.conecta();
            Productos = p.getMenu2(idSucursal);            
            p.desconecta();
            if(Productos.size() > 0){
                for(String a : Productos)
                    out.write(a + "<br>");                
            }else{
                out.write("No hay productos registrados");
            }                
        %>
        <form action="Registrar_precio.jsp" method="post"> 
            nuevo precio <input type="text" required="true" name="precio">
            <br>
            idProducto <input type="text" required="true" name="idProducto">
            <br>               
            <input type="submit" value="Siguiente">
        </form>
    </body>
</html>
