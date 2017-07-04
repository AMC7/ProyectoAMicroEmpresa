<%-- 
    Document   : Registrar_proveedor_proceso
    Created on : 07-nov-2016, 20:56:29
    Author     : Spark
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Proveedor</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>
        <h1>Registro Proveedor</h1>
        <%
            String Calle = request.getParameter("Calle");
            String Colonia = request.getParameter("Colonia");
            String Cp = request.getParameter("Cp");
            String Observaciones = request.getParameter("Observaciones");
            String Municipio = request.getParameter("Municipio");
            String Proveedor = request.getParameter("Proveedor");
            String Rfc = request.getParameter("Rfc");
            Persona p = new Persona();
            p.conecta(); 
            int b = p.setDireccion(Calle, Colonia, Cp, Observaciones, Municipio);
            p.desconecta();            
            if(b > 0){
                p.conecta();
                p.setProveedor(Proveedor,Rfc,String.valueOf(b));
                int c = p.getnIdProveedorReciente();
                out.write(c + "<br>");
                p.desconecta();
                if(c > 0){
                    out.write("");
                }else{
                    out.write("No se pudo registrar el Proveedor");
                }
            }else{
                out.write("No se pudo registrar la Direccion");
            }
        %>
        <h1>---Sucursal a Surtir ---</h1>
        <%
        Persona q = new Persona();        
        ArrayList<String> Sucursal = new ArrayList<String>();
        q.conecta();
        Sucursal = q.getSucursales();
        q.desconecta();
        if(Sucursal.size() > 0){
            for(String g : Sucursal)
                out.write(g + "<br>");            
        }else{
            out.write("No hay Sucursales Disponibles");            
        }
        %>
        
        <form action="Registrar_provSuc_proceso.jsp" method="post"> 
            ID Sucursal <input  value="4" type="text" required="true" name="Sucursal">
            <br>
            Ingrediente <input  value="4" type="text" required="true" name="Ingrediente">
            <br>              
            Fecha (AAAA-MM-DD) <input  value="4" type="text" required="true" name="Fecha">
            <br>
            Costo <input  value="4" type="text" required="true" name="Costo">
            <br>
            Cantidad <input  value="4" type="text" required="true" name="Cantidad">
            <br>              
            <input type="submit" value="Registrar">  
        </form>      
    </body>
</html>
