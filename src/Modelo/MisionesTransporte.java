/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JTable;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author danie
 */
public class MisionesTransporte {

    public int getId_misionTransporte() {
        return id_misionTransporte;
    }

    public void setId_misionTransporte(int id_misionTransporte) {
        this.id_misionTransporte = id_misionTransporte;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }
    
    private int id_misionTransporte;
    private int id_mision;
    private int id_transporte;


    
   
   
   
   
   public void obtenerMisiones(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Misiones");

        while (rs.next()) {
            int id = rs.getInt("id_mision");
            String descripcionMision = rs.getString("descripcion_mision");

            Misiones mision = new Misiones(id, descripcionMision, false);
            comboBox.addItem(new MisionDisplay(mision)); // Añadir el wrapper
        }
    } catch(SQLException ex) {
        ex.printStackTrace();  
    }
}
   
   public void obtenerTransporte(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Transportes");

        while (rs.next()) {
            int id = rs.getInt("id_Transporte");
            String nombre = rs.getString("tipoVehiculo_Transporte");
            
            Transportes transporte = new Transportes(id, nombre, false);
            comboBox.addItem(new TransporteDisplay(transporte));
        }
    } catch(SQLException ex) {
        ex.printStackTrace();  
    }
}
   
   public void guardar() {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();
    try {
        // Crear el PreparedStatement que ejecutará la Query
        PreparedStatement addMisionBombero = conexion.prepareStatement(
            "INSERT INTO Misiones_Transportes (id_mision, id_Transporte) VALUES (?, ?)"
        );

        // Establecer valores de la consulta SQL
        int idMision = getId_mision();
        int idTransporte = getId_transporte();

        System.out.println("ID Misión: " + idMision);
        System.out.println("ID Bombero: " + idTransporte);

        addMisionBombero.setInt(1, idMision);
        addMisionBombero.setInt(2, idTransporte);

        // Ejecutar la consulta
        addMisionBombero.executeUpdate();
    } catch (Exception ex) {
        System.out.println("Este es el error en el modelo: método guardar " + ex);
    } finally {
        // Asegúrate de cerrar la conexión en el bloque finally para liberar recursos
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e);
        }
    }
}
   
   
   public void Mostrar(JTable tabla) {
    // Creamos una variable de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();

    // Definimos el modelo de la tabla
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{
        "Descripción Misión", "Tipo Vehículo", "Placa Transporte", "ID Misión Transporte", "ID Misión", "ID Transporte"
    });

    try {
        // Creamos un Statement
        Statement statement = conexion.createStatement();

        // Ejecutamos el Statement con la consulta INNER JOIN y lo asignamos a una variable de tipo ResultSet
        String consulta = "SELECT M.descripcion_mision, T.tipovehiculo_transporte, T.placa_transporte, " +
                          "MT.id_misiontransporte, M.id_mision, T.id_transporte " +
                          "FROM Misiones_transportes MT " +
                          "INNER JOIN Misiones M on MT.id_mision = M.id_mision " +
                          "INNER JOIN Transportes T on MT.id_transporte = T.id_transporte";
        ResultSet rs = statement.executeQuery(consulta);

        // Recorremos el ResultSet
        while (rs.next()) {
            // Llenamos el modelo con los datos obtenidos del ResultSet
            modeloDeDatos.addRow(new Object[]{
                rs.getString("descripcion_mision"),
                rs.getString("tipovehiculo_transporte"),
                rs.getString("placa_transporte"),
                rs.getInt("id_misiontransporte"),
                rs.getInt("id_mision"),
                rs.getInt("id_transporte")
            });
        }

        // Asignamos el nuevo modelo lleno a la tabla
        tabla.setModel(modeloDeDatos);
        
        // Ocultar las id
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo mostrar: " + e);
    }
}
   
   public void Eliminar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();

        int filaSeleccionada = tabla.getSelectedRow();

        String miId = tabla.getValueAt(filaSeleccionada, 3).toString();
    
        try {
            String sql = "DELETE FROM Misiones_transportes WHERE id_misiontransporte = ?";
            PreparedStatement deleteMisionTransporte = conexion.prepareStatement(sql);

        
            int idMisionTransporte = Integer.parseInt(miId);
            deleteMisionTransporte.setInt(1, idMisionTransporte);

            deleteMisionTransporte.executeUpdate();
        
        } catch (Exception e) {
            System.out.println("Este es el error en el método de eliminar: " + e);
        }
    }
   
   public void Buscar(JTable tabla, JTextField JTextFieldPlaca) {
    // Conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();

    // Modelo de la tabla
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{"Descripción Misión", "Tipo Vehículo", "Placa Transporte", "ID Misión Transporte", "ID Misión", "ID Transporte"});

    try {
        // Consulta SQL con INNER JOIN y búsqueda por placa
        String sql = "SELECT M.descripcion_mision, T.tipovehiculo_transporte, T.placa_transporte, " +
                     "MT.id_misiontransporte, M.id_mision, T.id_transporte " +
                     "FROM Misiones_transportes MT " +
                     "INNER JOIN Misiones M on MT.id_mision = M.id_mision " +
                     "INNER JOIN Transportes T on MT.id_transporte = T.id_transporte " +
                     "WHERE T.placa_transporte LIKE ? || '%'";

        // Preparar la sentencia
        PreparedStatement buscarPorPlaca = conexion.prepareStatement(sql);
        buscarPorPlaca.setString(1, JTextFieldPlaca.getText());

        // Ejecutar la consulta
        ResultSet rs = buscarPorPlaca.executeQuery();

        // Recorrer los resultados
        while (rs.next()) {
            String descripcionMision = rs.getString("descripcion_mision");
            String tipoVehiculo = rs.getString("tipovehiculo_transporte");
            String placaTransporte = rs.getString("placa_transporte");
            int idMisionTransporte = rs.getInt("id_misiontransporte");
            int idMision = rs.getInt("id_mision");
            int idTransporte = rs.getInt("id_transporte");

            // Agregar filas al modelo
            modeloDeDatos.addRow(new Object[]{
                descripcionMision, tipoVehiculo, placaTransporte, idMisionTransporte, idMision, idTransporte
            });
        }

        // Asignar el modelo a la tabla
        tabla.setModel(modeloDeDatos);

        // Ocultar las id
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(0);

    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, método BuscarPorPlaca: " + e);
    }
}
   
  
}


