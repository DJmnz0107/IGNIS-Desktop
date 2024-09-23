package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aless
 */
public class Informes {

    public int getId_informe() {
        return id_informe;
    }

    public void setId_informe(int id_informe) {
        this.id_informe = id_informe;
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    public String getResultado_mision() {
        return resultado_mision;
    }

    public void setResultado_mision(String resultado_mision) {
        this.resultado_mision = resultado_mision;
    }

    public String getDescripción_mision() {
        return descripción_mision;
    }

    public void setDescripción_mision(String descripción_mision) {
        this.descripción_mision = descripción_mision;
    }
    
    private int id_informe;
    private int id_mision;
    private String resultado_mision;
    private String descripción_mision;
    
    public void Mostrar(JTable tabla) {   
        Connection conexion = ClaseConexion.getConexion();
    
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"ID Informe", "Descripción Emergencia", "Resultado", "Descripción"});
    
        try {
            Statement statement = conexion.createStatement();
        
            ResultSet rs = statement.executeQuery("SELECT i.id_informe, e.descripcion_emergencia, i.resultado_mision, i.descripcion_mision FROM Informes i "
                    + "INNER JOIN Misiones m ON i.id_mision = m.id_mision INNER JOIN Emergencias e ON m.id_emergencia = e.id_emergencia");
        
            while (rs.next()) {
                modeloDeDatos.addRow(new Object[]{
                    rs.getInt("id_informe"),
                    rs.getString("descripcion_emergencia"),
                    rs.getString("resultado_mision"),
                    rs.getString("descripcion_mision")
                });
            }
        
        tabla.setModel(modeloDeDatos);
        
        // Ocultar la columna del ID Informe si es necesario
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, método mostrar: " + e);
        }
    }

    public void Eliminar(JTable tabla) {
        Connection conexion = ClaseConexion.getConexion();

        int filaSeleccionada = tabla.getSelectedRow();

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
        try {
            String sql = "DELETE FROM Informes WHERE id_informe = ?";
            PreparedStatement deleteInforme = conexion.prepareStatement(sql);

        
            int idInforme = Integer.parseInt(miId);
            deleteInforme.setInt(1, idInforme);

            deleteInforme.executeUpdate();
        
        } catch (Exception e) {
            System.out.println("Este es el error en el método de eliminar: " + e);
        }
    }
    
    public void Buscar(JTable tabla, JTextField JTextField1) {
        Connection conexion = ClaseConexion.getConexion();
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"ID Informe", "Descripción Emergencia", "Resultado", "Descripción"});

        try {
            String sql = "SELECT i.id_informe, e.descripcion_emergencia, i.resultado_mision, i.descripcion_mision FROM Informes i "
                + "INNER JOIN Misiones m ON i.id_mision = m.id_mision INNER JOIN Emergencias e ON m.id_emergencia = e.id_emergencia "
                + "WHERE e.descripcion_emergencia LIKE ? || '%'";

            PreparedStatement buscarRecurso = conexion.prepareStatement(sql);
            buscarRecurso.setString(1, JTextField1.getText());
            ResultSet rs = buscarRecurso.executeQuery();

            while (rs.next()) {
                int idInforme = rs.getInt("id_informe");
                String descripcionEmergencia = rs.getString("descripcion_emergencia");
                String resultado = rs.getString("resultado_mision");
                String descripcion = rs.getString("descripcion_mision");

                modeloDeDatos.addRow(new Object[]{idInforme, descripcionEmergencia, resultado, descripcion});
            }

            tabla.setModel(modeloDeDatos);
        
            // Ocultar columnas si es necesario
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);

        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, método de buscar: " + e);
        }
    }


}
