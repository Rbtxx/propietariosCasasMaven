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
public class Casas {
    String direccion;
    double precio;
    double metros;
    boolean garaje;
    boolean ascensor;
    int id;

    public Casas() {
    }
    
    
    ArrayList<Propietarios> propietarios = new ArrayList<Propietarios>();
    
    void vincularCasa(int id, String dni){
        Conexion.cargarDriverMysql();
        try (Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO propietarioscasas VALUES('"+dni+"',"+id+")");
        } catch (Exception e) {
        }
    }
    
    int getUltimoID(){
        int ret = 0;
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT max(idcasas) as maximo FROM casas");
            ret = res.getInt("maximo");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return ret;
    }
    
    void crearCasa(double precio, String direccion, double metros, boolean garaje, boolean ascensor, int id){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO casas(idcasas, direccion, metros, precio, garaje, ascensor) "
                    + "VALUES("+id+",'"+direccion+"',"+metros+","+precio+","+garaje+","+ascensor+");");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void borrarCasa(int id){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM casas WHERE "+id+" = idcasas");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void modificarCasa(double precio, String direccion, double metros, boolean garaje, boolean ascensor, int id){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE casas SET precio = '"+precio+"', direccion = '"
                    +direccion+"', metros = '"+metros+"', garaje = '"+garaje+"', ascensor = '"+ascensor+"' WHERE idcasas = "+id+";");
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    void generarArray(){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            String dni = "";
            String nombre = "";
            String apellido = "";
            int id = 0;
            Propietarios p = new Propietarios();  
            ResultSet res = st.executeQuery("SELECT * FROM propietarios");
            while (res.next()) {
                dni = res.getString("dni");
                nombre = res.getString("nombre");
                apellido = res.getString("apellido");
                id = res.getInt("id");
                p = new Propietarios(nombre, apellido, dni, id);
                propietarios.add(p);
            }
            st.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        String tieneAscensor;
        String tieneGaraje;
        if (ascensor) {
            tieneAscensor = "Sí";
        }else{
            tieneAscensor = "No";
        }
        if (garaje) {
            tieneGaraje = "Sí";
        }else{
            tieneGaraje = "No";
        }
        return "Casa: " + id + "\n-Direccion: " + direccion + "\n-Metros: " + metros + "\n-Precio: " + precio
                + "\n-Ascensor: " + tieneAscensor + "\n-Garaje: " + tieneGaraje + "\n";
    }

    public Casas(int id, String direccion, double precio, double metros, boolean garaje, boolean ascensor) {
        this.id = id;
        this.direccion = direccion;
        this.precio = precio;
        this.metros = metros;
        this.garaje = garaje;
        this.ascensor = ascensor;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public double getMetros() {
        return metros;
    }

    public boolean isGaraje() {
        return garaje;
    }

    public boolean isAscensor() {
        return ascensor;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }
    
    
}
