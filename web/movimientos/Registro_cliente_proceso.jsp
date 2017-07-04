<%-- 
    Document   : Registro_cliente_proceso
    Created on : 06-nov-2016, 22:46:44
    Author     : Spark
--%>

<a href="../index.html">Inicio</a>
<br>
<%@page import="control.Persona"%>
<%
    String sApp = request.getParameter("sApp");
    String sApm = request.getParameter("sApm");
    String sNombre = request.getParameter("sNombre");
    String dFn = request.getParameter("dFn");
    String Telefono = request.getParameter("sTelefono");
    String sTT = request.getParameter("sTT");
    String sCorreo = request.getParameter("sCorreo");
    String sGenero = request.getParameter("sGenero");
    String sMonedero = request.getParameter("sMonedero");
    String mSaldo = request.getParameter("mSaldo");
    String dFr = request.getParameter("dFr");
    Persona p = new Persona();
    int b = 0;
    int tp = Integer.parseInt(sTT);
    if(tp < 4 && tp > 0){
        p.conecta();
        b = p.setPersona(sApp,sApm,sNombre,dFn,sCorreo,sGenero);
        p.desconecta();      
        if(b == 1){
            int q = 0;
            String s = "";
            p.conecta();
            q = p.getnIdPersonaReciente();
            s = String.valueOf(q);
            int t = p.setTelefono(Telefono);
            if(t > 0){
                String tl = String.valueOf(t);
                t = p.setPersonaTelefono(s,tl,sTT);
                b = p.setCliente(sMonedero,mSaldo,dFr,s);
                p.desconecta();
                if(b == 1){
                    out.write("Cliente Registrado exitosamente.");
                }else{
                    out.write("No se Registro el cliente");
                }
            }else{
                out.write("No se pudo registrar el Telefono");                
            }
        }else{
            out.write("No se Registró el cliente");
        }
    }else{
        out.write("Tipo de telefono no valido");        
    }
%>
