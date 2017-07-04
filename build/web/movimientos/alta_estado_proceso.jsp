<%-- 
    Document   : alta_estado_proceso
    Created on : 29-oct-2016, 1:30:29
    Author     : erick
--%>

<%@page import="control.Estado"%>
<%
    String estado = request.getParameter("estado");

    Estado e = new Estado();

    int b = 0;

    e.conecta();
    b = e.setEstado(estado);
    e.desconecta();
    
    %>
    <a href="../index.html">Inicio</a>
    <%
    
    if(b == 1){
        out.write("Estado Registrado");
    }else{
        out.write("No se Registró el Estado");
    }
%>