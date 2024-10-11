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
      this.nombre_Recurso = nombre;
    }
    
     @Override
    public String toString() {
        return nombre_Recurso;
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
        String sql = "SELECT id_recurso, nombre_Recurso FROM Recursos";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id_recurso");
            String nombre = rs.getString("nombre_Recurso");

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
    public void Actualizar(){
      Connection conexion = ClaseConexion.getConexion();
      
    try{
        PreparedStatement updateMisionRecurso = conexion.prepareStatement("UPDATE Misiones_Recursos SET id_mision = ?, id_recurso = ? WHERE id_misionRecurso = ?");
        
        
        updateMisionRecurso.setInt(1, getId_mision());
        updateMisionRecurso.setInt(2,getId_recurso());
        updateMisionRecurso.setInt(3,getId_misionRecurso());
        
        updateMisionRecurso.executeUpdate();
    }catch (Exception e) {
        System.out.println("este es el error en el metodo de actualizar" + e);
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

