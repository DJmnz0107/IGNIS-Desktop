/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Vistas.frmAgregarAspirante;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Aspirantes {
    
    public Aspirantes(){
    }

    public int getId_aspirante() {
        return id_aspirante;
    }

    public void setId_aspirante(int id_aspirante) {
        this.id_aspirante = id_aspirante;
    }

    public String getNombre_aspirante() {
        return nombre_aspirante;
    }

    public void setNombre_aspirante(String nombre_aspirante) {
        this.nombre_aspirante = nombre_aspirante;
    }

    public String getApellido_aspirante() {
        return apellido_aspirante;
    }

    public void setApellido_aspirante(String apellido_aspirante) {
        this.apellido_aspirante = apellido_aspirante;
    }

    public String getDui_aspirante() {
        return dui_aspirante;
    }

    public void setDui_aspirante(String dui_aspirante) {
        this.dui_aspirante = dui_aspirante;
    }

    public String getEntrenamiento_aspirante() {
        return entrenamiento_aspirante;
    }

    public void setEntrenamiento_aspirante(String entrenamiento_aspirante) {
        this.entrenamiento_aspirante = entrenamiento_aspirante;
    }

    public int getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(int edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getProgreso_aspirante() {
        return progreso_aspirante;
    }

    public void setProgreso_aspirante(String progreso_aspirante) {
        this.progreso_aspirante = progreso_aspirante;
    }

    public String getFoto_aspirante() {
        return foto_aspirante;
    }

    public void setFoto_aspirante(String foto_aspirante) {
        this.foto_aspirante = foto_aspirante;
    }

    
    
    private int id_aspirante;
    private String nombre_aspirante;
    private String apellido_aspirante;
    private String dui_aspirante;
    private String entrenamiento_aspirante;
    private int edad_usuario;
    private String progreso_aspirante;
    private String foto_aspirante;
    private int id_bombero;
    private String nombre_bombero;

    public String getNombre_bombero() {
        return nombre_bombero;
    }
    
    public void setNombre_bombero(String nombre_bombero) {
        this.nombre_bombero = nombre_bombero;
    }

    public int getId_bombero() {
        return id_bombero;
    }

    public void setId_bombero(int id_bombero) {
        this.id_bombero = id_bombero;
    }
    
    public Aspirantes(int id, String nombre)
    {
        this.id_bombero = id;
        this.nombre_bombero = nombre;
        
        /*LA TABLA ES RELACIONADA Y NECESITO TRAER OTRO GET POR QUE NO EXISTE BOMBEROS*/
    }
    
    @Override
    public String toString() {
        return nombre_bombero;  
    }
    
    
     
    
        public void CargarComboBomberos(JComboBox comboBox){    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Bomberos");
            while (rs.next()) {
                int id = rs.getInt("id_bombero"); 
                String nombre = rs.getString("nombre_bombero");
                comboBox.addItem(new Aspirantes(id,nombre));   
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();  
        }
      }
        
        
        
    public void Guardar(String rutaImagen){
        //primero lo que hacemos es llamar a la clase conexion para a continuacion hacer
        //el prepared statement para insertar los datos
    Connection conexion = ClaseConexion.getConexion();
    
    
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
    
    
      try {
        // Verifica si el id_bombero existe
        PreparedStatement checkBombero = conexion.prepareStatement("SELECT * FROM Bomberos WHERE id_bombero = ?");
        checkBombero.setInt(1, getId_bombero());
        ResultSet rs = checkBombero.executeQuery();
        
        if (!rs.next()) {
            System.out.println("El id_bombero no existe: " + getId_bombero());
            return; // No se puede guardar si no existe el bombero
        }
    
   
        PreparedStatement addAspirante = conexion.prepareStatement(
            "INSERT INTO Aspirantes (nombre_aspirante, apellido_aspirante, dui_aspirante, entrenamiento_aspirante, edad_usuario, progreso_aspirante, foto_aspirante, id_bombero ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        );
      
        
        addAspirante.setString(1, getNombre_aspirante());
        addAspirante.setString(2, getApellido_aspirante());
        addAspirante.setString(3, getDui_aspirante());
        addAspirante.setString(4, getEntrenamiento_aspirante());
        addAspirante.setInt(5, getEdad_usuario());
        addAspirante.setString(6, getProgreso_aspirante());
        addAspirante.setString(7, rutaImagen);
        addAspirante.setInt(8, getId_bombero());
        
        addAspirante.executeUpdate();
    }
    
    catch(SQLException ex){
        System.out.println("Este es el error en el metodo Guardar: " + ex);
        }
    }
    
    public void Limpiar(frmAgregarAspirante Vistas){
        
        Vistas.txtNombreAspirante.setText("");
        Vistas.txtApellidoAspirante.setText("");
        Vistas.txtDuiAspirante.setText("");
        Vistas.txtEdadAspirante.setText("");
        Vistas.txtEntrenamientoAspirante.setText("");
        Vistas.txtProgresoAspirante.setText("");
        Vistas.txtFoto.setText("");
        Vistas.imgAspirante.setIcon(null);
        
    }
    
    public void Mostrar (JTable tabla) {
    Connection conexion  = ClaseConexion.getConexion();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object []{"id_aspirante", "Aspirante", "Apellido", "Dui", "Entrenamiento", "Edad", "Progreso", "Foto", "Bombero encargado"  });
    try {
        String query = "SELECT * FROM Aspirantes";
         Statement statement = conexion.createStatement();
         ResultSet rs = statement.executeQuery(query);
         while (rs.next()){
         int id = rs.getInt("id_aspirante");
         String Aspirante = rs.getString("nombre_aspirante");
         String Apellido = rs.getString("apellido_aspirante");
         String Dui = rs.getString("dui_aspirante");
         String Entrenamiento = rs.getString("entrenamiento_aspirante");
         int Edad = rs.getInt("edad_usuario");
         String Progreso = rs.getString("progreso_aspirante");
         String Foto = rs.getString("foto_aspirante");
         int idBombero = rs.getInt("id_bombero");
         
         modelo.addRow(new Object [] {id, Aspirante, Apellido, Dui, Entrenamiento, Edad, Progreso, Foto, idBombero});
         
         
         
         }
         tabla.setModel(modelo);
         tabla.getColumnModel().getColumn(0).setMinWidth(0);
         tabla.getColumnModel().getColumn(0).setMaxWidth(0);
         tabla.getColumnModel().getColumn(0).setWidth(0);
    
         
         
    }catch(Exception e){
       System.out.println("Este es el error en el modelo, metodo mostrar " +  e);
    }
 
     
    
    }
    
    
    public void Eliminar(JTable tabla){
    Connection conexion = ClaseConexion.getConexion();
    
    int filaSeleccionada = tabla.getSelectedRow();
    
    String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
    try {
        String sql = "DELETE FROM Aspirantes WHERE id_aspirante = ?";
        PreparedStatement deleteAspirantes = conexion.prepareStatement(sql);

        
        int idAspirantes = Integer.parseInt(miId);
        deleteAspirantes.setInt(1, idAspirantes);

        deleteAspirantes.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }

    
    }
    
    public void Buscar(JTable tabla, JTextField JTextField1) {
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel Aspirante = new DefaultTableModel();
    Aspirante.setColumnIdentifiers(new Object[]{"id_aspirante", "Aspirante", "Apellido", "Dui", "Entrenamiento", "Edad", "Progreso", "Foto", "Bombero encargado"});
    
    try {
      
        String sql = "SELECT * FROM Aspirantes WHERE nombre_aspirante LIKE ?";
        PreparedStatement buscarAspirante = conexion.prepareStatement(sql);
        buscarAspirante.setString(1, JTextField1.getText() + "%");  // Uso correcto del LIKE con %
        
        ResultSet rs = buscarAspirante.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_aspirante");
            String Nombre = rs.getString("nombre_aspirante");
            String Apellido = rs.getString("apellido_aspirante");
            String Dui = rs.getString("dui_aspirante");
            String Entrenamiento = rs.getString("entrenamiento_aspirante");
            int Edad = rs.getInt("edad_usuario");  
            String Progreso = rs.getString("progreso_aspirante");
            String Foto = rs.getString("foto_aspirante");
            int idBombero = rs.getInt("id_bombero");

            // Añade la fila al modelo
            Aspirante.addRow(new Object[]{id, Nombre, Apellido, Dui, Entrenamiento, Edad, Progreso, Foto, idBombero});
        }

        // Establece el modelo de la tabla
        tabla.setModel(Aspirante);

        // Oculta las columnas id_aspirante y id_bombero
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setWidth(0);
        
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo de buscar " + e);
    }
}
    
    
    
    
   
}
