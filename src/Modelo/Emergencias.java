/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class Emergencias {

    /**
     * @return the idEmergencia
     */
    public int getIdEmergencia() {
        return idEmergencia;
    }

    /**
     * @param idEmergencia the idEmergencia to set
     */
    public void setIdEmergencia(int idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    /**
     * @return the ubicacionEmergencia
     */
    public String getUbicacionEmergencia() {
        return ubicacionEmergencia;
    }

    /**
     * @param ubicacionEmergencia the ubicacionEmergencia to set
     */
    public void setUbicacionEmergencia(String ubicacionEmergencia) {
        this.ubicacionEmergencia = ubicacionEmergencia;
    }

    /**
     * @return the descripcionEmergencia
     */
    public String getDescripcionEmergencia() {
        return descripcionEmergencia;
    }

    /**
     * @param descripcionEmergencia the descripcionEmergencia to set
     */
    public void setDescripcionEmergencia(String descripcionEmergencia) {
        this.descripcionEmergencia = descripcionEmergencia;
    }

    /**
     * @return the gravedadEmergencia
     */
    public String getGravedadEmergencia() {
        return gravedadEmergencia;
    }

    /**
     * @param gravedadEmergencia the gravedadEmergencia to set
     */
    public void setGravedadEmergencia(String gravedadEmergencia) {
        this.gravedadEmergencia = gravedadEmergencia;
    }

    /**
     * @return the tipoEmergencia
     */
    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    /**
     * @param tipoEmergencia the tipoEmergencia to set
     */
    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    /**
     * @return the respuestaNotificacion
     */
    public String getRespuestaNotificacion() {
        return respuestaNotificacion;
    }

    /**
     * @param respuestaNotificacion the respuestaNotificacion to set
     */
    public void setRespuestaNotificacion(String respuestaNotificacion) {
        this.respuestaNotificacion = respuestaNotificacion;
    }

    /**
     * @return the estadoEmergencia
     */
    public String getEstadoEmergencia() {
        return estadoEmergencia;
    }

    /**
     * @param estadoEmergencia the estadoEmergencia to set
     */
    public void setEstadoEmergencia(String estadoEmergencia) {
        this.estadoEmergencia = estadoEmergencia;
    }
    private int idEmergencia;
    private String ubicacionEmergencia;
    private String descripcionEmergencia;
    private String gravedadEmergencia;
    private String tipoEmergencia;
    private String respuestaNotificacion;
    private String estadoEmergencia;
    
    
    
        
        public void Mostrar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"id_emergencia", "Ubicación de la emergencia", "Descripcion de la emergencia", "Gravedad de la emergencia", "Tipo de emergencia", "Respuesta notificacion", "Estado de la emergencia"});
        try {
            String query = "SELECT * FROM emergencias";
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id_emergencia");
             String ubicacion = rs.getString("ubicacion_emergencia");
             String descripcion = rs.getString("descripcion_emergencia");
             String gravedad = rs.getString("gravedad_emergencia"); 
             String tipo = rs.getString("tipo_emergencia");
             String respuesta = rs.getString("respuesta_notificacion");
             String estado = rs.getString("estado_emergencia");
        
              modelo.addRow(new Object[]{id, ubicacion, descripcion, gravedad, tipo, respuesta, estado});

            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
       
        
    }
        
     public void Eliminar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();

    int filaSeleccionada = tabla.getSelectedRow();

    String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
    try {
        String sql = "DELETE FROM Emergencias WHERE id_emergencia = ?";
        PreparedStatement deleteTransporte = conexion.prepareStatement(sql);

        
        int idTransporte = Integer.parseInt(miId);
        deleteTransporte.setInt(1, idTransporte);

        deleteTransporte.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }
}
     
     
       public void Buscar(JTable tabla, JTextField txtBuscar) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"id_emergencia", "Ubicación de la emergencia", "Descripcion de la emergencia", "Gravedad de la emergencia", "Tipo de emergencia", "Respuesta notificacion", "Estado de la emergencia"});
        try {
            String sql = "SELECT * FROM Emergencias WHERE descripcion_emergencia LIKE ?";
            PreparedStatement buscarEstudiante = conexion.prepareStatement(sql);
           buscarEstudiante.setString(1, txtBuscar.getText() + "%");
            ResultSet rs = buscarEstudiante.executeQuery();

            while (rs.next()) {
              int id = rs.getInt("id_emergencia");
             String ubicacion = rs.getString("ubicacion_emergencia");
             String descripcion = rs.getString("descripcion_emergencia");
             String gravedad = rs.getString("gravedad_emergencia"); 
             String tipo = rs.getString("tipo_emergencia");
             String respuesta = rs.getString("respuesta_notificacion");
             String estado = rs.getString("estado_emergencia");
        
              modelo.addRow(new Object[]{id, ubicacion, descripcion, gravedad, tipo, respuesta, estado});
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }
}
