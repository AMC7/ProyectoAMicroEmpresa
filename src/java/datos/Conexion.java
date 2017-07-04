/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.Empleado;
import control.Persona;
import control.Proveedor;
import control.Sucursal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Conexion {
    
    //Creamos nuestros objetos para la comunicacion y ejecucion de codigo SQL
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    //Constructor    
    public Conexion() {
        stmt = null;
        con = null;
        rs = null;
    }

    /*
     * Metodo que nos permite abrir la conexion con una base de datos 
     * especificada en el parametro de entrada del metodo que ha sido
     * invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   nombrebase - nombre de la base de datos a la cual nos 
     *          conectaremos
     */
    public void conectar()
            throws Exception {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;" +
                                    "database=pastorenchilado;" +
                                    "user=sa;" +
                                    "password=1234"; 
            con = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " conectar =(");
        }
    }

    /*
     * Metodo que nos permite cerrar la conexion con una base de datos 
     * el metodo debe ser invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   sin parametros     
     */
    public void desconectar()
            throws SQLException {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " desconectar =(");
        }
    }
    
    public ArrayList getPersonas() throws Exception {
        ArrayList personas = new ArrayList();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdPersona, sApp, sNombre, dFechaNacimiento FROM persona;");
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setApp(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setFecha_nac(rs.getString(4));
                personas.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getPersonas");
        }
        return personas;
    }

    public ArrayList getClientes()throws Exception {
        ArrayList<String> Cliente = new ArrayList<String> ();
        String p = "";
        try{
           stmt = con.createStatement();
           rs = stmt.executeQuery("SELECT nIdCliente,sNombre,sApp,sApm FROM Cliente A JOIN Persona B ON A.nIdPersona = B.nIdPersona");
           while(rs.next()){
               p = "nIdCliente = " + rs.getInt(1) + " | " + rs.getString(2) + " " + rs.getString(3) + rs.getString(4);
               Cliente.add(p);
           }
           rs.close();
           stmt.close();
        }catch (Exception ex){
            System.out.println("SQLException: " + ex.getMessage() + " getPersonas");
        }
        return Cliente;
    }
    public ArrayList getHistorial(String c) throws Exception {
        ArrayList<String> Ordenes = new ArrayList<String>();
        String p = "";
         try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT A.nIdCliente,nIdPersona,sNombre,sApp,sApm,nIdOrden,dFecha,bDomicilio,nCantidad,mTotal FROM " +
                                    "(SELECT O.nIdOrden,nIdCliente,nCantidad,bDomicilio,mTotal,dFecha FROM  " +
		"(SELECT nIdOrden,nIdCliente,nCantidad,bDomicilio FROM DetalleOrden) AS DO JOIN " +
		"(SELECT nIdOrden,mTotal,dFecha FROM Orden) AS O ON DO.nIdOrden = O.nIdOrden) AS A JOIN " +
	"(SELECT nIdCliente,C.nIdPersona,sApp,sApm,sNombre FROM " +
		"(SELECT nIdCliente,nIdPersona FROM Cliente WHERE nIdCliente = " + c + ") AS C JOIN " +
		"(SELECT nIdPersona,sApp,sApm,sNombre FROM Persona) AS P ON (C.nIdPersona = P.nIdPersona)) AS B ON A.nIdCliente = B.nIdCliente");
            int pos = 1;
            while (rs.next()) {
                if(pos == 1){
                    p = "nIdCliente = " + rs.getInt(1) + " nIdPersona = " + rs.getInt(2) + " Nombre Cliente = " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5);
                    Ordenes.add(p);
                    p = "nIdOrden = " + rs.getString(6) + " dFecha = " + rs.getString(7) + " bDomicilio = " + rs.getString(8) + " nCantidad = " + rs.getString(9) + " mTotal = " + "$" + rs.getString(10);
                    Ordenes.add(p);
                    pos++;
                }else{
                    p = rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8) + "     " + rs.getString(9);
                    Ordenes.add(p);
                }
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getHistorial");
        }
        return Ordenes;        
    }
    
    public ArrayList getSucursales() throws Exception{
        ArrayList<String> Sucursal = new ArrayList<String>();
        String p = "";
        try{
           stmt = con.createStatement();
           rs = stmt.executeQuery("SELECT nIdSucursal, sNombre FROM Sucursal ORDER BY nIdSucursal");
           while(rs.next()){
               p = "nIdSucursal = " + rs.getInt(1) + " |  Nombre = " + rs.getString(2);
               Sucursal.add(p);
           }
           rs.close();
           stmt.close();
        }catch (Exception ex){
            System.out.println("SQLException: " + ex.getMessage() + " getPersonas");
        }
        return Sucursal;
    }
    
    public ArrayList getMenu(String a) throws Exception{
        ArrayList<String> Menu = new ArrayList<String>();
        String p = "";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT sProducto,mPrecio FROM (SELECT nIdProducto,mPrecio FROM Sucursal_producto WHERE nIdSucursal = " + a + " AND bActivo = 1) A JOIN Producto B ON a.nIdProducto = B.nidProducto");
            while(rs.next()){
                p = rs.getString(1) + " -- " + "$" + rs.getInt(2);
                Menu.add(p);
            }
            rs.close();
            stmt.close();
        }catch (Exception ex){
            System.out.println("SQLException: " + ex.getMessage() + " getMenu");
        }
        return Menu;
    }
    
    public ArrayList getMenu2(String a) throws Exception{
        ArrayList<String> Menu = new ArrayList<String>();
        String p = "";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT DISTINCT B.nIdProducto, sProducto,mPrecio FROM (SELECT nIdProducto,mPrecio FROM Sucursal_producto WHERE nIdSucursal = " + a + " AND bActivo = 1) A JOIN Producto B ON a.nIdProducto = B.nidProducto");
            while(rs.next()){
                p = "idProducto: " + rs.getString(1) + " Producto: " + rs.getString(2) + " -- " + "$" + rs.getInt(3);
                Menu.add(p);
            }
            rs.close();
            stmt.close();
        }catch (Exception ex){
            System.out.println("SQLException: " + ex.getMessage() + " getMenu");
        }
        return Menu;
    }
    
    public int setEstado(String estado) throws SQLException {
        int b = 0;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO CEstado(sestado) VALUES ('" + estado + "');");
            b = 1;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + " getActivaSede =(");
        }
        return b;
    }
    
    public int setPersona(String a, String b, String c, String d, String e, String f) throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Persona VALUES ('" + a + "', '"+ b + "', '" + c + "', '" + d + "', '" + e + "', '"+ f + "');" );
            p = 1;
            stmt.close();
        } catch (SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " setPersona()");
        }
        return p;
    }
    
    public int getnIdPersonaReciente() throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT MAX(nIdPersona) AS MAX FROM Persona;");
            rs.next();
            p = rs.getInt(1);
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " getnIdPersonaReciente()");
        }
        return p;
    }
    
    public int getnIdProveedorReciente() throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT MAX(nIdProveedor) AS MAX FROM Proveedor;");
            rs.next();
            p = rs.getInt(1);
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " getnIdProveedorReciente()");
        }
        return p;
    }
    
    public int setTelefono(String q) throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Telefono VALUES ('" + q + "', 'true');");
            rs = stmt.executeQuery("SELECT MAX(nIdTelefono) AS MAX FROM Telefono;");
            rs.next();
            p = rs.getInt(1);
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.err.println("SQLRxception: " + ex.getMessage() + " setCliente()");
        }
        return p;
    }
    
    public int setPersonaTelefono(String p, String t, String tp) throws SQLException{
        int b = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Persona_Telefono VALUES ('" + p + "', '" + t + "', 'true', '" + tp + "');");
            b = 1;
            stmt.close();
        } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " setPersonaTelefono");
        }
        return b;
    }
    
    public int setCliente(String a, String b, String c, String d) throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Cliente VALUES ('" + a + "', '" + b + "', '" + c + "', 1, '" + d + "');");
            p = 1;
            stmt.close();
        }catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " setCliente()");
        }
        return p;
    }
    
    public ArrayList getEstados() throws SQLException {
        ArrayList<String> Estados = new ArrayList<String>();
        String p = "";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdEstado,sEstado FROM CEstado ORDER BY nIdEstado");
            while(rs.next()){
                p = "nIdEstado = " + rs.getString(1) + " | " + rs.getString(2);
                Estados.add(p);
            }
            rs.close();
            stmt.close();
        }catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage() + " getEstados");
        }
        return Estados;
    }
    
    public ArrayList getMunicipios(String e) throws SQLException {
        ArrayList<String> Municipios = new ArrayList<String>();
        String p = "";
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdMunicipio,sMunicipio FROM CMunicipio WHERE nIdEstado = " + e + ";");
            while(rs.next()){
                p = "nIdMunicipio = " + rs.getString(1) + " | " + rs.getString(2);
                Municipios.add(p);
            }
            rs.close();
            stmt.close();
        }catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage() + " getMunicipios");
        }
        return Municipios;
    }

    public int setDireccion(String calle, String col, String Cp, String obs, String mun) throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Direccion VALUES ('" + calle + "', '" + col + "', '" + Cp + "', '" + obs + "', 1, '" + mun + "');");
            p = 1;
            rs = stmt.executeQuery("SELECT MAX(nIdDireccion) AS MAX FROM Direccion;");
            rs.next();
            p = rs.getInt(1);
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " setDireccion()");
        }
        return p;
    }
    
    public int setproveedor(String pro, String rfc,String d) throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Proveedor VALUES ('" + pro + "', '" + rfc + "', '1', '" + d + "');");
            p = 1;
            stmt.close();
        } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " setproveedor()");
        }
        return p;
    }    

    public int setIngrediente(String i) throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Ingrediente VALUES ('" + i + "', '1');");
            p = 1;
            rs = stmt.executeQuery("SELECT MAX(nIdDireccion) AS MAX FROM Ingrediente;");
            stmt.close();
            rs.next();
            p = rs.getInt(1);  
            rs.close();
            stmt.close();
        } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " setProveedor()");
        }
        return p;
    } 
    
   public int setProvSuc(String f, String c,String can,int prov, int ing, int suc) throws SQLException {
        int p = 0;
        try{
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Proveedor_Ingrediente VALUES ('" + f + "', '" + c + "', '" + can + "', '" + prov + "', '" + ing + "', '" + suc + "');");
            p = 1;
            stmt.close();
        } catch(SQLException ex){
            System.err.println("SQLException: " + ex.getMessage() + " setProvSuc()");
        }
        return p;
    }
   
   public int setPrecio(String id, String precio) throws SQLException{
       int p = 0;
       try{
           stmt = con.createStatement();
           stmt.executeUpdate("UPDATE Sucursal_Producto SET mPrecio = " + precio + "WHERE nIdProducto= " + id);
           p = 1;
           stmt.close();
       }catch(SQLException ex)
       {
           System.out.println("SQLException: " + ex.getMessage() + " setPrecio()");
       }
       return p;
   }  
   
 /** La lista de proveedores de una sucursal en específico.
Hint: recuperar los clientes y sucursales con una consulta y asignar los datos a un SELECT para después pasar el
id como parámetro de la consulta que se pide.*/

    public ArrayList<Proveedor> getListaProveedores(String Sucursal){
        ArrayList<Proveedor> proveedor = new ArrayList<Proveedor>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(""
            		+ "SELECT PR.nIdProveedor,PR.sProveedor,PR.sProveedor,PR.bActivo,PR.nIdDireccion"
            		+ " FROM SUCURSAL S JOIN PROVEEDOR_INGREDIENTE P ON S.nIdDireccion= p.nIdSucursal "
            		+ "JOIN PROVEEDOR PR ON PR.nIdProveedor = P.nIdProveedor"
            		+ " WHERE S.nIdSucursal = "+Sucursal+"; ");
           
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.nIdProveedor =(rs.getInt(1));
                p.sProveedor=(rs.getString(2));
                p.sRFC=(rs.getString(3));
                p.bActivo=(rs.getInt(4));
                p.nIdDireccion=(rs.getInt(5));		 
                proveedor.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return proveedor;
    }
    
    
    /** Todos los datos de empleados de la cadena agrupados por tipo de empleado.*/
    public ArrayList<Empleado> getListaEmpleados(){
        ArrayList<Empleado> proveedor = new ArrayList<Empleado>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(	""
            		+ "SELECT * "
            		+ "FROM Empleado E JOIN PERSONA P ON E.nIdPersona=P.nIdPersona "
                       +"                 JOIN SUCURSAL S ON E.nIdSucursal=S.nIdSucursal"
                    + " GROUP BY E.nIdTipoempleado,E.nIdSucursal,E.nIdEmpleado,\n" +
"   E.dFechaContratacion,E.sRFC,E.bActivo,E.nIdPersona,E.nIdTipoempleado,\n" +
"   E.nIdPersona,P.sNombre,P.sApp,P.sApm,P.dFechaNacimiento,P.sCorreo,P.nIdPersona,\n" +
"   S.bACtivo,S.bAdomicilio,S.nIdDireccion,S.nIdSucursal,S.nIdTelefono,S.nIdTipoSucursal,S.sNombre;"
                    );
            		
           
            while (rs.next()) {
            	  Empleado p = new Empleado();
                  p.nIdEmpleado=rs.getInt(1);
                  p.dFechaContratacion=rs.getString(2);
                  p.sRFC=rs.getString(3);
                  p.bActivo=rs.getInt(4);
                  p.nIdPersona=rs.getInt(5);
                  p.nIdSucursal=rs.getInt(6);
                  p.sSucursal=rs.getString(15);
                  p.nIdTipoempleado=rs.getInt(7);
                  p.sApp=rs.getString(9);
                  p.sApm=rs.getString(10);
                  p.sNombre=rs.getString(11);
                  p.dFechaNacimiento=rs.getString(12);
                  p.sCorreo=rs.getString(13);
                  proveedor.add(p);
              
             
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return proveedor;
    }
    
   
    /** Todos los datos de las sucursales de la cadena agrupadas por estado.*/
    public ArrayList<Sucursal> getInfoDeSucursales(){
        ArrayList<Sucursal> proveedor = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(	""
            		+"SELECT * FROM SUCURSAL S JOIN DIRECCION D ON S.nIdDireccion=D.nIdDireccion"
                    +" JOIN TELEFONO T ON S.nIdTelefono=T.nIdTelefono"
				    +" JOIN CMunicipio C ON D.nIdMunicipio=C.nIdMunicipio"
					+" JOIN CEstado E ON E.nIdEstado=C.nIdEstado"
                                        +" JOIN CTipo_Sucursal TS ON TS.nIdTipoSucursal=S.nIdTipoSucursal"
					+" GROUP BY D.nIdMunicipio,D.bActivo,D.nIdDireccion,D.nIdMunicipio"
					+ ",D.sCalle,D.sColonia,D.sCp,D.sObservaciones,S.bACtivo,S.bAdomicilio"
					+",S.nIdDireccion,S.nIdSucursal,S.nIdTelefono,S.nIdTipoSucursal,S.sNombre,"
					+ "T.bActivo,T.nIdTelefono,T.sTelefono,C.nIdEstado,C.nIdMunicipio"
					+" ,C.sMunicipio,E.nIdEstado,E.sEstado"
                                        + ",TS.nIdTipoSucursal,TS.sTipoSucursal;" );
            while (rs.next()) {
            	 Sucursal p = new Sucursal();
                 p.nIdSucursal=rs.getInt(1);
                 p.sNombre=rs.getString(2);
                 p.bAdomicilio=rs.getString(3);
                 p.bActivo=rs.getInt(4);
                 p.nIdDireccion=rs.getInt(5);
                 p.nIdTelefono=rs.getInt(6);
                 p.nIdTipoSucursal=rs.getInt(7);
                 
                 p.sCalle=rs.getString(9);
                 p.sColonia=rs.getString(10);
                 p.sCp=rs.getInt(11); 
                 p.sObservaciones=rs.getString(12);
                 
                 p.nIdMunicipio=rs.getInt(14);
                 
                 p.sTelefono=rs.getString(16);
                 
                 
                 p.sMunicipio=rs.getString(19);
                 p.nIdEstado=rs.getInt(20);
                 p.sEstado=rs.getString(22);
                 
                 p.sTipoDeSucursal=rs.getString(24);
                 proveedor.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return proveedor;
    }
   
}