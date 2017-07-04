<%-- 
    Document   : Menu_proceso
    Created on : 06-nov-2016, 20:12:48
    Author     : Spark
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.Persona"%>
<a href="../index.html">Inicio</a>
<br>
<h1>Menu Disponible</h1>
<% 
    String sucursal = request.getParameter("sucursal");
    ArrayList<String> Menu = new ArrayList<String>();
    Persona p = new Persona();
    p.conecta();
    Menu = p.getMenu(sucursal);
    p.desconecta();
    if(Menu.size() > 0){
        for(String a: Menu)
            out.write(a + "<br>");
    }else{
        out.write("No hay Menu disponible en esta sucursal");
    } 
%>
