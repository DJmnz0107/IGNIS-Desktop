/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.frmAgregarMision;
import Vistas.frmVerRegistroMisiones;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class Misiones {

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
    
    
    public Misiones() {
        
    }
    
    public Misiones(int id, String descripcionMision, Date fecha, String descripcionEmergencia, int idEmergencia ) {
        this.idMision = id;
        this.descripcionEmergencia = descripcionEmergencia;
        this.descripcionMision = descripcionMision;
        this.idEmergencia = idEmergencia;
        this.fechaMision = fecha;
    }
    
  public Misiones(int idEmergencia, String descripcionEmergencia) {
    this.idEmergencia = idEmergencia;
    this.descripcionEmergencia = descripcionEmergencia;
}

public Misiones(int id, String descripcionMision, boolean esMision) {
    this.idMision = id;
    this.descripcionMision = descripcionMision;
}

    
    

    /**
     * @return the idMision
     */
    public int getIdMision() {
        return idMision;
    }

    /**
     * @param idMision the idMision to set
     */
    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    /**
     * @return the descripcionMision
     */
    public String getDescripcionMision() {
        return descripcionMision;
    }

    /**
     * @param descripcionMision the descripcionMision to set
     */
    public void setDescripcionMision(String descripcionMision) {
        this.descripcionMision = descripcionMision;
    }

    /**
     * @return the fechaMision
     */
    public Date getFechaMision() {
        return fechaMision;
    }

    /**
     * @param fechaMision the fechaMision to set
     */
    public void setFechaMision(Date fechaMision) {
        this.fechaMision = fechaMision;
    }

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
    
    
    
    
    private int idMision;
    private String descripcionMision;
    private Date fechaMision;
    private int idEmergencia;
    private String descripcionEmergencia;
    
    @Override
public String toString() {
    return this.descripcionEmergencia;
    // o el atributo que desees mostrar
}

 
    public String toStringMision() {
    return this.descripcionMision;
}

   
  


    
    
    
public void cargarComboBoxEmergencias(JComboBox comboBox, int idEmergenciaSeleccionada) {    
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Emergencias where respuesta_notificacion = 'En camino' ");
        
        while (rs.next()) {
            int id = rs.getInt("id_emergencia"); 
            String nombre = rs.getString("descripcion_emergencia");
            comboBox.addItem(new Misiones(id, nombre));   
            System.out.println("Cargando: ID: " + id + ", Descripción: " + nombre); // Para verificar
        }
        
        System.out.println("ID de emergencia seleccionada: " + idEmergenciaSeleccionada);
        
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            Misiones mision = (Misiones) comboBox.getItemAt(i);
            System.out.println("Comparando con ID: " + mision.getIdEmergencia());
            if (mision.getIdEmergencia() == idEmergenciaSeleccionada) {
                comboBox.setSelectedIndex(i); // Selecciona el índice
                break; // Salir del bucle una vez encontrado
            }
        }
    } catch(SQLException ex) {
        ex.printStackTrace();  
    }
}


    
    
     public void Mostrar(JTable tabla) {
        
        Connection conexion = ClaseConexion.getConexion();
 
        
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"id", "Descripcion", "Fecha", "Emergencia a tratar", "Tipo de emergencia", "id_emergencia"});
 
        try {
            
            Statement statement = conexion.createStatement();
 
           
            ResultSet rs = statement.executeQuery("SELECT E.id_emergencia, E.descripcion_emergencia, E.tipo_emergencia, M.descripcion_mision, M.id_mision, M.fecha_mision FROM Misiones M " +
                "INNER JOIN Emergencias E ON E.id_emergencia = M.id_emergencia");
 
            
            while (rs.next()) {
                
            modeloDeDatos.addRow(new Object[]{
    rs.getInt("id_mision"),
    rs.getString("descripcion_mision"),
    rs.getString("fecha_mision"),
    rs.getString("descripcion_emergencia"),
    rs.getString("tipo_emergencia"),
    rs.getInt("id_emergencia") 
});

            }
 
          
            tabla.setModel(modeloDeDatos);
            
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
              tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
            
            
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
     
     public Misiones obtenerDatosTabla(frmVerRegistroMisiones vista) throws ParseException {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // Obtener la fila seleccionada de la tabla
    int filaSeleccionada = vista.jtbMisiones.getSelectedRow();

    // Si hay una fila seleccionada
    if (filaSeleccionada != -1) {
        // Obtener los datos de la fila seleccionada
        int idMision = (Integer) vista.jtbMisiones.getValueAt(filaSeleccionada, 0);
        String descripcionMision = vista.jtbMisiones.getValueAt(filaSeleccionada, 1).toString();
        String fechaTexto = vista.jtbMisiones.getValueAt(filaSeleccionada, 2).toString();
        Date fechaRecepcion = formatoFecha.parse(fechaTexto);
        String descripcionEmergencia = vista.jtbMisiones.getValueAt(filaSeleccionada, 3).toString();
        int idEmergencia = (Integer) vista.jtbMisiones.getValueAt(filaSeleccionada, 5);
        

        // Devolver un nuevo objeto Mision con los datos obtenidos
        return new Misiones(idMision, descripcionMision, fechaRecepcion, descripcionEmergencia, idEmergencia);
    }
    // Si no hay una fila seleccionada, devolver null
    return null;
}
    
         public void Eliminar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();

    int filaSeleccionada = tabla.getSelectedRow();

    String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
    try {
        String sql = "DELETE FROM Misiones WHERE id_mision = ?";
        PreparedStatement deleteMision = conexion.prepareStatement(sql);

        
        int idMision = Integer.parseInt(miId);
        deleteMision.setInt(1, idMision);

        deleteMision.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }
}
         
         // Función para actualizar la misión
