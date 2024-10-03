/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Vistas.frmActualizarAspirante;
import Vistas.frmAgregarAspirante;
import Vistas.frmVerRegistroAspirantes;
import Vistas.frmVerRegistroInventario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Aspirantes {

    /**
     * @return the apellido_bombero
     */
    public String getApellido_bombero() {
        return apellido_bombero;
    }

    /**
     * @param apellido_bombero the apellido_bombero to set
     */
    public void setApellido_bombero(String apellido_bombero) {
        this.apellido_bombero = apellido_bombero;
    }
    
    public Aspirantes(){
    }
    
    public Aspirantes(int id, String nombre, String apellido, String dui, String entrenamiento, int edad, String progreso, String foto, String nombreBombero, int idBombero){ 
        this.id_aspirante  = id;
        this.nombre_aspirante = nombre;
        this.apellido_aspirante = apellido;
        this.dui_aspirante = dui;
        this.entrenamiento_aspirante = entrenamiento;
        this.edad_usuario = edad;
        this.foto_aspirante = foto;
        this.id_bombero = idBombero;
        this.progreso_aspirante = progreso;
        this.nombre_bombero = nombreBombero;
        
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
    private String apellido_bombero;


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
    
    public Aspirantes(int id, String nombre, String apellido)
    {
        this.id_bombero = id;
        this.nombre_bombero = nombre;
                this.apellido_bombero = apellido;
        
        /*LA TABLA ES RELACIONADA Y NECESITO TRAER OTRO GET POR QUE NO EXISTE BOMBEROS*/
    }
    
      @Override
    public String toString() {
        return nombre_bombero + " " + apellido_bombero; // Devuelve el nombre completo
    }

    
    
    
    public Aspirantes obtenerDatosTabla(frmVerRegistroAspirantes vista) {
    int filaSeleccionada = vista.jtAspirantes.getSelectedRow();

    if (filaSeleccionada != -1) {
        int id = (Integer) vista.jtAspirantes.getValueAt(filaSeleccionada, 0);
        String nombreAspirante = vista.jtAspirantes.getValueAt(filaSeleccionada, 1).toString();
        String apellidoAspirante = vista.jtAspirantes.getValueAt(filaSeleccionada, 2).toString();
        String dui = vista.jtAspirantes.getValueAt(filaSeleccionada, 3).toString();
        String entrenamiento = vista.jtAspirantes.getValueAt(filaSeleccionada, 4).toString();
        int edad = Integer.parseInt(vista.jtAspirantes.getValueAt(filaSeleccionada, 5).toString());
        String progreso = vista.jtAspirantes.getValueAt(filaSeleccionada, 6).toString();
        String fotoAspirante = vista.jtAspirantes.getValueAt(filaSeleccionada, 7).toString();
        String nombreBombero = vista.jtAspirantes.getValueAt(filaSeleccionada, 8).toString(); // Nombre completo
        int idBombero = Integer.parseInt(vista.jtAspirantes.getValueAt(filaSeleccionada, 9).toString());

        return new Aspirantes(id, nombreAspirante, apellidoAspirante, dui, entrenamiento, edad, progreso, fotoAspirante, nombreBombero, idBombero);
    }
    return null;
}
    
     public boolean verificarDui(String dui) throws SQLException {
        Connection conexion = ClaseConexion.getConexion();
        String sql = "SELECT dui_aspirante FROM Aspirantes WHERE dui_aspirante = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dui);
            ResultSet resultSet = statement.executeQuery();

            // Retorna true si se encuentra el DUI, false de lo contrario
            return resultSet.next(); 
        } finally {
            if (conexion != null) {
                conexion.close(); // Asegúrate de cerrar la conexión
            }
        }
    }



    
public void CargarComboBomberosUpdate(JComboBox comboBox, int idBomberoSeleccionado) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Bomberos");

        while (rs.next()) {
            int id = rs.getInt("id_bombero");
            String nombre = rs.getString("nombre_bombero");
            String apellido = rs.getString("apellido_bombero"); // Obtener apellido
            comboBox.addItem(new Aspirantes(id, nombre, apellido)); // Añadir nombre y apellido
        }

        // Seleccionar el bombero que coincide con el ID
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            Aspirantes bombero = (Aspirantes) comboBox.getItemAt(i);
            if (bombero.getId_bombero() == idBomberoSeleccionado) {
                comboBox.setSelectedIndex(i); // Selecciona el índice
                break; // Salir del bucle una vez encontrado
            }
        }
    } catch(SQLException ex) {
        ex.printStackTrace();  
    }
}



    
     
    
       public void CargarComboBomberos(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Bomberos");

        while (rs.next()) {
            int id = rs.getInt("id_bombero");
            String nombre = rs.getString("nombre_bombero");
            String apellido = rs.getString("apellido_bombero"); // Obtener apellido
            comboBox.addItem(new Aspirantes(id, nombre, apellido)); // Añadir nombre y apellido
        }
    } catch(SQLException ex) {
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
        addAspirante.setString(7, destinoImagen.getAbsolutePath());
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
        Vistas.imgAspirante.setIcon(null);
        
    }
    
      public void Limpiar(frmActualizarAspirante Vistas){
        
        Vistas.txtNombreAspirante.setText("");
        Vistas.txtApellidoAspirante.setText("");
        Vistas.txtDuiAspirante.setText("");
        Vistas.txtEdadAspirante.setText("");
        Vistas.txtEntrenamientoAspirante.setText("");
        Vistas.txtProgresoAspirante.setText("");
        Vistas.imgAspirante.setIcon(null);
        
    }
    
