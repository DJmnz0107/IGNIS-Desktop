/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Vistas.frmAsignarRecursosVer;
import Vistas.frmAsignarRecursos;
import java.sql.*;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
/**
 *
 * @author USUARIO
 */
public class MisionesRecursos {

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

    private MisionesRecursos(int idMisionRecurso, int idMision, int idRecurso, String descripcionMision, String nombreRecurso, String descripcionRecurso) {
        this.id_misionRecurso = idMisionRecurso;
        this.id_mision = idMision;
        this.id_recurso = idRecurso;
        this.descripcion_Mision = descripcionMision;
        this.nombre_Recurso = nombreRecurso;
        this.descripcionRecurso = descripcionRecurso;
    }

    /**
     * @return the id_misionRecurso
     */
    public int getId_misionRecurso() {
        return id_misionRecurso;
    }

    /**
     * @param id_misionRecurso the id_misionRecurso to set
     */
    public void setId_misionRecurso(int id_misionRecurso) {
        this.id_misionRecurso = id_misionRecurso;
    }

    /**
     * @return the id_mision
     */
    public int getId_mision() {
        return id_mision;
    }

    /**
     * @param id_mision the id_mision to set
     */
    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    /**
     * @return the id_recurso
     */
    public int getId_recurso() {
        return id_recurso;
    }