public void actualizarMision() {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "UPDATE Misiones SET descripcion_mision = ?, fecha_mision = ?, id_emergencia = ? WHERE id_mision = ?";

    // Actualizar en la base de datos
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1,getDescripcionMision());  
        stmt.setDate(2, new java.sql.Date(getFechaMision().getTime()));
        stmt.setInt(3, getIdEmergencia()); 
        stmt.setInt(4, getIdMision()); // ID de la misión a actualizar

        int filasActualizadas = stmt.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Misión actualizada con éxito.");
        } else {
            System.out.println("No se encontró ninguna misión con el ID proporcionado.");
        }
    } catch (Exception e) {
        System.out.println("Error al actualizar la misión: " + e.getMessage());
    }
}

 

    
    
    //Funcion para insertar la misión
        public void insertarMision() {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "INSERT INTO Misiones (descripcion_mision, fecha_mision, id_emergencia) VALUES (?, ?, ?)";


    // Insertar en la base de datos
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, this.descripcionMision);  
        stmt.setDate(2, new java.sql.Date(this.fechaMision.getTime()));
        stmt.setInt(3, this.idEmergencia); 

        stmt.executeUpdate();
        System.out.println("Mision insertada con éxito.");
    } catch (Exception e) {
        System.out.println("Error al insertar Mision: " + e.getMessage());
    }
}
        
        public void Buscar(JTable tabla, JTextField JTextField1) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel Mision = new DefaultTableModel();
        Mision.setColumnIdentifiers(new Object[]{"id", "Descripcion", "Fecha", "Emergencia a tratar", "Tipo de emergencia ", "id_emergencia" });
        try {
            String sql = "SELECT E.id_emergencia, E.descripcion_emergencia, E.tipo_emergencia, M.descripcion_mision, M.id_mision, M.fecha_mision FROM Misiones M " +
                "INNER JOIN Emergencias E ON E.id_emergencia = M.id_emergencia WHERE descripcion_mision LIKE ? || '%'";
            PreparedStatement buscarRecurso = conexion.prepareStatement(sql);
            buscarRecurso.setString(1, JTextField1.getText());
            ResultSet rs = buscarRecurso.executeQuery();

             while (rs.next()) {
                int id = rs.getInt("id_mision");
             String descripcion = rs.getString("descripcion_mision");
             String fecha = rs.getString("fecha_mision");
             String emergencia = rs.getString("descripcion_emergencia"); 
             String tipoEmergencia = rs.getString("tipo_emergencia");
             int idEmergencia = rs.getInt("id_emergencia");
             
             
            Mision.addRow(new Object[]{id, descripcion, fecha,  emergencia, tipoEmergencia, idEmergencia});

             }
            
            tabla.setModel(Mision);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }
        
        public List<TipoEmergenciaData> obtenerDatosMisiones() {
        List<TipoEmergenciaData> datosMisiones = new ArrayList<>();

        try {
            // Conexión a la base de datos
            Connection conexion = ClaseConexion.getConexion();
            String query = "SELECT e.tipo_emergencia, COUNT(m.id_mision) AS cantidad_misiones " +
                           "FROM Misiones m " +
                           "JOIN Emergencias e ON m.id_emergencia = e.id_emergencia " +
                           "GROUP BY e.tipo_emergencia";
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados y añadirlos a la lista
            while (rs.next()) {
                String tipoEmergencia = rs.getString("tipo_emergencia");
                int cantidadMisiones = rs.getInt("cantidad_misiones");
                datosMisiones.add(new TipoEmergenciaData(tipoEmergencia, cantidadMisiones));
            }

            rs.close();
            stmt.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datosMisiones;
    }

    
}
