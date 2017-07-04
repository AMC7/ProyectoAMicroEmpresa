<%-- 
    Document   : Historial
    Created on : 06-nov-2016, 14:03:57
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
        <h1>Historial de Ordenes </h1>
        <%
            Persona p = new Persona();
            ArrayList<String> Clientes = new ArrayList<String>();
            p.conecta();
            Clientes = p.getClientes();
            p.desconecta();
            if(Clientes.size() > 0){
                for(String a: Clientes)
                    out.write(a + "<br>");
            }else{
                out.write("No hay Clientes registrados");
            }
        %>
        <form action="Historial_proceso.jsp" method="post"> 
                    Numero de Cliente  <input type="text" required="true" name="cliente">
                    <input type="submit" value="Buscar">
        </form>
    </body>
</html>
