<%-- 
    Document   : alta_estado
    Created on : 29-oct-2016, 1:26:53
    Author     : erick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alta Estado</h1>
        <form action="alta_estado_proceso.jsp" method="post">
            Nombre de Estado a registrar  <input type="text" required="true" name="estado">
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
