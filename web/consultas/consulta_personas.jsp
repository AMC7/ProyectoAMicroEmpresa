<%-- 
    Document   : consulta_personas
    Created on : 29-oct-2016, 0:52:34
    Author     : erick
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
        <h1>Consulta Personas</h1>
        <%
            Persona p = new Persona();
            ArrayList personas = new ArrayList();

            p.conecta();
            personas = p.getPersonas();
            p.desconecta();

            if (personas.size() > 0) {
                for (int i = 0; i < personas.size(); i++) {
                    int id = ((Persona) personas.get(i)).getId();
                    String app = ((Persona) personas.get(i)).getApp();
                    String nombre = ((Persona) personas.get(i)).getNombre();
                    String fecha = ((Persona) personas.get(i)).getFecha_nac();
                    out.write(i + 1 + " | " + app + " " + nombre + " " + fecha + "<br>");
                }
            } else {
                out.write("No hay personas registradas");
            }
        %>
    </body>
</html>
