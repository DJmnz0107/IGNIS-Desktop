
package Modelo;

import Vistas.frmRegistroMisionesBomberos;
import Vistas.frmVerRegistroMisiones;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class MisionesBomberos {

    private MisionesBomberos(String descripcionMision, String nombreBombero, String apellidoBombero, int idMisionBombero, int idMision, int idBombero) {
        this.descipcionMision = descripcionMision;
        this.nombre_bombero = nombreBombero;
        this.apellido_bombero = apellidoBombero;
        this.id_misionesbombero = idMisionBombero;
        this.id_mision = idMision;
        this.id_bombero = idBombero;
    }

    /**
     * @return the nombre_bombero
     */
    public String getNombre_bombero() {
        return nombre_bombero;
    }

    /**
     * @param nombre_bombero the nombre_bombero to set
     */
    public void setNombre_bombero(String nombre_bombero) {
        this.nombre_bombero = nombre_bombero;
    }

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

    /**
     * @return the descipcionMision
     */
    public String getDescipcionMision() {
        return descipcionMision;
    }

    /**
     * @param descipcionMision the descipcionMision to set
     */
    public void setDescipcionMision(String descipcionMision) {
        this.descipcionMision = descipcionMision;
    }
    
   private int id_misionesbombero;
   private int id_mision;
   private int id_bombero;
   private String descipcionMision;
      private String nombre_bombero;
    private String apellido_bombero;

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
    
        public MisionesBomberos(int id, String nombre, String apellido){
        this.id_bombero = id;
        this.nombre_bombero = nombre;
        this.apellido_bombero = apellido;
        
    }
        
           public MisionesBomberos(){
        
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
            comboBox.addItem(new BomberoDisplay(new Bomberos(id, nombre, apellido))); // Añadir el wrapper
        }

        // Seleccionar el bombero que coincide con el ID
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            BomberoDisplay bomberoDisplay = (BomberoDisplay) comboBox.getItemAt(i); // Obtener el wrapper
            Bomberos bombero = bomberoDisplay.getBombero(); // Obtener el objeto Bomberos

            if (bombero.getId_bombero() == idBomberoSeleccionado) {
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




public void obtenerBomberos(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Bomberos");

        while (rs.next()) {
            int id = rs.getInt("id_bombero");
            String nombre = rs.getString("nombre_bombero");
            String apellido = rs.getString("apellido_bombero");
            comboBox.addItem(new BomberoDisplay(new Bomberos(id, nombre, apellido)));
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
            "INSERT INTO Misiones_Bomberos (id_mision, id_bombero) VALUES (?, ?)"
        );

        // Establecer valores de la consulta SQL
        int idMision = getId_mision();
        int idBombero = getId_bombero();

        System.out.println("ID Misión: " + idMision);
        System.out.println("ID Bombero: " + idBombero);

        addMisionBombero.setInt(1, idMision);
        addMisionBombero.setInt(2, idBombero);

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

public void actualizarRegistro() {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();
    try {
        // Crear el PreparedStatement que ejecutará la Query de actualización
        PreparedStatement updateMisionBombero = conexion.prepareStatement(
            "UPDATE Misiones_Bomberos SET id_mision = ?, id_bombero = ? WHERE id_misionBombero = ?"
        );

        // Establecer los valores que se van a actualizar
        int idMision = getId_mision(); // ID de la misión actualizado
        int idBombero = getId_bombero(); // ID del bombero actualizado
        int idMisionBombero = getId_misionesbombero(); // Este es el identificador único del registro a actualizar

        System.out.println("ID Misión: " + idMision);
        System.out.println("ID Bombero: " + idBombero);
        System.out.println("ID Misión Bombero: " + idMisionBombero);

        // Asignar valores a los placeholders de la consulta SQL
        updateMisionBombero.setInt(1, idMision); // Establecer nuevo id_mision
        updateMisionBombero.setInt(2, idBombero); // Establecer nuevo id_bombero
        updateMisionBombero.setInt(3, idMisionBombero); // Condición para saber qué registro actualizar

        // Ejecutar la actualización
        int filasActualizadas = updateMisionBombero.executeUpdate();

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



   public MisionesBomberos obtenerDatosTabla(frmRegistroMisionesBomberos vista) {
    // Obtener la fila seleccionada de la tabla
    int filaSeleccionada = vista.jtMisionesBomberos.getSelectedRow();

    // Si hay una fila seleccionada
    if (filaSeleccionada != -1) {
        // Obtener los datos de la fila seleccionada
        String descripcionMision = vista.jtMisionesBomberos.getValueAt(filaSeleccionada, 3).toString();
        String nombreBombero = vista.jtMisionesBomberos.getValueAt(filaSeleccionada, 0).toString();
        String apellidoBombero = vista.jtMisionesBomberos.getValueAt(filaSeleccionada, 1).toString();
        int idMisionBombero = (Integer) vista.jtMisionesBomberos.getValueAt(filaSeleccionada, 7);
        int idMision = (Integer) vista.jtMisionesBomberos.getValueAt(filaSeleccionada, 5);
        int idBombero = (Integer) vista.jtMisionesBomberos.getValueAt(filaSeleccionada, 6);

        // Devolver un nuevo objeto Mision con los datos obtenidos
        return new MisionesBomberos(descripcionMision, nombreBombero, apellidoBombero, idMisionBombero, idMision, idBombero);
    }

    // Si no hay una fila seleccionada, devolver null
    return null;
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