    /**
     * @param id_recurso the id_recurso to set
     */
    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }
    
    private int id_misionRecurso;
    private int id_mision;
    private int id_recurso;
    private String descripcion_Mision;
    private String nombre_Recurso;
    private String descripcionRecurso;

    public String getNombre_Recurso() {
        return nombre_Recurso;
    }

    public void setNombre_Recurso(String nombre_Recurso) {
        this.nombre_Recurso = nombre_Recurso;
    }

    public String getDescripcion_Mision() {
        return descripcion_Mision;
    }

    public void setDescripcion_Mision(String descripcion_Mision) {
        this.descripcion_Mision = descripcion_Mision;
    }
    
    public MisionesRecursos(){
            
    }
    
    public MisionesRecursos(int id, String nombre){
      this.id_mision = id;
      this.descripcion_Mision = nombre;
    }
    
    public MisionesRecursos(int id, String nombre,boolean Misiones){
      this.id_recurso = id;
      this.descripcionRecurso = nombre;
    }
    
     @Override
    public String toString() {
        return descripcionRecurso;
    }
    
    
    public MisionesRecursos obtenerDatosTabla(JTable tabla) {
    // Obtener la fila seleccionada de la tabla
    int filaSeleccionada = tabla.getSelectedRow();

    // Si hay una fila seleccionada
    if (filaSeleccionada != -1) {
        // Obtener los datos de la fila seleccionada
        int idMisionRecurso = (Integer) tabla.getValueAt(filaSeleccionada, 0);
        int idMision = (Integer) tabla.getValueAt(filaSeleccionada, 1);
        int idRecurso = (Integer) tabla.getValueAt(filaSeleccionada, 2);
        String descripcionMision = tabla.getValueAt(filaSeleccionada, 3).toString();
        String nombreRecurso = tabla.getValueAt(filaSeleccionada, 5).toString();
        String descripcionRecurso = tabla.getValueAt(filaSeleccionada, 6).toString();

        // Devolver un nuevo objeto MisionesRecurso con los datos obtenidos
        return new MisionesRecursos(idMisionRecurso, idMision, idRecurso, descripcionMision, nombreRecurso, descripcionRecurso);
    }

    // Si no hay una fila seleccionada, devolver null
    return null;
}
    
    
    public void cargarComboRecursosUpdate(JComboBox comboBox, int idRecursoSeleccionado) {    
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT id_recurso, descripcion_recurso FROM Recursos");
        
        while (rs.next()) {
            int id = rs.getInt("id_recurso"); 
            String nombre = rs.getString("descripcion_recurso");
     MisionesRecursos recurso = new MisionesRecursos(id, nombre, false); // Se usa el constructor adecuado
            comboBox.addItem(recurso); // Añade el objeto recurso al JComboBox
            System.out.println("Cargando: ID: " + id + ", Descripción: " + nombre); // Para verificar
        }
        
        System.out.println("ID de emergencia seleccionada: " + idRecursoSeleccionado);
        
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            MisionesRecursos mision = (MisionesRecursos) comboBox.getItemAt(i);
            System.out.println("Comparando con ID: " + mision.getId_recurso());
            if (mision.getId_recurso() == idRecursoSeleccionado) {
                comboBox.setSelectedIndex(i); // Selecciona el índice
                break; // Salir del bucle una vez encontrado
            }
        }
    } catch(SQLException ex) {
        ex.printStackTrace();  
    }
}
    
    public void actualizarRegistro() {
    // Creamos una variable igual a ejecutar el método de la clase de conexión
    Connection conexion = ClaseConexion.getConexion();
    try {
        // Crear el PreparedStatement que ejecutará la Query de actualización
        PreparedStatement updateMisionRecurso = conexion.prepareStatement(
            "UPDATE Misiones_Recursos SET id_mision = ?, id_recurso = ? WHERE id_misionRecurso = ?"
        );

        // Establecer los valores que se van a actualizar
        int idMision = getId_mision(); // ID de la misión actualizada
        int idRecurso = getId_recurso(); // ID del recurso actualizado
        int idMisionRecurso = getId_misionRecurso(); // Este es el identificador único del registro a actualizar

        // Mensajes de depuración para confirmar los valores
        System.out.println("ID Misión: " + idMision);
        System.out.println("ID Recurso: " + idRecurso);
        System.out.println("ID Misión Recurso: " + idMisionRecurso);

        // Asignar valores a los placeholders de la consulta SQL
        updateMisionRecurso.setInt(1, idMision); // Establecer nuevo id_mision
        updateMisionRecurso.setInt(2, idRecurso); // Establecer nuevo id_recurso
        updateMisionRecurso.setInt(3, idMisionRecurso); // Condición para saber qué registro actualizar

        // Ejecutar la actualización
        int filasActualizadas = updateMisionRecurso.executeUpdate();

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


    
    
    
    
    
    public void CargarComboMisiones(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Misiones");

        while (rs.next()) {
            int id = rs.getInt("id_mision");
            String nombre = rs.getString("descripcion_Mision");
          Misiones mision = new Misiones(id, nombre, false);
            comboBox.addItem(new MisionDisplay(mision)); // Añadir el wrapper
        }
    } catch(SQLException ex) {
        ex.printStackTrace();  
    }
}
    public void CargarComboRecursos(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();  // Limpia los elementos anteriores en el combo
    try {
        Statement statement = conexion.createStatement();
        String sql = "SELECT id_recurso, descripcion_recurso FROM Recursos";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id_recurso");
            String nombre = rs.getString("descripcion_recurso");

            // Crea un nuevo objeto MisionesRecursos para cada recurso y añádelo al combo
            MisionesRecursos recurso = new MisionesRecursos(id, nombre, false); // Se usa el constructor adecuado
            comboBox.addItem(recurso); // Añade el objeto recurso al JComboBox
        }
    } catch(SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar recursos
        try {
            conexion.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
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

     
    
    
    
    public void Guardar()
    {
          Connection conexion = ClaseConexion.getConexion();
          try{
             PreparedStatement addRecu = conexion.prepareStatement("INSERT INTO Misiones_Recursos (id_mision, id_recurso) VALUES (?,?)");
               addRecu.setInt(1,getId_mision());
                addRecu.setInt(2,getId_recurso());
                
                addRecu.executeUpdate();
          
          
          }catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
    public void Eliminar(JTable tabla){
    
        Connection conexion =ClaseConexion.getConexion();
    int filaSeleccionada = tabla.getSelectedRow();
    String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
    try {
    
        String sql="DELETE FROM Misiones_Recursos WHERE id_misionRecurso = ?";
        PreparedStatement deleteMisionesRecu =conexion.prepareStatement(sql);
        
        int idMisioneRecu = Integer.parseInt(miId);
        
        deleteMisionesRecu.setInt(1,idMisioneRecu);
        deleteMisionesRecu.executeUpdate();
        
        
    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }
    }
   
    
public void Mostrar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{
        "id", "Id-Mision", "Id_Recurso", "Descripcion de Mision", "Fecha de Mision", "Recurso", "Descripcion de Recurso"
    });

    Statement statement = null;
    ResultSet rs = null;

    try {
        statement = conexion.createStatement();
        String consulta = "SELECT MR.id_misionRecurso AS id_misionRecurso, "
                + "MR.id_mision AS id_mision, "
                + "MR.id_recurso AS id_recurso, "
                + "M.descripcion_mision AS nombre_mision, "
                + "M.fecha_mision AS fecha_mision, "
                + "R.nombre_recurso AS nombre_recurso, "
                + "R.descripcion_recurso AS descripcion_recurso "
                + "FROM Misiones_Recursos MR "
                + "INNER JOIN Misiones M ON MR.id_mision = M.id_mision "
                + "INNER JOIN Recursos R ON MR.id_recurso = R.id_recurso";

        System.out.println("Consulta SQL ejecutada: " + consulta); // Mensaje de depuración
        rs = statement.executeQuery(consulta);

        int rowCount = 0; // Contador de filas recuperadas

        while (rs.next()) {
            modeloDeDatos.addRow(new Object[]{
                rs.getInt("id_misionRecurso"),
                rs.getInt("id_mision"),
                rs.getInt("id_recurso"),
                rs.getString("nombre_mision"),
                rs.getString("fecha_mision"),
                rs.getString("nombre_recurso"),
                rs.getString("descripcion_recurso")
            });
            rowCount++; // Incrementar el contador por cada fila recuperada
        }

        // Ahora asignamos el modelo a la tabla
        tabla.setModel(modeloDeDatos);

        // Mensaje de depuración para el número de filas recuperadas
        System.out.println("Número de filas recuperadas: " + rowCount);

        // Ocultamos las columnas que no queremos mostrar
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);

        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(0);

        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(0);

    } catch (Exception e) {
        System.out.println("Este es el error en el modelo, metodo mostrar: " + e);
    } finally {
        // Asegúrate de cerrar el ResultSet, Statement y la conexión
        try {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (conexion != null) conexion.close();
        } catch (Exception ex) {
            System.out.println("Error cerrando los recursos: " + ex);
        }
    }
}



    public void Buscar(JTable tabla, JTextField JTextFieldDescripRecurso ){
    Connection conexion = ClaseConexion.getConexion();
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{"id","Id-Mision","Id_Recurso","Descripcion de Mision:","Fecha de Mision","Recurso:","Descripcion de Recurso:"});
    
    try{
      String sql = "SELECT MR.id_misionRecurso AS id_misionRecurso, "
           + "MR.id_mision AS id_mision, "
           + "MR.id_recurso AS id_recurso, "
           + "M.descripcion_mision AS nombre_mision, "
           + "M.fecha_mision AS fecha_mision, "
           + "R.nombre_recurso AS nombre_recurso, "
           + "R.descripcion_recurso AS descripcion_recurso "
           + "FROM Misiones_Recursos MR "
           + "INNER JOIN Misiones M ON MR.id_mision = M.id_mision "
           + "INNER JOIN Recursos R ON MR.id_recurso = R.id_recurso "
           + "WHERE R.descripcion_recurso LIKE ? || '%' "; 
      
      PreparedStatement BuscarPorDescrpcionRecurso = conexion.prepareStatement(sql);
      BuscarPorDescrpcionRecurso.setString(1, JTextFieldDescripRecurso.getText());
      
      ResultSet rs = BuscarPorDescrpcionRecurso.executeQuery();
       while (rs.next()) {
    String nombreMision = rs.getString("nombre_mision");
    String fechaMision = rs.getString("fecha_mision");
    String nombreRecurso = rs.getString("nombre_recurso");
    String descripcionRecurso = rs.getString("descripcion_recurso");
    int idMisionRecurso = rs.getInt("id_misionRecurso");
    int idMision = rs.getInt("id_mision");
    int idRecurso = rs.getInt("id_recurso");

    
    modeloDeDatos.addRow(new Object[]{
        idMisionRecurso, idMision, idRecurso, nombreMision, fechaMision, nombreRecurso, descripcionRecurso
    });
    
    
}
    tabla.setModel(modeloDeDatos);
    
    
    tabla.getColumnModel().getColumn(0).setMinWidth(0);
    tabla.getColumnModel().getColumn(0).setMaxWidth(0);
    tabla.getColumnModel().getColumn(0).setPreferredWidth(0);

    tabla.getColumnModel().getColumn(1).setMinWidth(0);
    tabla.getColumnModel().getColumn(1).setMaxWidth(0);
    tabla.getColumnModel().getColumn(1).setPreferredWidth(0);

    tabla.getColumnModel().getColumn(2).setMinWidth(0);
    tabla.getColumnModel().getColumn(2).setMaxWidth(0);
    tabla.getColumnModel().getColumn(2).setPreferredWidth(0);

    
    
    }

    catch (Exception e) {
        System.out.println("Este es el error en el modelo, método BuscarPorDescrpcionRecurso: " + e);
    }
    
   }}

