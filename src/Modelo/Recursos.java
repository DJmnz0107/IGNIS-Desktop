/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.frmVerRegistroInventario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class Recursos {
    
    
  
    
    
    public Recursos() {
        
    }
    
    public Recursos(int id, String nombre, String descripcion, String estado, Date fecha, String disponibilidad, String foto){ 
        this.idRecurso  = id;
        this.nombreRecurso = nombre;
        this.descripcionRecurso = descripcion;
        this.estadoRecurso = estado;
        this.fechaRecepcionRecurso = fecha;
        this.disponibilidadRecurso = disponibilidad;
        this.fotoRecurso = foto;
        
    }

    /**
     * @return the idRecurso
     */
    public int getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso the idRecurso to set
     */
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * @return the nombreRecurso
     */
    public String getNombreRecurso() {
        return nombreRecurso;
    }

    /**
     * @param nombreRecurso the nombreRecurso to set
     */
    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    /**
     * @return the descripcionRecurso
     */
    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    /**
     * @param descripcionRecurso the descripcionRecurso to set
     */
    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    /**
     * @return the estadoRecurso
     */
    public String getEstadoRecurso() {
        return estadoRecurso;
    }

    /**
     * @param estadoRecurso the estadoRecurso to set
     */
    public void setEstadoRecurso(String estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }

    /**
     * @return the fechaRecepcionRecurso
     */
    public Date getFechaRecepcionRecurso() {
        return fechaRecepcionRecurso;
    }

    /**
     * @param fechaRecepcionRecurso the fechaRecepcionRecurso to set
     */
    public void setFechaRecepcionRecurso(Date fechaRecepcionRecurso) {
        this.fechaRecepcionRecurso = fechaRecepcionRecurso;
    }

    /**
     * @return the disponibilidadRecurso
     */
    public String getDisponibilidadRecurso() {
        return disponibilidadRecurso;
    }

    /**
     * @param disponibilidadRecurso the disponibilidadRecurso to set
     */
    public void setDisponibilidadRecurso(String disponibilidadRecurso) {
        this.disponibilidadRecurso = disponibilidadRecurso;
    }

    /**
     * @return the fotoRecurso
     */
    public String getFotoRecurso() {
        return fotoRecurso;
    }
    
    public Recursos(int idRecurso, String nombreRecurso){
    this.idRecurso= idRecurso;
    this.nombreRecurso= nombreRecurso;
    
    }
    
    @Override
public String toString() {
    return this.nombreRecurso; 
}

    

    /**
     * @param fotoRecurso the fotoRecurso to set
     */
    public void setFotoRecurso(String fotoRecurso) {
        this.fotoRecurso = fotoRecurso;
    }
 private int idRecurso;
    private String nombreRecurso;
    private String descripcionRecurso;
    private String estadoRecurso;
    private Date fechaRecepcionRecurso; 
    private String disponibilidadRecurso;
    private String fotoRecurso;
    
     public void Eliminar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();

    int filaSeleccionada = tabla.getSelectedRow();

    String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
    try {
        String sql = "DELETE FROM Recursos WHERE id_recurso = ?";
        PreparedStatement deleteRecurso = conexion.prepareStatement(sql);

        
        int idTransporte = Integer.parseInt(miId);
        deleteRecurso.setInt(1, idTransporte);

        deleteRecurso.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }
}  
     
     
   

    // Método para obtener todos los recursos
    public List<Recursos> getRecursos() {
        List<Recursos> listaRecursos = new ArrayList<>();
        
    Connection conexion = ClaseConexion.getConexion();
        
        String query = "SELECT id_recurso, nombre_recurso, descripcion_recurso, estado_recurso, "
                     + "fechaRecepcion_recurso, disponibilidad_recurso, foto_recurso "
                     + "FROM Recursos";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Recursos recurso = new Recursos();
                
                recurso.setIdRecurso(rs.getInt("id_recurso"));
                recurso.setNombreRecurso(rs.getString("nombre_recurso"));
                recurso.setDescripcionRecurso(rs.getString("descripcion_recurso"));
                recurso.setEstadoRecurso(rs.getString("estado_recurso"));
                recurso.setFechaRecepcionRecurso(rs.getDate("fechaRecepcion_recurso"));
                recurso.setDisponibilidadRecurso(rs.getString("disponibilidad_recurso"));
                recurso.setFotoRecurso(rs.getString("foto_recurso")); // Asumimos que el CLOB es manejado como String

                // Añadir el objeto recurso a la lista
                listaRecursos.add(recurso);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaRecursos;
    }


     
     
  public void actualizarRecurso(String rutaImagen) {
    
        Connection conexion = ClaseConexion.getConexion();
        
    String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
    String carpetaImagenes = escritorio + File.separator + "RecursosImágenes";
    File carpeta = new File(carpetaImagenes);

    // Crear la carpeta si no existe
    if (!carpeta.exists()) {
        carpeta.mkdirs();
    }

    // Nombre de la imagen que se guardará
    String nombreImagen = new File(rutaImagen).getName();
    File destinoImagen = new File(carpeta, nombreImagen);

    // Copiar la imagen a la carpeta
    try {
        Files.copy(new File(rutaImagen).toPath(), destinoImagen.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
        return; // Termina el método si hay un error
    }

        try { 
        PreparedStatement updateRecurso = conexion.prepareStatement("update Recursos set nombre_recurso = ?, descripcion_recurso = ?, estado_recurso = ?,  fechaRecepcion_recurso  = ?,  disponibilidad_recurso = ?, foto_recurso = ? where id_recurso = ?");

        updateRecurso.setString(1, getNombreRecurso());
        updateRecurso.setString(2, getDescripcionRecurso());
        updateRecurso.setString(3, getEstadoRecurso());
        updateRecurso.setDate(4, new java.sql.Date(this.fechaRecepcionRecurso.getTime()));
        updateRecurso.setString(5, getDisponibilidadRecurso());
        updateRecurso.setString(6, destinoImagen.getAbsolutePath());
        updateRecurso.setInt(7, getIdRecurso());

        updateRecurso.executeUpdate();





    } catch (Exception e) {
        System.out.println("este es el error en el metodo de actualizar" + e);
    }
}
    
    
    public void Mostrar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"id_recurso", "Nombre del recurso", "Descripcion", "Estado", "Fecha de recepción", "Disponibilidad recurso", "Foto del recurso"});
        try {
            String query = "SELECT * FROM recursos";
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id_recurso");
             String nombre = rs.getString("nombre_recurso");
             String descripcion = rs.getString("descripcion_recurso");
             String estado = rs.getString("estado_recurso"); 
             String fechaRecepcion = rs.getString("fechaRecepcion_recurso");
             String disponibilidad = rs.getString("disponibilidad_recurso");
             String foto = rs.getString("foto_recurso");
        
              modelo.addRow(new Object[]{id, nombre, descripcion,  estado,  fechaRecepcion, disponibilidad, foto});

            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
       
        
    }
    
    
    //Función para obtener los datos de la tabla
    public Recursos obtenerDatosTabla(frmVerRegistroInventario vista) throws ParseException {
SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int filaSeleccionada = vista.jtInventario.getSelectedRow();

    if (filaSeleccionada != -1) {
        int id = (Integer) vista.jtInventario.getValueAt(filaSeleccionada, 0);
        String nombreRecurso = vista.jtInventario.getValueAt(filaSeleccionada, 1).toString();
        String descripcionRecurso = vista.jtInventario.getValueAt(filaSeleccionada, 2).toString();
        String estado = vista.jtInventario.getValueAt(filaSeleccionada, 3).toString();
        String fechaTexto = vista.jtInventario.getValueAt(filaSeleccionada, 4).toString();
        Date fechaRecepcion = formatoFecha.parse(fechaTexto);
        String disponibilidad = vista.jtInventario.getValueAt(filaSeleccionada, 5).toString();
        String fotoRecurso = vista.jtInventario.getValueAt(filaSeleccionada, 6).toString();

        return new Recursos(id, nombreRecurso, descripcionRecurso, estado, fechaRecepcion, disponibilidad, fotoRecurso);
    }
    return null;
}
    
    public void Buscar(JTable tabla, JTextField JTextField1) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel Recurso = new DefaultTableModel();
        Recurso.setColumnIdentifiers(new Object[]{"id_recurso", "Nombre del recurso", "Descripcion", "Estado", "Fecha de recepción", "Disponibilidad recurso", "Foto del recurso"});
        try {
            String sql = "SELECT * FROM Recursos WHERE descripcion_recurso LIKE ? || '%'";
            PreparedStatement buscarRecurso = conexion.prepareStatement(sql);
            buscarRecurso.setString(1, JTextField1.getText());
            ResultSet rs = buscarRecurso.executeQuery();

             while (rs.next()) {
                int id = rs.getInt("id_recurso");
             String nombre = rs.getString("nombre_recurso");
             String descripcion = rs.getString("descripcion_recurso");
             String estado = rs.getString("estado_recurso"); 
             String fechaRecepcion = rs.getString("fechaRecepcion_recurso");
             String disponibilidad = rs.getString("disponibilidad_recurso");
             String foto = rs.getString("foto_recurso");
             
                           Recurso.addRow(new Object[]{id, nombre, descripcion,  estado,  fechaRecepcion, disponibilidad, foto});

             }
            
            tabla.setModel(Recurso);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }
    
    
    

    
    
    public void insertarRecurso(String rutaImagen) {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "INSERT INTO Recursos (nombre_recurso, descripcion_recurso, estado_recurso, fechaRecepcion_recurso, disponibilidad_recurso, foto_recurso) VALUES (?, ?, ?, ?, ?, ?)";

    // Ruta de la carpeta en el escritorio donde se guardarán las imágenes
    String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
    String carpetaImagenes = escritorio + File.separator + "RecursosImágenes";
    File carpeta = new File(carpetaImagenes);

    // Crear la carpeta si no existe
    if (!carpeta.exists()) {
        carpeta.mkdirs();
    }

    // Nombre de la imagen que se guardará
    String nombreImagen = new File(rutaImagen).getName();
    File destinoImagen = new File(carpeta, nombreImagen);

    // Copiar la imagen a la carpeta
    try {
        Files.copy(new File(rutaImagen).toPath(), destinoImagen.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
        return; // Termina el método si hay un error
    }

    // Insertar en la base de datos
    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, this.nombreRecurso);  // Nombre del recurso
        stmt.setString(2, this.descripcionRecurso);  // Descripción
        stmt.setString(3, this.estadoRecurso);  // Estado

        // Fecha de recepción
        if (this.fechaRecepcionRecurso != null) {
            stmt.setDate(4, new java.sql.Date(this.fechaRecepcionRecurso.getTime()));
        } else {
            stmt.setDate(4, null); // Si es nulo, establece como nulo en la base de datos
        }

        stmt.setString(5, this.disponibilidadRecurso);  // Disponibilidad
        stmt.setString(6, destinoImagen.getAbsolutePath());  // Ruta de la imagen guardada

        stmt.executeUpdate();
        System.out.println("Recurso insertado con éxito.");
    } catch (Exception e) {
        System.out.println("Error al insertar recurso: " + e.getMessage());
    }
}

}
