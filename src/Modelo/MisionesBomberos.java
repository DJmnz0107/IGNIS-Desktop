
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JTextField;


public class MisionesBomberos {
    
   private int id_misionesbombero;
   private int id_mision;
   private int id_bombero;

    public int getId_misionesbombero() {
        return id_misionesbombero;
    }

    public void setId_misionesbombero(int id_misionesbombero) {
        this.id_misionesbombero = id_misionesbombero;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    public int getId_bombero() {
        return id_bombero;
    }

    public void setId_bombero(int id_bombero) {
        this.id_bombero = id_bombero;
    }
    
     public void Mostrar(JTable tabla) {
    // Creamos una variable de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();

    // Definimos el modelo de la tabla
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{
        "Nombre Bombero", "Apellido Bombero", "Especialización Bombero", "Descripción Misión", "Fecha Misión", "ID Misión", "ID Bombero", "ID Misión Bombero"
    });     
    try {
        // Creamos un Statement
        Statement statement = conexion.createStatement();

        // Ejecutamos el Statement con la consulta INNER JOIN y lo asignamos a una variable de tipo ResultSet
        String consulta = "SELECT B.nombre_bombero, B.apellido_bombero, B.especializacion_bombero, " +
                          "M.descripcion_mision, M.fecha_mision, " +
                          "MB.id_mision, MB.id_bombero, MB.id_misionBombero " +
                          "FROM Misiones_Bomberos MB " +
                          "INNER JOIN Misiones M ON MB.id_mision = M.id_mision " +
                          "INNER JOIN Bomberos B ON MB.id_bombero = B.id_bombero";
        ResultSet rs = statement.executeQuery(consulta);

        // Recorremos el ResultSet
        while (rs.next()) {
            // Llenamos el modelo con los datos obtenidos del ResultSet
            modeloDeDatos.addRow(new Object[]{
                rs.getString("nombre_bombero"),
                rs.getString("apellido_bombero"),
                rs.getString("especializacion_bombero"),
                rs.getString("descripcion_mision"),
                rs.getDate("fecha_mision"),
                rs.getInt("id_mision"),
                rs.getInt("id_bombero"),
                rs.getInt("id_misionBombero")
            });
        }

        // Asignamos el nuevo modelo lleno a la tabla
        tabla.setModel(modeloDeDatos);

        // Ocultar las columnas ID
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(0);
    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo mostrar: " + e);
    }
}
     
     public void guardar() {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();
    try {
        // Creamos el PreparedStatement que ejecutará la Query
        PreparedStatement addMisionBombero = conexion.prepareStatement(
            "INSERT INTO Misiones_Bomberos (id_mision, id_bombero) VALUES (?, ?)"
        );

        // Establecer valores de la consulta SQL
        addMisionBombero.setInt(1, getId_misionesbombero());
        addMisionBombero.setInt(2, getId_bombero());

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


     public void Eliminar(JTable tabla) {
    // Obtenemos la conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();

    // Obtenemos la fila seleccionada
    int filaSeleccionada = tabla.getSelectedRow();

    // Obtenemos el valor del ID de la columna 7 que corresponde a 'id_misionBombero'
    String miId = tabla.getValueAt(filaSeleccionada, 7).toString();

    try {
        // Definimos la consulta SQL para eliminar en la tabla 'Misiones_Bomberos'
        String sql = "DELETE FROM Misiones_Bomberos WHERE id_misionBombero = ?";
        PreparedStatement deleteMisionBombero = conexion.prepareStatement(sql);

        // Convertimos el ID a entero y lo asignamos al parámetro del PreparedStatement
        int idMisionBombero = Integer.parseInt(miId);
        deleteMisionBombero.setInt(1, idMisionBombero);

        // Ejecutamos la actualización para eliminar el registro
        deleteMisionBombero.executeUpdate();

        System.out.println("Registro eliminado correctamente.");

    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }
 } 
     
     public void Buscar(JTable tabla, JTextField jtMisionesBomberos) {
    // Conexión a la base de datos
    Connection conexion = ClaseConexion.getConexion();

    // Modelo de la tabla
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{
        "Nombre Bombero", "Apellido Bombero", "Especialización Bombero", "Descripción Misión", "Fecha Misión", "ID Misión", "ID Bombero", "ID Misión Bombero"
    });

    try {
        // Consulta SQL con INNER JOIN y búsqueda por nombre de bombero
        String sql = "SELECT B.nombre_bombero, B.apellido_bombero, B.especializacion_bombero, " +
                     "M.descripcion_mision, M.fecha_mision, MB.id_mision, MB.id_bombero, MB.id_misionBombero " +
                     "FROM Misiones_Bomberos MB " +
                     "INNER JOIN Misiones M ON MB.id_mision = M.id_mision " +
                     "INNER JOIN Bomberos B ON MB.id_bombero = B.id_bombero " +
                     "WHERE B.nombre_bombero LIKE ? || '%'";

        // Preparar la sentencia
        PreparedStatement buscarPorNombre = conexion.prepareStatement(sql);
        buscarPorNombre.setString(1, jtMisionesBomberos.getText());

        // Ejecutar la consulta
        ResultSet rs = buscarPorNombre.executeQuery();

        // Recorrer los resultados
        while (rs.next()) {
            String nombreBombero = rs.getString("nombre_bombero");
            String apellidoBombero = rs.getString("apellido_bombero");
            String especializacionBombero = rs.getString("especializacion_bombero");
            String descripcionMision = rs.getString("descripcion_mision");
            Date fechaMision = rs.getDate("fecha_mision");
            int idMision = rs.getInt("id_mision");
            int idBombero = rs.getInt("id_bombero");
            int idMisionBombero = rs.getInt("id_misionBombero");

            // Agregar filas al modelo
            modeloDeDatos.addRow(new Object[]{
                nombreBombero, apellidoBombero, especializacionBombero, descripcionMision, fechaMision, idMision, idBombero, idMisionBombero
            });
        }

        // Asignar el modelo a la tabla
        tabla.setModel(modeloDeDatos);

        // Ocultar las columnas de ID
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(0);

    } catch (Exception e) {
        System.out.println("Este es el error en el método BuscarPorNombre: " + e);
    }
}


    
}
