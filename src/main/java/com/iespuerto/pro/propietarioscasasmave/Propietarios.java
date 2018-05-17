/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iespuerto.pro.propietarioscasasmave;

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

    public Propietarios(String nombre, String apellido, String dni, ArrayList<Casas> casas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.casas = casas;
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
