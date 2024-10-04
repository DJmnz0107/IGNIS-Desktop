/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
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
    
    
    public void Guardar()
    {
          Connection conexion = ClaseConexion.getConexion();
          try{
             PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO Misiones_Recursos (id_mision, id_recurso) VALUES (?,?)");
               addProducto.setInt(1,getId_mision());
                addProducto.setInt(1,getId_recurso());
                
                addProducto.executeUpdate();
          
          
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
    
    public void Mostrar(JTable tabla){
    Connection conexion =ClaseConexion.getConexion();
    DefaultTableModel modeloDeDatos = new DefaultTableModel();
    modeloDeDatos.setColumnIdentifiers(new Object[]{"id","Mision","Recurso"});
    
    try{
    
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT M.descripcion_mision AS nombre_mision, " +
             "R.nombre_recurso AS nombre_recurso " +
             "FROM Misiones_Recursos MR " +
             "INNER JOIN Misiones M ON MR.id_mision = M.id_mision " +
             "INNER JOIN Recursos R ON MR.id_recurso = R.id_recurso;");
        
        while (rs.next()){
        modeloDeDatos.addRow(new Object[]{
          rs.getInt("id_misionRecurso"),
          rs.getInt("id_mision"),
          rs.getInt("id_recurso")
        });
        
        tabla.setModel(modeloDeDatos);
        }
    }catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    
    }
    
   
}

