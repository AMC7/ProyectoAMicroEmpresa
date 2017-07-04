<%-- 
    Document   : Menu_proceso
    Created on : 06-nov-2016, 20:12:48
    Author     : Spark
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.*"%>
<%@page import="datos.Conexion"%>
<a href="../index.html">Inicio</a>
<br>
<h1>Información de la sucursal</h1>
<% 
    String sucursal = request.getParameter("sucursal");
    Conexion c = new Conexion();
    c.conectar();
    ArrayList<Sucursal> Menu = c.getInfoDeSucursales();
    c.desconectar();
    if(Menu.size() > 0){
        for(Sucursal a: Menu){
          out.write(a.toString() + "<br>");
           }
    }else{
        out.write("No esta disponible la informacion de esta sucursal");
    } 
%>
