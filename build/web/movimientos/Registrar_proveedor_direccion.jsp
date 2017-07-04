<%-- 
    Document   : Registrar_proveedor_direccion
    Created on : 07-nov-2016, 20:44:14
    Author     : Spark
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Direccion Proveedor</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>
        <h1>Registro Proveedor</h1>
        <%
            String Estado = request.getParameter("Estado");
            Persona p = new Persona();
            ArrayList<String> Municipios = new ArrayList<String>();
            p.conecta();
            Municipios = p.getMunicipios(Estado);            
            p.desconecta();
            if(Municipios.size() > 0){
                for(String a : Municipios)
                    out.write(a + "<br>");                
            }else{
                out.write("No hay Municipios Registrados");
            }                
        %>
        <form action="Registrar_proveedor_proceso.jsp" method="post">
                        <h1>--- Direccion Proveedor ---</h1>
            ID de Municipio  <input type="text" required="true" name="Municipio">
            <br>
            Calle  <input type="text" required="true" name="Calle">
            <br>
            Colonia  <input type="text" required="true" name="Colonia">
            <br>
            Codigo Postal  <input type="text" required="true" name="Cp">
            <br>
            Observaciones  <input type="text" required="true" name="Observaciones">
            <br>
            <h1>--- Informacion Proveedor ---</h1>
            Nombre Proveedor  <input type="text" required="true" name="Proveedor">
            <br>
            RFC  <input type="text" required="true" name="Rfc">
            <br>
            <input type="submit" value="Registrar">  
        </form>
     
    </body>
</html>
