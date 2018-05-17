/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iespuerto.pro.propietarioscasasmave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rober
 */
public class Conexion {
    static Connection conexion=null;

    static public void cargarDriverMysql(){
      try {
        Class.forName("com.mysql.jdbc.Driver");
      } catch(ClassNotFoundException ex) {
        System.err.println("No carga el driver");
        System.exit(1);
      }        
    }
    
    static public Connection mysql(String url, String user, String pass) throws SQLException{

        conexion=null;
        String jdbcUrl = "jdbc:mysql://192.168.1.174/propietariosCasas?serverTimezone=UTC";
        String usuario = "root";
        String clave = "1q2w3e4r";
        if(url != null && !url.isEmpty())
            jdbcUrl = url;

        if(user != null && !user.isEmpty()){
            usuario = user;
        }


        if(pass != null && !pass.isEmpty()){
            clave = pass;
        }
      
        Connection con = DriverManager.getConnection(jdbcUrl, usuario, clave);

        System.out.println("Conectado a mysql!");
        conexion = con;


        return conexion;

    }
}
