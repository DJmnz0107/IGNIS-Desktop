/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.frmRegistroTransportes;
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
    
    
    private int id_misionTransporte;
    private int id_mision;
    private int id_transporte;
    private String descripcion_mision;
    private String tipovehiculo_transporte;
    private String placa_transporte;

    
     public MisionesTransporte( ){
        
        
    }
    
    private MisionesTransporte( String descripcion_mision, String TipoVehiculo, String placaVehiculo, int id_misionTransporte, int id_mision, int id_transporte){
        this.descripcion_mision = descripcion_mision;
        this.tipovehiculo_transporte = TipoVehiculo;
        this.tipovehiculo_transporte = placaVehiculo;
        this.id_misionTransporte = id_misionTransporte;
        this.id_mision = id_mision;
        this.id_transporte = id_transporte;
        
    
    }
    

    public String getPlaca_transporte() {
        return placa_transporte;
    }

    public void setPlaca_transporte(String placa_transporte) {
        this.placa_transporte = placa_transporte;
    }
    
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
    
    
    

    public String getDescripcion_mision() {
        return descripcion_mision;
    }

    public void setDescripcion_mision(String descripcion_mision) {
        this.descripcion_mision = descripcion_mision;
    }

    public String getTipovehiculo_transporte() {
        return tipovehiculo_transporte;
    }

    public void setTipovehiculo_transporte(String tipovehiculo_transporte) {
        this.tipovehiculo_transporte = tipovehiculo_transporte;
    }
    
    
  
    
    
    
    public void CargarComboTransportesUpdate(JComboBox comboBox, int idTransporteSeleccionado) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Transportes");

        while (rs.next()) {
            int id = rs.getInt("id_Transporte");
            String nombre = rs.getString("tipoVehiculo_Transporte");
            
            comboBox.addItem(new TransporteDisplay(new Transportes(id, nombre, false))); // Añadir el wrapper
        }

        // Seleccionar el bombero que coincide con el ID
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            TransporteDisplay transporteDisplay = (TransporteDisplay) comboBox.getItemAt(i); // Obtener el wrapper
            Transportes transportes = transporteDisplay.getTransportes(); // Obtener el objeto Bomberos

            if (transportes.getId_transporte()== idTransporteSeleccionado) {
                comboBox.setSelectedIndex(i); // Selecciona el índice
                break; // Salir del bucle una vez encontrado
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

     
     
 public void cargarComboBoxMisiones(JComboBox comboBox, int idMisionSeleccionada) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Misiones");

        while (rs.next()) {
            int id = rs.getInt("id_mision"); 
            String descripcionMision = rs.getString("descripcion_mision"); // Ajustado para descripción
            Misiones mision = new Misiones(id, descripcionMision, false);
            comboBox.addItem(new MisionDisplay(mision)); // Añadir el wrapper
            System.out.println("Cargando: ID: " + id + ", Descripción: " + descripcionMision); // Para verificar
        }

        System.out.println("ID de misión seleccionada: " + idMisionSeleccionada);

        for (int i = 0; i < comboBox.getItemCount(); i++) {
            MisionDisplay misionDisplay = (MisionDisplay) comboBox.getItemAt(i); // Obtener el wrapper
            Misiones mision = misionDisplay.getMision(); // Obtener el objeto Misiones

            System.out.println("Comparando con ID: " + mision.getIdMision());
            if (mision.getIdMision() == idMisionSeleccionada) {
                comboBox.setSelectedIndex(i); // Selecciona el índice
                break; // Salir del bucle una vez encontrado
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
   
 
 public void actualizarRegistro() {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();
    try {
        // Crear el PreparedStatement que ejecutará la Query de actualización
        PreparedStatement updateMisionTransporte = conexion.prepareStatement(
            "UPDATE Misiones_Transportes SET id_mision = ?, id_transporte = ? WHERE id_misionTransporte = ?"
        );

        // Establecer los valores que se van a actualizar
        int idMision = getId_mision(); // ID de la misión actualizado
        int idTransporte = getId_transporte(); // ID del bombero actualizado
        int idMisionTransporte = getId_misionTransporte(); // Este es el identificador único del registro a actualizar

        System.out.println("ID Misión: " + idMision);
        System.out.println("ID Transporte: " + idTransporte);
        System.out.println("ID Misión Transporte: " + idMisionTransporte);

        // Asignar valores a los placeholders de la consulta SQL
        updateMisionTransporte.setInt(1, idMision); // Establecer nuevo id_mision
        updateMisionTransporte.setInt(2, idTransporte); // Establecer nuevo id_bombero
        updateMisionTransporte.setInt(3, idMisionTransporte); // Condición para saber qué registro actualizar

        // Ejecutar la actualización
        int filasActualizadas = updateMisionTransporte.executeUpdate();

        // Confirmar si se actualizó alguna fila
        if (filasActualizadas > 0) {
            System.out.println("Registro actualizado correctamente.");
        } else {
            System.out.println("No se encontró el registro a actualizar.");
        }
    } catch (Exception ex) {
        System.out.println("Este es el error en el modelo: método actualizar " + ex);
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
 
 
public MisionesTransporte obtenerDatosTabla(frmRegistroTransportes vista) {
    try {
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = vista.jtRegistroTransporte.getSelectedRow();

        // Si hay una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada
            String descripcionMision = vista.jtRegistroTransporte.getValueAt(filaSeleccionada, 0).toString();
            String TipoVehiculo = vista.jtRegistroTransporte.getValueAt(filaSeleccionada, 1).toString();
            String placaVehiculo = vista.jtRegistroTransporte.getValueAt(filaSeleccionada, 2).toString();
            int idMisionTransporte = (Integer) vista.jtRegistroTransporte.getValueAt(filaSeleccionada, 3);
            int idMision = (Integer) vista.jtRegistroTransporte.getValueAt(filaSeleccionada, 4);
            int idTransporte = (Integer) vista.jtRegistroTransporte.getValueAt(filaSeleccionada, 5);

            // Devolver un nuevo objeto Mision con los datos obtenidos
            return new MisionesTransporte(descripcionMision, TipoVehiculo, placaVehiculo, idMisionTransporte, idMision, idTransporte);
        }

        // Si no hay una fila seleccionada, devolver null
        return null;
    } catch (ClassCastException e) {
        System.err.println("Error al convertir los datos de la tabla: " + e.getMessage());
    } catch (NullPointerException e) {
        System.err.println("Error: Campo nulo encontrado en la tabla: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Error general al obtener datos de la tabla: " + e.getMessage());
    }

    // Devolver null en caso de error
    return null;
}

   
   
   
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


