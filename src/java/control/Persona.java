/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Persona extends Control{

    int id;
    String app;
    String nombre;
    String fecha_nac;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
          
    public ArrayList getPersonas() throws Exception{
        ArrayList personas = new ArrayList();
        try{
            personas = conexionBD.getPersonas();
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar las personas " + ex.getMessage());
        }
        return personas;
    }
    
    public ArrayList getClientes() throws Exception {
        ArrayList<String> Clientes = new ArrayList<String> ();
        try{
            Clientes = conexionBD.getClientes();
        } catch(Exception ex){
            System.out.println("No se pudieron recuperan clientes " + ex.getMessage());
        }
        return Clientes;
    }
    
    public ArrayList getHistorial(String c) throws Exception {
        ArrayList<String> Ordenes = new ArrayList<String>();
        try{
            Ordenes = conexionBD.getHistorial(c);
        } catch(Exception ex){
             System.out.println("No se pudieron recuperar las personas " + ex.getMessage());
        }
        return Ordenes;
    }
    
    public ArrayList getSucursales() throws Exception {
        ArrayList<String> Sucursales = new ArrayList<String> ();
        try{
            Sucursales = conexionBD.getSucursales();
        } catch(Exception ex){
            System.out.println("No se pudieron recuperan clientes " + ex.getMessage());
        }
        return Sucursales;
    }
    
    public ArrayList getMenu(String a) throws Exception {
        ArrayList<String> Menu = new ArrayList<String>();
        try{
            Menu = conexionBD.getMenu(a);
        } catch(Exception ex){
            System.out.println("No se pudo recuperar el menu disponible. "+ ex.getMessage());
        }
        return Menu;
    }
    
    public ArrayList getMenu2(String a) throws Exception {
        ArrayList<String> Menu = new ArrayList<String>();
        try{
            Menu = conexionBD.getMenu2(a);
        } catch(Exception ex){
            System.out.println("No se pudo recuperar el menu disponible. "+ ex.getMessage());
        }
        return Menu;
    }
    
    public int setPersona(String a, String b, String c, String d, String e, String f) throws Exception {
        int p = 0;
        try{
            p = conexionBD.setPersona(a,b,c,d,e,f);            
        } catch(Exception ex){
            System.out.println("No se pudo registrar la persona " + ex.getMessage());            
        }
        return p;
    }
    
    public int getnIdPersonaReciente() throws Exception {
        int b = 0;
        try{
            b = conexionBD.getnIdPersonaReciente();
        } catch(Exception ex){
            System.out.println("No de pudo obtener el identificador de la persona mas reciente " + ex.getMessage());
        }
        return b;
    }
    
    public int getnIdProveedorReciente() throws Exception {
        int b = 0;
        try{
            b = conexionBD.getnIdProveedorReciente();
        } catch(Exception ex){
            System.out.println("No de pudo obtener el identificador del Proveedor mas reciente " + ex.getMessage());
        }
        return b;
    }
    
    public int setTelefono(String p) throws Exception {
        int b = 0;
        try{
            b = conexionBD.setTelefono(p);
        } catch (Exception ex){
            System.out.println("No se pudo registrar el relefono " + ex.getMessage());
        }
        return b;
    }
    
    public int setPersonaTelefono(String p, String t, String tp) throws Exception{
        int b = 0;
        try{
            b = conexionBD.setPersonaTelefono(p,t,tp);
        } catch (Exception ex){
            System.out.println("No se pudo establecer la relacion Cliente - Telefono " + ex.getMessage());
        }
        return b;
    }
    
    public int setCliente(String a,String b,String c,String d) throws Exception{
        int p = 0;
        try{
            p = conexionBD.setCliente(a,b,c,d);
        } catch (Exception ex){
            System.out.println("No se pudo registrar el cliente " + ex.getMessage());
        }
        return p;
    }
    
    public ArrayList getEstados() throws Exception {
        ArrayList<String> Estados = new ArrayList<String>();
        try{
            Estados = conexionBD.getEstados();
        } catch(Exception ex){
            System.out.println("No se pudo recuperar la lista de Estados disponibles. "+ ex.getMessage());
        }
        return Estados;
    }
    
    public ArrayList getMunicipios(String e) throws Exception {
        ArrayList<String> Municipios = new ArrayList<String>();
        try{
            Municipios = conexionBD.getMunicipios(e);
        } catch(Exception ex){
            System.out.println("No se pudo recuperar la lista de Municipios disponibles. "+ ex.getMessage());
        }
        return Municipios;
    }
    
    public int setDireccion(String calle,String col,String Cp,String obs,String mun) throws Exception{
        int p = 0;
        try{
            p = conexionBD.setDireccion(calle,col,Cp,obs,mun);
        } catch (Exception ex){
            System.out.println("No se pudo registrar la direccion " + ex.getMessage());
        }
        return p;
    } 
    
    public int setProveedor(String p, String rfc,String d) throws Exception{
        int q = 0;
        try{
            q = conexionBD.setproveedor(p,rfc,d);            
        } catch (Exception ex){
            System.out.println("No se puede registrar el proveedor " + ex.getMessage());
        }
        return q;
    }
    
    public int setIngrediente(String p) throws Exception{
        int q = 0;
        try{
            q = conexionBD.setIngrediente(p);            
        } catch (Exception ex){
            System.out.println("No se puedo registrar el Ingrediente " + ex.getMessage());
        }
        return q;
    }
    
    public int setProvSuc(String f, String c,String can,int prov,int ing,int suc) throws Exception{
        int q = 0;
        try{
            q = conexionBD.setProvSuc(f,c,can,prov,ing,suc);             
        } catch (Exception ex){
            System.out.println("No se puedo estableces relacion Sucursal-Proveedor " + ex.getMessage());
        }
        return q;
    }
    
    public int setPrecio(String id,String precio) throws Exception{
        int q = 0;
        try{
            q = conexionBD.setPrecio(id,precio);
        } catch (Exception ex){
            System.out.println("No se puede actualizar el precio " + ex.getMessage());
        }
        return q;
    }
    
    
}