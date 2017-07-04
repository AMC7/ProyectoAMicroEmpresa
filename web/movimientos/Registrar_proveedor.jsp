<%-- 
    Document   : Registrar_proveedor
    Created on : 07-nov-2016, 15:32:01
    Author     : Spark
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Proveedor - Direccion</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>
        <h1>Registro Proveedor - Estados Disponibles </h1>
        <%
            Persona p = new Persona();
            ArrayList<String> Estados = new ArrayList<String>();
            p.conecta();
            Estados = p.getEstados();
            p.desconecta();
            if(Estados.size() > 0){
                for(String a : Estados)
                    out.write(a + "<br>");
            }else{
                out.write("No hay Estados Registradas");
            }
        %>
        <form action="Registrar_proveedor_direccion.jsp" method="post"> 
            ID de Estado  <input type="text" required="true" name="Estado">            
            <input type="submit" value="Siguiente">
        </form>
    </body>
</html>
