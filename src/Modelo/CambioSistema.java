/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.TextField;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class CambioSistema {

    /**
     * @return the id_cambioSistema
     */
    public int getId_cambioSistema() {
        return id_cambioSistema;
    }

    /**
     * @param id_cambioSistema the id_cambioSistema to set
     */
    public void setId_cambioSistema(int id_cambioSistema) {
        this.id_cambioSistema = id_cambioSistema;
    }

    /**
     * @return the descripcion_cambio
     */
    public String getDescripcion_cambio() {
        return descripcion_cambio;
    }

    /**
     * @param descripcion_cambio the descripcion_cambio to set
     */
    public void setDescripcion_cambio(String descripcion_cambio) {
        this.descripcion_cambio = descripcion_cambio;
    }

    /**
     * @return the fecha_cambio
     */
    public Date getFecha_cambio() {
        return fecha_cambio;
    }

    /**
     * @param fecha_cambio the fecha_cambio to set
     */
    public void setFecha_cambio(Date fecha_cambio) {
        this.fecha_cambio = fecha_cambio;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    private int id_cambioSistema;
    private String descripcion_cambio;
    private Date fecha_cambio;
    private int id_usuario;
    
    
    public void Mostar(JTable tabla){
       Connection conexion = ClaseConexion.getConexion();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.setColumnIdentifiers(new Object[]{"ID_CambioSistema","Descripcion","Fecha","Id_Usuario"});
       try{
         String query ="Select * From Cambios_Sistema";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
            modelo.addRow(new Object[]{rs.getInt("ID_CambioSistema"), 
                    rs.getString("DESCRIPCION_CAMBIO"), 
                    rs.getString("FECHA_CAMBIO"), 
                    rs.getInt("Id_Usuario")});
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            tabla.getColumnModel().getColumn(3).setMinWidth(0);
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla.getColumnModel().getColumn(3).setWidth(0);
       }catch(Exception e){
        System.out.println("Este es el error en el modelo, metodo mostrar " + e);

       }
            
       
       }
       
    
    public void BuscarSistema(JTable tablaJ ,JTextField txtBuscarr){
       Connection conexion = ClaseConexion.getConexion();
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.setColumnIdentifiers(new Object[]{"ID_CambioSistema","Descripcion","Fecha","Id_Usuario"});
       try{
           String sql = "SELECT U.nombre_usuario, C.descripcion_cambio, C.fecha_cambio FROM Cambios_Sistema C INNER JOIN Usuarios U ON U.id_usuario = C.id_usuario WHERE U.nombre_usuario LIKE '%D%'";
           
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, txtBuscarr.getText());
            ResultSet rs = deleteEstudiante.executeQuery();
            
       while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getInt("ID_CambioSistema"), 
                    rs.getString("Descripcion"), 
                    rs.getString("Fecha"), 
                    rs.getInt("Id_Usuario")});
            }
            //nuevo modelo lleno
            tablaJ.setModel(modelo);
            tablaJ.getColumnModel().getColumn(0).setMinWidth(0);
            tablaJ.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaJ.getColumnModel().getColumn(0).setWidth(0);
       
       
       }catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }

    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    }
    

