<%-- 
    Document   : Registro_cliente
    Created on : 06-nov-2016, 22:28:52
    Author     : Spark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Direccion Proveedor</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>
        <h1>Registro Cliente</h1>
        <form action="Registro_cliente_proceso.jsp" method="post">
            Apellido Paterno  <input type="text" required="true" name="sApp">
            <br>
            Apellido Materno  <input type="text" required="true" name="sApm">
            <br>
            Nombre(s)  <input type="text" required="true" name="sNombre">
            <br>
            Fecha de Nacimiento (AAAA-MM-DD)  <input type="text" required="true" name="dFn">
            <br>
            Telefono (XX-XX-XX-XX-XX) <input type="text" required="true" name="sTelefono">
            <br>
            Tipo Telefono (1-Local, 2-Movil, 3-Oficina)
            <br>
            <input type="text" required="true" name="sTT">
            <br>
            Correo Electronico  <input type="text" required="true" name="sCorreo">
            <br>
            Genero (M-F)  <input type="text" required="true" name="sGenero">
            <br>
            Monedero (XXXX-XXXX-XXXX-XXXX)  <input type="text" required="true" name="sMonedero">
            <br>
            Saldo  <input type="text" required="true" name="mSaldo">
            <br>
            Fecha de Registro (AAAA-MM-DD) <input type="text" required="true" name="dFr">
            <br>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
