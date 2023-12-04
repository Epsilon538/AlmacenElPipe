/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author Bastian
 */
public class ServiciosSQL {
    
    public ServiciosSQL(){
    }
    
    public static Connection conectar(){
        String basededatos = "jdbc:mysql://localhost:3306/Almacen";
        String user ="root";
        String pass = "";
        Connection Conexion = null;
        try{
            Conexion=DriverManager.getConnection(basededatos,user,pass);
        }
        catch(HeadlessException | SQLException sqlC){

            JOptionPane.showMessageDialog(null,"sin conectar"+ sqlC);
        }
        return Conexion;
    }
}
