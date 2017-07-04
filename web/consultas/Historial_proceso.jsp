<%-- 
    Document   : Historial_proceso
    Created on : 06-nov-2016, 16:30:06
    Author     : Spark
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<a href="../index.html">Inicio</a>
<br>
<h1>Historial de Ordenes</h1>
<% 
    String cliente = request.getParameter("cliente");
    ArrayList<String> Ordenes = new ArrayList<String>();
    Persona p = new Persona();
    p.conecta();
    Ordenes = p.getHistorial(cliente);
    p.desconecta();
    if(Ordenes.size() > 0){
        for(String a: Ordenes)
            out.write(a + "<br>");
    }else{
        out.write("No hay Ordenes registradas para este cliente");
    } 
%>