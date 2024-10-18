/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.frmActualizarBomberos;
import Vistas.frmAgregarAspirante;
import Vistas.frmAgregarBomberos;
import Vistas.frmRegistroBomberos;
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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Bomberos {
    
    public Bomberos(){
    }

   private int id_bombero;
   private String nombre_bombero;
   private String apellido_bombero;
   private String experiencia_bombero;
   private String especializacion_bombero; 
   private String foto_bombero; 
   private int id_usuario;
   private String nombre_usuario;
   
   /*id, nombreBombero, apellidoBombero, experiencia, especializacion, imagen, idUsuario*/
   
   public Bomberos (int id, String nombre, String apellido, String experiencia, String especializacion, String foto, int idUsuario, String nombreUsuario ){
   
       this.id_bombero = id;
       this.nombre_bombero = nombre;
       this.apellido_bombero = apellido;
       this.experiencia_bombero = experiencia;
       this.especializacion_bombero = especializacion;
       this.foto_bombero = foto;
       this.id_usuario = idUsuario;
       this.nombre_usuario = nombreUsuario;
   }
   
   public Bomberos (int id, String nombre, String apellido, String experiencia, String especializacion, String foto, int idUsuario){
   
       this.id_bombero = id;
       this.nombre_bombero = nombre;
       this.apellido_bombero = apellido;
       this.experiencia_bombero = experiencia;
       this.especializacion_bombero = especializacion;
       this.foto_bombero = foto;
       this.id_usuario = idUsuario;
   }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
   
   
    public int getId_bombero() {
        return id_bombero;
    }

    public void setId_bombero(int id_bombero) {
        this.id_bombero = id_bombero;
    }

    public String getNombre_bombero() {
        return nombre_bombero;
    }

    public void setNombre_bombero(String nombre_bombero) {
        this.nombre_bombero = nombre_bombero;
    }

    public String getApellido_bombero() {
        return apellido_bombero;
    }

    public void setApellido_bombero(String apellido_bombero) {
        this.apellido_bombero = apellido_bombero;
    }

    public String getExperiencia_bombero() {
        return experiencia_bombero;
    }

    public void setExperiencia_bombero(String experiencia_bombero) {
        this.experiencia_bombero = experiencia_bombero;
    }

    public String getEspecializacion_bombero() {
        return especializacion_bombero;
    }

    public void setEspecializacion_bombero(String especializacion_bombero) {
        this.especializacion_bombero = especializacion_bombero;
    }

    public String getFoto_bombero() {
        return foto_bombero;
    }

    public void setFoto_bombero(String foto_bombero) {
        this.foto_bombero = foto_bombero;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
     public Bomberos (int id, String nombre){
        this.id_usuario = id;
        this.nombre_usuario = nombre;
        
    }
     
     public Bomberos (int id, String nombre, String apellido)
    {
        this.id_bombero = id;
        this.nombre_bombero = nombre;
        this.apellido_bombero = apellido;
        
        
    }
     
     public String getNombreCompleto() {
    return nombre_bombero + " " + apellido_bombero;
}
     
     @Override
     public String toString() {
        return nombre_usuario;  
    }
    
    //metodo para obternerlos niveles de la base de datos
    public void CargarComboUsuarios(JComboBox comboBox){    
        Connection conexion = ClaseConexion.getConexion();
        comboBox.removeAllItems();
        try{
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Usuarios where id_nivelusuario = 2");
            while (rs.next()) {
                int id = rs.getInt("id_usuario"); 
                String nombre = rs.getString("nombre_usuario");
                comboBox.addItem(new Bomberos(id,nombre));   
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();  
        }
      }
    
    public void CargarComboUsuariosUpdate(JComboBox comboBox, int idUsuarioSeleccionado) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("Select * from Usuarios where id_nivelusuario = 2");

        while (rs.next()) {
            int id = rs.getInt("id_Usuario");
            String nombre = rs.getString("nombre_Usuario");
            comboBox.addItem(new Bomberos(id, nombre)); // Añadir nombre y apellido
        }

        // Seleccionar el bombero que coincide con el ID
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            Bomberos Usuario = (Bomberos) comboBox.getItemAt(i);
            if (Usuario.getId_usuario()== idUsuarioSeleccionado) {
                comboBox.setSelectedIndex(i); // Selecciona el índice
                break; // Salir del bucle una vez encontrado
            }
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
    
   
        PreparedStatement addAspirante = conexion.prepareStatement(
            "INSERT INTO Bomberos (nombre_bombero, apellido_bombero, experiencia_bombero, especializacion_bombero, foto_bombero, id_usuario) VALUES (?, ?, ?, ?, ?, ?)"
        );
      
        
        addAspirante.setString(1, getNombre_bombero());
        addAspirante.setString(2, getApellido_bombero());
        addAspirante.setString(3, getExperiencia_bombero());
        addAspirante.setString(4, getEspecializacion_bombero());
        addAspirante.setString(5, destinoImagen.getAbsolutePath());
        addAspirante.setInt(6, getId_usuario());
        
        addAspirante.executeUpdate();
    }
    
    catch(SQLException ex){
        System.out.println("Este es el error en el metodo Guardar: " + ex);
        }
    }
        public void Limpiar(frmAgregarBomberos Vistas){
        
        Vistas.txtNombreBombero.setText("");
        Vistas.txtApellidoBombero.setText("");
        Vistas.txtExperiencia.setText("");
        Vistas.txtEspecializacion.setText("");
        Vistas.lblFoto.setIcon(null);
        
    }
 
            
     public void Mostrar(JTable tabla) {
    
    Connection conexion = ClaseConexion.getConexion();
    
    // Actualizamos las columnas del modelo de datos
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{
        "id_Bombero", "Nombre", "Apellido", "Experiencia", "Especializacion", "Foto", "id_Usuario", "Nombre de usuario"
    });

    try {
        Statement statement = conexion.createStatement();
        
        // Actualizamos la consulta SQL con el INNER JOIN
        String consulta = "SELECT b.id_bombero, b.nombre_bombero, b.apellido_bombero, " +
                          "b.experiencia_bombero, b.especializacion_bombero, b.foto_bombero, " +
                          "b.id_usuario, u.nombre_usuario " +
                          "FROM Bomberos b " +
                          "INNER JOIN Usuarios u ON b.id_usuario = u.id_usuario";
        
        ResultSet rs = statement.executeQuery(consulta);
        
        // Recorremos el resultado y añadimos las filas al modelo de datos
        while (rs.next()) {
            modeloDeDatos.addRow(new Object[]{
                rs.getInt("id_bombero"),
                rs.getString("nombre_bombero"),
                rs.getString("apellido_bombero"),
                rs.getString("experiencia_bombero"),
                rs.getString("especializacion_bombero"),
                rs.getString("foto_bombero"),
                rs.getInt("id_usuario"),  // Mantenemos el id_Usuario
                rs.getString("nombre_usuario")  // Añadimos el nombre del usuario
            });
        }
        
        // Asignamos el modelo de datos a la tabla
        tabla.setModel(modeloDeDatos);
        
        // Opcional: ocultamos ciertas columnas si no quieres mostrarlas
       tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setWidth(0);
        
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo mostrar " + e);
    }
}

        
        
    
    public void Eliminar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();

    int filaSeleccionada = tabla.getSelectedRow();

    String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
    try {
        String sql = "DELETE FROM Bomberos WHERE id_Bombero = ?";
        PreparedStatement deleteBombero = conexion.prepareStatement(sql);

        
        int idBombero = Integer.parseInt(miId);
        deleteBombero.setInt(1, idBombero);

        deleteBombero.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }
}
  
    public void actualizarBomberos(String rutaImagen) {
        
    if (getId_bombero()== 0) {
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

    String sql = "update Bomberos set nombre_Bombero = ?, apellido_Bombero = ?, experiencia_Bombero = ?,  especializacion_Bombero  = ?,  foto_Bombero = ?, id_Usuario= ? where  id_Bombero = ?";

    try (PreparedStatement updateBombero = conexion.prepareStatement(sql)) {
        updateBombero.setString(1, getNombre_bombero());
        updateBombero.setString(2, getApellido_bombero());
        updateBombero.setString(3, getExperiencia_bombero());
        updateBombero.setString(4, getEspecializacion_bombero());
        updateBombero.setString(5, destinoImagen.getAbsolutePath());
        updateBombero.setInt(6, getId_usuario());
        updateBombero.setInt(7, getId_bombero());

        int filasActualizadas = updateBombero.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Bombero actualizado correctamente.");
        } else {
            System.out.println("No se encontró el aspirante con ID: " + getId_bombero());
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    
  
    public Bomberos obtenerDatosTabla(frmRegistroBomberos vista) {
    try {
        int filaSeleccionada = vista.jtBomberos.getSelectedRow();

        if (filaSeleccionada != -1) {
            int id = (Integer) vista.jtBomberos.getValueAt(filaSeleccionada, 0);
            String nombreBombero = vista.jtBomberos.getValueAt(filaSeleccionada, 1).toString();
            String apellidoBombero = vista.jtBomberos.getValueAt(filaSeleccionada, 2).toString();
            String experiencia = vista.jtBomberos.getValueAt(filaSeleccionada, 3).toString();
            String especializacion = vista.jtBomberos.getValueAt(filaSeleccionada, 4).toString();
            String foto = vista.jtBomberos.getValueAt(filaSeleccionada, 5).toString();
            int idUsuario = (Integer) vista.jtBomberos.getValueAt(filaSeleccionada, 6);

            return new Bomberos(id, nombreBombero, apellidoBombero, experiencia, especializacion, foto, idUsuario);
        }
    } catch (Exception e) {
        // Manejo de la excepción: puedes registrar el error o mostrar un mensaje al usuario
        System.err.println("Error al obtener los datos de la tabla: " + e.getMessage());
        e.printStackTrace(); // Opcional: para obtener más detalles sobre el error
    }
    return null;
}

         
        public void Limpiar(frmActualizarBomberos Vistas){
        
        Vistas.txtNombreBombero.setText("");
        Vistas.txtApellidoBombero.setText("");
        Vistas.txtExperiencia.setText("");
        Vistas.txtEspecializacion.setText("");
        Vistas.lblFoto.setIcon(null);
        
    }
        
       public void Buscar(JTable tabla, JTextField JTextField1) {
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel Transporte = new DefaultTableModel();
    
    // Actualizamos las columnas del modelo de datos
    Transporte.setColumnIdentifiers(new Object[]{
        "id_Bombero", "Nombre", "Apellido", "Experiencia", "Especializacion", "Foto", "id_Usuario", "Nombre de usuario"
    });
    
    try {
        // Actualizamos la consulta SQL con el INNER JOIN
        String sql = "SELECT b.id_bombero, b.nombre_bombero, b.apellido_bombero, " +
                     "b.experiencia_bombero, b.especializacion_bombero, b.foto_bombero, " +
                     "b.id_usuario, u.nombre_usuario " +
                     "FROM Bomberos b " +
                     "INNER JOIN Usuarios u ON b.id_usuario = u.id_usuario " +
                     "WHERE b.nombre_bombero LIKE ? || '%'";
        
        PreparedStatement BomberosBuscar = conexion.prepareStatement(sql);
        BomberosBuscar.setString(1, JTextField1.getText());
        ResultSet rs = BomberosBuscar.executeQuery();

        // Recorremos el resultado y añadimos las filas al modelo de datos
        while (rs.next()) {
            Transporte.addRow(new Object[]{
                rs.getInt("id_bombero"),
                rs.getString("nombre_bombero"),
                rs.getString("apellido_bombero"),
                rs.getString("experiencia_bombero"),
                rs.getString("especializacion_bombero"),
                rs.getString("foto_bombero"),
                rs.getInt("id_usuario"),  // Mantenemos el id_Usuario
                rs.getString("nombre_usuario")  // Añadimos el nombre del usuario
            });
        }
        
        // Asignamos el modelo de datos a la tabla
        tabla.setModel(Transporte);
        
        // Opcional: ocultamos ciertas columnas si no quieres mostrarlas
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setWidth(0);
        
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo de buscar " + e);
    }
}
       
       public boolean verificarUsaurio(int id) throws SQLException {
        Connection conexion = ClaseConexion.getConexion();
        String sql = "SELECT id_usuario FROM Bomberos WHERE id_usuario = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            // Retorna true si se encuentra el DUI, false de lo contrario
            return resultSet.next(); 
        } finally {
            if (conexion != null) {
                conexion.close(); // Asegúrate de cerrar la conexión
            }
        }
    }
       
       public boolean verificarUsuarioUpdate(int id, int idActual) throws SQLException {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "SELECT id_usuario FROM Bomberos WHERE id_usuario = ?";

    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        // Si encuentra un registro con el id, revisamos si es el mismo o no
        if (resultSet.next()) {
            System.out.println(idActual);
            System.out.println(id);

            // Si el id es el mismo que el actual, no se debe realizar ningún cambio
            if (id == idActual) {
                return false;
            } else {
                // Si el id existe en el sistema pero es diferente, devolver false
                return true;
            }
        }

        // Si no existe el id en el sistema, retornar true (id válido para ser utilizado)
        return false;
    } finally {
        if (conexion != null) {
            conexion.close(); // Asegúrate de cerrar la conexión
        }
    }
}


         
         
 
     
     
     
}

