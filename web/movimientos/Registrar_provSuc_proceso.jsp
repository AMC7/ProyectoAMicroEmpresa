<%-- 
    Document   : Registrar_provSuc_proceso
    Created on : 07-nov-2016, 23:20:28
    Author     : Spark
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <a href="../index.html">Inicio</a>
    <br>
<%
    String Sucursal = request.getParameter("Sucursal");
    String Ingrediente = request.getParameter("Ingrediente");
    String Fecha = request.getParameter("Fecha");
    String Costo = request.getParameter("Costo");
    String Cantidad = request.getParameter("Cantidad");
    Persona q = new Persona();
    q.conecta();
    int prov = q.getnIdProveedorReciente();
    int ing = q.setIngrediente(Ingrediente);
    int suc = Integer.parseInt(Sucursal);
    int c = q.setProvSuc(Fecha, Costo, Cantidad, prov, ing, suc);
    q.desconecta();    
    if(c == 1){
        out.write("Provedor Registrado con Sucursal");
    }else{
        out.write("No se Registró el Proveedor con la Sucursal");
    }
%>