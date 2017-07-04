package control;

public class Sucursal {

	public int nIdSucursal;
	public String sNombre;
	public String bAdomicilio;
	public int bActivo;
	public int nIdDireccion;
	public int nIdTelefono;
	public int nIdTipoSucursal;
	public String sCalle;
	public String sColonia;
	public int sCp;
	public String sObservaciones;
	public int nIdMunicipio;
	public String sMunicipio;
	public int nIdEstado;
	public String sEstado;
	public String sTelefono;
        public String sTipoDeSucursal;	

        @Override
	public String toString(){
		
		return "nIdSucursal ="+nIdSucursal  +"<br>"
				 +"sNombre = "+sNombre+"<br>"
				 +"bAdomicilio= "+ bAdomicilio+"<br>"
				 +"bActivo = "+ bActivo+"<br>"
				 +"nIdDireccion = "+ nIdDireccion+"<br>"
				 +"nIdTelefono = "+ nIdTelefono+"<br>"
                                 +" sTelefono = "+ sTelefono+"<br>"
				 +"nIdTipoSucursal = "+ nIdTipoSucursal+"<br>"
                                 +"sTipoSucursal = "+ sTipoDeSucursal+"<br>"
				 +"sCalle = "+ sCalle+"<br>"
				 +"sColonia = "+ sColonia+"<br>"
				 +"sCp = "+ sCp+"<br>"
				 +"sObservaciones = "+ sObservaciones+"<br>"
				 +"nIdMunicipio = "+ nIdMunicipio+"<br>"
				 +"sMunicipio = "+ sMunicipio+"<br>"
				 +"nIdEstado = "+ nIdEstado+"<br>"
				 +"sEstado = "+ sEstado+"<br>"
				 +"<br>";
		
	}

}
