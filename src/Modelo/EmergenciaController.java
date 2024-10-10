package modelo;

import Vistas.frmNotificacionEmergencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class EmergenciaController {

    private Connection conexion;
    private Set<Integer> emergenciasMostradas = new HashSet<>();
        private frmNotificacionEmergencia vistaNotificacion;
        
       public static int idEmergencia =0;

    public EmergenciaController(Connection conexion) {
        this.conexion = conexion;
        this.vistaNotificacion = new frmNotificacionEmergencia();
        checkForNewEmergencies();
    }

 public void checkForNewEmergencies() {
    new Timer().schedule(new TimerTask() {
        @Override
        public void run() {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT id_emergencia, descripcion_emergencia, gravedad_emergencia, tipo_emergencia " +
                             "FROM Emergencias WHERE respuesta_notificacion = 'En espera'";
                stmt = conexion.prepareStatement(sql);
                rs = stmt.executeQuery();

                while (rs.next()) {
                     idEmergencia = rs.getInt("id_emergencia");
                    if (!emergenciasMostradas.contains(idEmergencia)) {
                        String descripcion = rs.getString("descripcion_emergencia");
                        String gravedad = rs.getString("gravedad_emergencia");
                        String tipo = rs.getString("tipo_emergencia");

                        // Crear una nueva instancia de frmNotificacionEmergencia
                        frmNotificacionEmergencia nuevaVentana = new frmNotificacionEmergencia();
                        nuevaVentana.initfrmNotificacionEmergencia(descripcion, gravedad, tipo);

                        // Marcar la emergencia como mostrada
                        emergenciasMostradas.add(idEmergencia);

                        // Actualizar la base de datos
                        String updateSql = "UPDATE Emergencias SET respuesta_notificacion = 'Notificada' WHERE id_emergencia = ?";
                        PreparedStatement updateStmt = conexion.prepareStatement(updateSql);
                        updateStmt.setInt(1, idEmergencia);
                        updateStmt.executeUpdate();
                        updateStmt.close();
                    }
                }

            } catch (Exception e) {
                System.out.println("Error al consultar emergencias: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }, 0, 1000); // Ejecutar cada segundo
}




}
