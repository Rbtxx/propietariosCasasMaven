/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iespuerto.pro.propietarioscasasmave;

import java.sql.Connection;
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
    
    
    ArrayList<Propietarios> propietarios;
    
    
    void crearCasa(int id, double precio, String direccion, double metros, boolean garaje, boolean ascensor){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO CASAS VALUES("+id+"precio"+"direccion"+"metros"+"garaje"+"ascensor"+");");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public Casas(String direccion, double precio, double metros, boolean garaje, boolean ascensor) {
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
