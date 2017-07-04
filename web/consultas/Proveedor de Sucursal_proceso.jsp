<%-- 
    Document   : Menu
    Created on : 06-nov-2016, 19:19:59
    Author     : Spark
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.*"%>
<%@page import="datos.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>
        <h1>Proveedor Sucursal</h1>
        <%
          String sucursal = request.getParameter("sucursal");
          Conexion c = new Conexion();
          c.conectar();
         ArrayList<Proveedor> Menu = c.getListaProveedores(sucursal);
         c.desconectar();
         if(Menu.size() > 0){
            for(Proveedor a: Menu){
            out.write(a.toString() + "<br>");
          }
    }else{
        out.write("No esta disponible la informacion de esta sucursal");
    } 
        %>
     
    </body>
</html>
