package control;

public class Empleado {
	
 public int nIdTipoempleado;
 public int nIdSucursal;
 public int nIdEmpleado;
 public String dFechaContratacion;
 public String sRFC;
 public int bActivo;
 public int nIdPersona;
 public String sNombre;
 public String sApp;
 public String sApm;
 public String dFechaNacimiento;
 public String sCorreo;
    public String sSucursal;
 
@Override 
 public String toString(){
	 return "IdTipoempleado ="+nIdTipoempleado+"<br>"
                + "nIdSucursal ="+nIdSucursal  +"<br>"
                  + "sSucursal ="+sSucursal  +"<br>"
                 + "nIdEmpleado ="+nIdEmpleado +"<br>"
                 + "dFechaContratacion ="+dFechaContratacion +"<br>"
                 + "sRFC ="+sRFC +"<br>"
                 + "bActivo ="+bActivo  +"<br>"
                 + "nIdPersona ="+nIdPersona +"<br>"
                 + "sNombre ="+sNombre +"<br>"
                 + "sApp ="+sApp +"<br>"
                 + "sApm ="+sApm +"<br>"
                 + "dFechaNacimiento ="+dFechaNacimiento +"<br>"
                 + "sCorreo ="+sCorreo +"<br>";
 }

}
