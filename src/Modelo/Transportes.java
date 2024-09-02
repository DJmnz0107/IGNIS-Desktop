package Modelo;


import Modelo.ClaseConexion;
import Vistas.frmAgregarTransportes;
import Vistas.frmVerRegistroTransporter;
import Vistas.frmVerRegistroTransporter;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Transportes {
    
    private int id_transporte;
    private String placa_transporte;
    private String numero_transporte;
    private int capacidad_transporte;
    private String tipoVehiculo_transporte;
    private String disponibilidad_transporte;
    private String estado_transporte;

    
    
    public Transportes() {
        // Inicialización si es necesario
    }

    // Constructor con parámetros
    public Transportes(int id, String placa, String numero, int capacidad, String tipoVehiculo, String disponibilidad, String estado) {
        this.id_transporte = id;
        this.placa_transporte = placa;
        this.numero_transporte = numero;
        this.capacidad_transporte = capacidad;
        this.tipoVehiculo_transporte = tipoVehiculo;
        this.disponibilidad_transporte = disponibilidad;
        this.estado_transporte = estado;
    }
    
    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    public String getPlaca_transporte() {
        return placa_transporte;
    }

    public void setPlaca_transporte(String placa_transporte) {
        this.placa_transporte = placa_transporte;
    }

    public String getNumero_transporte() {
        return numero_transporte;
    }

    public void setNumero_transporte(String numero_transporte) {
        this.numero_transporte = numero_transporte;
    }

    public int getCapacidad_transporte() {
        return capacidad_transporte;
    }

    public void setCapacidad_transporte(int capacidad_transporte) {
        this.capacidad_transporte = capacidad_transporte;
    }

    public String getTipoVehiculo_transporte() {
        return tipoVehiculo_transporte;
    }

    public void setTipoVehiculo_transporte(String tipoVehiculo_transporte) {
        this.tipoVehiculo_transporte = tipoVehiculo_transporte;
    }

    public String getDisponibilidad_transporte() {
        return disponibilidad_transporte;
    }

    public void setDisponibilidad_transporte(String disponibilidad_transporte) {
        this.disponibilidad_transporte = disponibilidad_transporte;
    }

    public String getEstado_transporte() {
        return estado_transporte;
    }

    public void setEstado_transporte(String estado_transporte) {
        this.estado_transporte = estado_transporte;
    }
    

    public void Mostrar(JTable tabla) {
        
        Connection conexion = ClaseConexion.getConexion();
 
        
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"id","placa", "numero", "capacidad", "Tipo de vehivulo","disponibilidad","estado"});
 
        try {
            
            Statement statement = conexion.createStatement();
 
           
            ResultSet rs = statement.executeQuery("SELECT * FROM Transportes");
 
            
            while (rs.next()) {
                
                modeloDeDatos.addRow(new Object[]{
                    rs.getInt("id_transporte"),
                    rs.getString("placa_transporte"),
                    rs.getString("numero_transporte"),
                    rs.getInt("capacidad_transporte"),
                    rs.getString("tipoVehiculo_transporte"),
                    rs.getString("disponibilidad_transporte"),
                    rs.getString("estado_transporte")});
            }
 
          
            tabla.setModel(modeloDeDatos);
            
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
   public void Guardar(){
    Connection conexion = ClaseConexion.getConexion();
    try {
        
        PreparedStatement addProducto = conexion.prepareStatement(
            "INSERT INTO Transportes (placa_transporte, numero_transporte, capacidad_transporte, tipoVehiculo_transporte, disponibilidad_transporte, estado_transporte) VALUES (?, ?, ?, ?, ?, ?)"
        );

        addProducto.setString(1, getPlaca_transporte());
        addProducto.setString(2, getNumero_transporte());
        addProducto.setInt(3, getCapacidad_transporte());
        addProducto.setString(4, getTipoVehiculo_transporte());  
        addProducto.setString(5, getDisponibilidad_transporte());  
        addProducto.setString(6, getEstado_transporte());
        
     
        addProducto.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Este es el error en el modelo: metodo guardar " + ex);
    }
}
   

   public void Limpiar (frmAgregarTransportes Vistas){
       
       Vistas.txtPlaca.setText("");
       Vistas.txtNumeroTransporte.setText("");
       Vistas.txtCapacidad.setText("");
       Vistas.txtEstado.setText("");
   
   }
   
   public void Eliminar(JTable tabla) {
    Connection conexion = ClaseConexion.getConexion();

    int filaSeleccionada = tabla.getSelectedRow();

    String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
    
    try {
        String sql = "DELETE FROM Transportes WHERE id_transporte = ?";
        PreparedStatement deleteTransporte = conexion.prepareStatement(sql);

        
        int idTransporte = Integer.parseInt(miId);
        deleteTransporte.setInt(1, idTransporte);

        deleteTransporte.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Este es el error en el método de eliminar: " + e);
    }
}

   

public Transportes obtenerDatosTabla(frmVerRegistroTransporter vista) {
    int filaSeleccionada = vista.jtTransportes.getSelectedRow();

    if (filaSeleccionada != -1) {
        int id = (Integer) vista.jtTransportes.getValueAt(filaSeleccionada, 0);
        String placa = vista.jtTransportes.getValueAt(filaSeleccionada, 1).toString();
        String numero = vista.jtTransportes.getValueAt(filaSeleccionada, 2).toString();
        Object capacidadObj = vista.jtTransportes.getValueAt(filaSeleccionada, 3);
        int capacidadTransporte = (capacidadObj instanceof Integer) ? (Integer) capacidadObj : ((Number) capacidadObj).intValue();
        String tipoVehiculo = vista.jtTransportes.getValueAt(filaSeleccionada, 4).toString();
        String disponibilidadTransporte = vista.jtTransportes.getValueAt(filaSeleccionada, 5).toString();
        String estadoTransporte = vista.jtTransportes.getValueAt(filaSeleccionada, 6).toString();

        return new Transportes(id, placa, numero, capacidadTransporte, tipoVehiculo, disponibilidadTransporte, estadoTransporte);
    }
    return null;
}
    
    
public void actualizarTransportes() {
    
        Connection conexion = ClaseConexion.getConexion();

        try { 
        PreparedStatement updateTransporte = conexion.prepareStatement("update Transportes set placa_transporte = ?, numero_transporte = ?, capacidad_transporte = ?,  tipoVehiculo_transporte  = ?,  disponibilidad_transporte = ?, estado_transporte = ? where id_transporte = ?");

        updateTransporte.setString(1, getPlaca_transporte());
        updateTransporte.setString(2, getNumero_transporte());
        updateTransporte.setInt(3, getCapacidad_transporte());
        updateTransporte.setString(4, getTipoVehiculo_transporte());
        updateTransporte.setString(5, getDisponibilidad_transporte());
        updateTransporte.setString(6, getEstado_transporte());
        updateTransporte.setInt(7, getId_transporte());

        updateTransporte.executeUpdate();





    } catch (Exception e) {
        System.out.println("este es el error en el metodo de actualizar" + e);
    }
}
    

    
}
