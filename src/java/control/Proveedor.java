package control;

public class Proveedor {
	public int nIdProveedor=0;
	public String sProveedor="";
	public String sRFC="";
	public int bActivo;
	public int nIdDireccion;
	
        @Override
	public String toString(){
		return  "nIdProveedor ="+nIdProveedor +"<br>"+ 
                        "sProveedor ="+sProveedor+"<br>"+
                        "sRFC ="+sRFC+"<br>"+
                        "bActivo ="+bActivo+"<br>"+
                        "nIdDireccion ="+nIdDireccion+"<br>";
	}

}
