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
import java.sql.SQLException;
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
       modelo.setColumnIdentifiers(new Object[]{"ID_CambioSistema","Descripcion","Fecha","Nombre del usuario"});
       try{
         String query ="SELECT C.id_CambioSistema, U.nombre_usuario, C.descripcion_cambio, C.fecha_cambio FROM Cambios_Sistema C INNER JOIN Usuarios U ON U.id_usuario = C.id_usuario";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
            modelo.addRow(new Object[]{rs.getInt("ID_CambioSistema"), 
                    rs.getString("DESCRIPCION_CAMBIO"), 
                    rs.getString("FECHA_CAMBIO"), 
                    rs.getString("nombre_usuario")});
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
       }catch(Exception e){
        System.out.println("Este es el error en el modelo, metodo mostrar " + e);

       }
            
       
       }
    
      public void insertarCambio(int idUsuario, String descripcionCambio) {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "INSERT INTO Cambios_Sistema (descripcion_cambio, fecha_cambio, id_usuario) VALUES (?, ?, ?)"; // Se eliminó id_cambioSistema ya que es autoincremental
    
    try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setString(1, descripcionCambio);
        preparedStatement.setDate(2, new java.sql.Date(new Date().getTime())); // Fecha actual
        preparedStatement.setInt(3, idUsuario); // Asegúrate de que idUsuario no sea null

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}
       
    
    public void BuscarSistema(JTable tablaJ ,JTextField txtBuscarr){
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"ID_CambioSistema","Descripcion","Fecha","Nombre del usuario"});

    try{
        String sql = "SELECT C.id_CambioSistema, U.nombre_usuario, C.descripcion_cambio, C.fecha_cambio " +
                     "FROM Cambios_Sistema C INNER JOIN Usuarios U ON U.id_usuario = C.id_usuario " +
                     "WHERE U.nombre_usuario LIKE ?";
        
        PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
        deleteEstudiante.setString(1, "%" + txtBuscarr.getText() + "%");  // Aquí se usa el valor del JTextField
        
        ResultSet rs = deleteEstudiante.executeQuery();
        
        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id_CambioSistema"),   // El nombre debe coincidir con el alias en la consulta
                rs.getString("descripcion_cambio"), 
                rs.getString("fecha_cambio"), 
                rs.getString("nombre_usuario")
            });
        }

        // Actualiza la tabla con el modelo lleno
        tablaJ.setModel(modelo);

        // Oculta la columna de ID
        tablaJ.getColumnModel().getColumn(0).setMinWidth(0);
        tablaJ.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaJ.getColumnModel().getColumn(0).setWidth(0);

    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo de buscar " + e);
    }
}

    
    
    
    
    }
    

