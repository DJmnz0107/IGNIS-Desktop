package Modelo;

import Controlador.ctrlCrearCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aless
 */
public class Usuarios {
    private String nombre_usuario;
    private String contrasena_usuario;
    private int edad_usuario;
    private String DUI_usuario;
    private int id_nivelUsuario;
    
    
        public static int nivelUsuario;

    
     public int getEdad_usuario() {
        return edad_usuario;
    }

 
    public void setEdad_usuario(int edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = EncryptSHA256.encriptarSHA256(contrasena_usuario);
    }


    public String getDUI_usuario() {
        return DUI_usuario;
    }

    public void setDUI_usuario(String DUI_usuario) {
        this.DUI_usuario = DUI_usuario;
    }

    public int getId_nivelUsuario() {
        return id_nivelUsuario;
    }

    public void setId_nivelUsuario(int id_nivelUsuario) {
        this.id_nivelUsuario = id_nivelUsuario;
    }
    
    public boolean revisarLogin() {
        boolean login = false;
        
        Connection conexion = ClaseConexion.getConexion();
        
        try {
            PreparedStatement verificarLogin = conexion.prepareStatement("SELECT * FROM Usuarios WHERE nombre_usuario = ? AND contrasena_usuario = ?");
            
            verificarLogin.setString(1, getNombre_usuario());
            verificarLogin.setString(2, getContrasena_usuario());
            
            ResultSet rs = verificarLogin.executeQuery();
            
            login = rs.next();
            
            rs.close();
            
            verificarLogin.close();
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return login;
    }
    
    public void obtenerNivelUsuario() {
    Connection conexion = ClaseConexion.getConexion();
    
    try {
        // Consulta SQL para obtener el nivel de usuario basado en el nombre de usuario
        String sql = "SELECT id_nivelUsuario FROM Usuarios WHERE nombre_usuario = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, getNombre_usuario());
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            nivelUsuario = rs.getInt("id_nivelUsuario");
            System.out.println("Nivel de usuario obtenido: " + nivelUsuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
        
        rs.close();
        stmt.close();
        
    } catch (SQLException e) {
        System.out.println("Error al obtener el nivel de usuario: " + e);
    }
}
    
    public boolean verificarDui(String dui) throws SQLException {
        Connection conexion = ClaseConexion.getConexion();
        String sql = "SELECT dui_usuario FROM Usuarios WHERE dui_usuario = ?";

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
    
      public boolean verificarUsuario(String nombreUsuario) throws SQLException {
    Connection conexion = ClaseConexion.getConexion();
    String sql = "SELECT nombre_usuario FROM Usuarios WHERE nombre_usuario = ?";

    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setString(1, nombreUsuario); // Cambia 'nombre_usuario' a 'nombreUsuario'
        ResultSet resultSet = statement.executeQuery();

        // Retorna true si se encuentra el nombre de usuario, false de lo contrario
        return resultSet.next(); 
    } finally {
        if (conexion != null) {
            conexion.close(); // Asegúrate de cerrar la conexión
        }
    }
}

    
public String obtenerUsuario() {
    String nombreUsuario = null;
    Connection conexion = ClaseConexion.getConexion();
    
    try {
        PreparedStatement verificarLogin = conexion.prepareStatement("SELECT nombre_usuario FROM Usuarios WHERE nombre_usuario = ? AND contrasena_usuario = ?");
        
        verificarLogin.setString(1, getNombre_usuario());
        verificarLogin.setString(2, getContrasena_usuario()); 
        
        ResultSet rs = verificarLogin.executeQuery();
        
        if (rs.next()) {
            nombreUsuario = rs.getString("nombre_usuario");
        }
        
        rs.close();
        verificarLogin.close();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    
    return nombreUsuario;
}
public int obtenerIdUsuario(String nombreUsuario) {
    int idUsuario = 0;
    Connection conexion = ClaseConexion.getConexion();
    
    try {
        PreparedStatement verificarLogin = conexion.prepareStatement("SELECT id_usuario FROM Usuarios WHERE nombre_usuario = ?");
        
        verificarLogin.setString(1, nombreUsuario);
        
        ResultSet rs = verificarLogin.executeQuery();
        
        if (rs.next()) {
            idUsuario = rs.getInt("id_usuario");
        }
        
        rs.close();
        verificarLogin.close();
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    
    return idUsuario;
}

    
    public boolean revisarRecuperacionContra() {
    boolean recu = false;
    
    Connection conexion = ClaseConexion.getConexion();
    
    try {
        PreparedStatement verificarRecu = conexion.prepareStatement("SELECT * FROM Usuarios WHERE TRIM(nombre_usuario) = ?");
        verificarRecu.setString(1, getNombre_usuario());
        
        ResultSet rs = verificarRecu.executeQuery();
        
        recu = rs.next();  // Si hay un resultado, significa que el usuario existe.
        
        rs.close();
        verificarRecu.close();
    } catch(Exception e) {
        e.printStackTrace();
    }
    
    return recu;
}
    
    
    
    
    
    
    public boolean verificarUsuario() {
                boolean usuarios = false;

        Connection conexion = ClaseConexion.getConexion();
        
        try {
                PreparedStatement verificarUsuarios = conexion.prepareStatement("SELECT * FROM USUARIOS");
                
                ResultSet rs = verificarUsuarios.executeQuery();
                        
               usuarios = rs.next();
               
               
               
               rs.close();
               
               verificarUsuarios.close();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
        public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement CrearCuenta = conexion.prepareStatement("INSERT INTO USUARIOS (nombre_usuario, contrasena_usuario, edad_usuario, dui_usuario, id_nivelUsuario) VALUES (?, ?, ?, ?, ?)");

            //Establecer valores de la consulta SQL
            CrearCuenta.setString(1, getNombre_usuario());
            CrearCuenta.setString(2, getContrasena_usuario());
            CrearCuenta.setInt(3, getEdad_usuario());
            CrearCuenta.setString(4, getDUI_usuario());
            CrearCuenta.setInt(5, getId_nivelUsuario());
 
            //Ejecutar la consulta
            CrearCuenta.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
        
        public void Mostrar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"ID_Usuario", "Nombre", "Contraseña", "DUI", "Nivel de usuario"});
    try {
        String query = "SELECT N.nombre_nivel, U.id_usuario, U.nombre_usuario, U.contrasena_usuario, U.dui_usuario " +
                       "FROM Usuarios U " +
                       "INNER JOIN Niveles N ON U.id_nivelUsuario = N.id_nivelusuario";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id_usuario"),
                rs.getString("nombre_usuario"),
                rs.getString("contrasena_usuario"),
                rs.getString("dui_usuario"),
                rs.getString("nombre_nivel")
            });
        }
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
             tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0);
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo mostrar " + e);
    }
}

        
       public void Buscar(JTable tabla, JTextField txtBuscar) {
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new Object[]{"ID_Usuario", "Nombre", "Contraseña", "DUI", "Nivel de usuario"});
    try {
        String sql = "SELECT N.nombre_nivel, U.id_usuario, U.nombre_usuario, U.contrasena_usuario, U.dui_usuario " +
                     "FROM Usuarios U " +
                     "INNER JOIN Niveles N ON U.id_nivelUsuario = N.id_nivelusuario " +
                     "WHERE U.nombre_usuario LIKE ? || '%'";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, txtBuscar.getText());
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("id_usuario"),
                rs.getString("nombre_usuario"),
                rs.getString("contrasena_usuario"),
                rs.getString("dui_usuario"),
                rs.getString("nombre_nivel") // Mostrar el nombre del nivel
            });
        }
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
             tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0);
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo de buscar " + e);
    }
}

        
            public void Eliminar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();

        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String ID_Usuario = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "delete from usuarios where ID_Usuario = ?";
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, ID_Usuario);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
            
            public void actualizarUsuario() {
                Connection conexion = ClaseConexion.getConexion();
                
                try {
                    String statement = "UPDATE Usuarios SET contrasena_usuario = ? WHERE nombre_usuario = ?";
                    PreparedStatement actualizarUsuario = conexion.prepareStatement(statement);
                    actualizarUsuario.setString(1, getContrasena_usuario());
                    actualizarUsuario.setString(2, getNombre_usuario());
                    
                    actualizarUsuario.executeUpdate();
                    
                }
                catch(Exception e) {
                    System.out.println("Este es el error del metodo actualizar" + e);
                }
            }
        
   
}
