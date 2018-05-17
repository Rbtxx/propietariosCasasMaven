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
public class Propietarios {
    String nombre;
    String apellido;
    String dni;
    
    ArrayList<Casas> casas;

    
    
    void generarArray(){
        Conexion.cargarDriverMysql();
        try(Connection con = Conexion.mysql(null, null, null)){
            Statement st = con.createStatement();
            int id = 0;
            double precio = 0;
            double metros = 0;
            String direccion = "";
            boolean ascensor = false;
            boolean garaje = false;
            int ultimoId = 0;
            Casas c;
            st.executeUpdate("SELECT max(ID) INTO"+ ultimoId + "FROM CASAS");            
            for (int i = 0; i < ultimoId; i++) {
                st.executeUpdate("SELECT ID INTO"+ id + "FROM CASAS");
                st.executeUpdate("SELECT direccion INTO"+ direccion + "FROM CASAS");
                st.executeUpdate("SELECT precio INTO"+ precio + "FROM CASAS");
                st.executeUpdate("SELECT metros INTO"+ metros + "FROM CASAS");
                st.executeUpdate("SELECT ascensor INTO"+ ascensor + "FROM CASAS");
                st.executeUpdate("SELECT garaje INTO"+ garaje + "FROM CASAS");
                c = new Casas(id, direccion, precio, metros, garaje, ascensor);
                casas.add(c);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public Propietarios(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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
