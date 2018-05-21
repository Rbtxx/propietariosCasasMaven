/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iespuerto.pro.propietarioscasasmave;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rober
 */
public class Propietarios {
    String nombre;
    String apellido;
    String dni;
    int id;
    
    ArrayList<Casas> casas = new ArrayList<Casas>();

    public Propietarios() {
    }

    
    
    void vincularPropietario(int id, String dni){
        Conexion.cargarDriverMysql();
        try (Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO propietarioscasas VALUES('"+dni+"',"+id+")");
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void crearPropietarios(String dni, String nombre, String apellido, int id){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO propietarios VALUES('"+dni+"','"+nombre+"','"+apellido+"',"+id+")");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void borrarPropietario(String dni){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM propietarios WHERE '"+dni+"' = dni");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void modificarPropietario(String dni, String nombre, String apellido){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE propietarios SET dni = '"+dni+"', nombre = '"+nombre+"', apellido = '"+apellido+"' WHERE dni = '"+dni+"'");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    int getUltimoPropietario(){
        int ret = 0;
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT max(id) as maximo FROM propietarios");
            ret = res.getInt("maximo");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return ret;
    }
    
    Propietarios generarArrayPropietariosCasas(Propietarios propietario){
        casas.clear();
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            int id = 0;
            double precio = 0;
            double metros = 0;
            String direccion = "";
            boolean ascensor = false;
            boolean garaje = false;
            Casas c;
            ResultSet res = st.executeQuery("SELECT * FROM casas JOIN propietarioscasas ON casas.id = propietarioscasas.refidcasa WHERE '" + propietario.dni + "' = refdni");
            while (res.next()) {
                id = res.getInt("id");
                precio = res.getDouble("precio");
                metros = res.getDouble("metros");
                direccion = res.getString("direccion");
                ascensor = res.getBoolean("ascensor");
                garaje = res.getBoolean("garaje");
                c = new Casas(id, direccion, precio, metros, garaje, ascensor);
                propietario.casas.add(c);
            }   
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return propietario;
    }
    
    void generarArray(){
        casas.clear();
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            int id = 0;
            double precio = 0;
            double metros = 0;
            String direccion = "";
            boolean ascensor = false;
            boolean garaje = false;
            Casas c;
            ResultSet res = st.executeQuery("SELECT * FROM casas");
            while (res.next()) {
                id = res.getInt("id");
                precio = res.getDouble("precio");
                metros = res.getDouble("metros");
                direccion = res.getString("direccion");
                ascensor = res.getBoolean("ascensor");
                garaje = res.getBoolean("garaje");
                c = new Casas(id, direccion, precio, metros, garaje, ascensor);
                casas.add(c);
            }   
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public Propietarios(String nombre, String apellido, String dni, int id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Propietarios{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", id=" + id + ", casas=" + casas + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public ArrayList<Casas> getCasas() {
        return casas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCasas(ArrayList<Casas> casas) {
        this.casas = casas;
    }
    
    
}