public void Mostrar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"id_aspirante", "Aspirante", "Apellido", "Dui", "Entrenamiento", "Edad", "Progreso", "Foto", "Bombero encargado", "idbombero"});

    try {
        String query = "SELECT a.id_aspirante, " +
                       "a.nombre_aspirante, " +
                       "a.apellido_aspirante, " +
                       "a.dui_aspirante, " +
                       "a.entrenamiento_aspirante, " +
                       "a.edad_usuario, " +
                       "a.progreso_aspirante, " +
                       "a.foto_aspirante, " +
                       "b.nombre_bombero || ' ' || b.apellido_bombero AS nombre_bombero_completo, " + // Añadir coma al final
                       "a.id_bombero " +  // Agregar un espacio al principio
                       "FROM Aspirantes a " +
                       "INNER JOIN Bomberos b ON a.id_bombero = b.id_bombero";

        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            int id = rs.getInt("id_aspirante");
            String nombreAspirante = rs.getString("nombre_aspirante");
            String apellidoAspirante = rs.getString("apellido_aspirante");
            String dui = rs.getString("dui_aspirante");
            String entrenamiento = rs.getString("entrenamiento_aspirante");
            int edad = rs.getInt("edad_usuario");
            String progreso = rs.getString("progreso_aspirante");
            String foto = rs.getString("foto_aspirante");
            String bomberoEncargado = rs.getString("nombre_bombero_completo");
            int idBombero = rs.getInt("id_bombero");

            modelo.addRow(new Object[]{id, nombreAspirante, apellidoAspirante, dui, entrenamiento, edad, progreso, foto, bomberoEncargado, idBombero});
        }
        
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setWidth(0);
        
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, método mostrar: " + e);
    }
}

  public void actualizarAspirante(String rutaImagen) {
    if (getId_aspirante() == 0) {
        System.out.println("ID del aspirante es 0. No se puede actualizar.");
        return;
    }

    Connection conexion = ClaseConexion.getConexion();
    
    String escritorio = System.getProperty("user.home") + File.separator + "Desktop";
    String carpetaImagenes = escritorio + File.separator + "RecursosImágenes";
    File carpeta = new File(carpetaImagenes);

    if (!carpeta.exists()) {
        carpeta.mkdirs();
    }

    String nombreImagen = new File(rutaImagen).getName();
    File destinoImagen = new File(carpeta, nombreImagen);

    try {
        Files.copy(new File(rutaImagen).toPath(), destinoImagen.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        System.out.println("Error al guardar la imagen: " + e.getMessage());
        return;
    }

    String sql = "UPDATE Aspirantes SET "
               + "nombre_aspirante = ?, "
               + "apellido_aspirante = ?, "
               + "dui_aspirante = ?, "
               + "entrenamiento_aspirante = ?, "
               + "edad_usuario = ?, "
               + "progreso_aspirante = ?, "
               + "foto_aspirante = ?, "
               + "id_bombero = ? "
               + "WHERE id_aspirante = ?";

    try (PreparedStatement updateAspirante = conexion.prepareStatement(sql)) {
        updateAspirante.setString(1, getNombre_aspirante());
        updateAspirante.setString(2, getApellido_aspirante());
        updateAspirante.setString(3, getDui_aspirante());
        updateAspirante.setString(4, getEntrenamiento_aspirante());
        updateAspirante.setInt(5, getEdad_usuario());
        updateAspirante.setString(6, getProgreso_aspirante());
        updateAspirante.setString(7, destinoImagen.getAbsolutePath());
        updateAspirante.setInt(8, getId_bombero());
        updateAspirante.setInt(9, getId_aspirante());

        int filasActualizadas = updateAspirante.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Aspirante actualizado correctamente.");
        } else {
            System.out.println("No se encontró el aspirante con ID: " + getId_aspirante());
        }
    } catch (SQLException e) {
        e.printStackTrace();
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
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"id_aspirante", "Aspirante", "Apellido", "Dui", "Entrenamiento", "Edad", "Progreso", "Foto", "Bombero encargado", "id_bombero"});

    try {
        String sql = "SELECT a.id_aspirante, " +
                     "a.nombre_aspirante, " +
                     "a.apellido_aspirante, " +
                     "a.dui_aspirante, " +
                     "a.entrenamiento_aspirante, " +
                     "a.edad_usuario, " +
                     "a.progreso_aspirante, " +
                     "a.foto_aspirante, " +
                     "b.nombre_bombero || ' ' || b.apellido_bombero AS nombre_bombero_completo, " +
                     "a.id_bombero " +
                     "FROM Aspirantes a " +
                     "INNER JOIN Bomberos b ON a.id_bombero = b.id_bombero " +
                     "WHERE a.nombre_aspirante LIKE ?";

        PreparedStatement buscarAspirante = conexion.prepareStatement(sql);
        buscarAspirante.setString(1, JTextField1.getText() + "%"); // Uso correcto del LIKE con %

        ResultSet rs = buscarAspirante.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_aspirante");
            String nombre = rs.getString("nombre_aspirante");
            String apellido = rs.getString("apellido_aspirante");
            String dui = rs.getString("dui_aspirante");
            String entrenamiento = rs.getString("entrenamiento_aspirante");
            int edad = rs.getInt("edad_usuario");
            String progreso = rs.getString("progreso_aspirante");
            String foto = rs.getString("foto_aspirante");
            String bomberoEncargado = rs.getString("nombre_bombero_completo");
            int idBombero = rs.getInt("id_bombero");

            modelo.addRow(new Object[]{id, nombre, apellido, dui, entrenamiento, edad, progreso, foto, bomberoEncargado, idBombero});
        }

        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setWidth(0);

    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, método de buscar: " + e);
    }
}

    
    
    
    
   
}
