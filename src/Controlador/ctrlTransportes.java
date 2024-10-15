package Controlador;

import Modelo.CambioSistema;
import Modelo.ClaseConexion;
import Modelo.Transportes;
import Modelo.Usuarios;
import Vistas.frmAgregarTransportes;
import Vistas.frmInicio;
import Vistas.frmVerRegistroTransporter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.EmergenciaController;
import raven.drawer.Drawer;


public class ctrlTransportes implements MouseListener{
    
    private Transportes Modelo;
    private frmAgregarTransportes VistasverRegistroTransporter;
                                private static EmergenciaController controller; // Mueve el controlador a un campo estático

    
    public ctrlTransportes (Transportes modelo, frmAgregarTransportes VistasverRegistroTransporter){
    
        this.Modelo = modelo;
        this.VistasverRegistroTransporter = VistasverRegistroTransporter;

        
        
         this.VistasverRegistroTransporter.btnAgregar.addMouseListener(this);
         
         
         this.VistasverRegistroTransporter.btnVerRegistro.addMouseListener(this);
         this.VistasverRegistroTransporter.btnMenu.addMouseListener(this);
        
         this.VistasverRegistroTransporter.imgBack.addMouseListener(this);
         
         
             Connection conexion = ClaseConexion.getConexion();
                            // Verifica si el controlador ya ha sido creado
                            if (controller == null) {
                                controller = new EmergenciaController(conexion);
                            }
        
    }
        
    private void guardarTransporte() {
        
        String tipoVehiculo = VistasverRegistroTransporter.cmbAgregarTransportes.getSelectedItem().toString();
        String disponibilidad = VistasverRegistroTransporter.cmbDisponibilidad.getSelectedItem().toString();

        
        Modelo.setTipoVehiculo_transporte(tipoVehiculo);
        Modelo.setDisponibilidad_transporte(disponibilidad);

        
        Modelo.setPlaca_transporte(VistasverRegistroTransporter.txtPlaca.getText());
        Modelo.setNumero_transporte(VistasverRegistroTransporter.txtNumeroTransporte.getText());
        Modelo.setCapacidad_transporte(Integer.parseInt(VistasverRegistroTransporter.txtCapacidad.getText()));
        Modelo.setEstado_transporte(VistasverRegistroTransporter.txtEstado.getText());
  
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== this.VistasverRegistroTransporter.imgBack){
        frmInicio.initfrmInicio();
        VistasverRegistroTransporter.dispose();
        }
        
       if(e.getSource()== VistasverRegistroTransporter.btnAgregar){
                
           if(VistasverRegistroTransporter.txtCapacidad.getText().isEmpty() || VistasverRegistroTransporter.txtEstado.getText().isEmpty() || VistasverRegistroTransporter.txtNumeroTransporte.getText().isEmpty() || VistasverRegistroTransporter.txtPlaca.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(VistasverRegistroTransporter, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si hay campos vacíos
            }

            if (VistasverRegistroTransporter.txtNumeroTransporte.getText().length() != 4) {
    JOptionPane.showMessageDialog(VistasverRegistroTransporter, "Ingrese exactamente 4 dígitos", "Número transporte", JOptionPane.ERROR_MESSAGE);
    return;
}
                     String capacidadText = VistasverRegistroTransporter.txtCapacidad.getText();

if (!capacidadText.matches("\\d+")) {
    JOptionPane.showMessageDialog(VistasverRegistroTransporter, "Ingrese solo números", "Capacidad transporte", JOptionPane.ERROR_MESSAGE);
    return;
}

        guardarTransporte();
           Modelo.Guardar();
                   JOptionPane.showMessageDialog(VistasverRegistroTransporter, "Información ingresada con éxito", "Agregar transporte", JOptionPane.INFORMATION_MESSAGE);
                  Modelo.Limpiar(VistasverRegistroTransporter);
                  
                  
        String txtNombreRecurso = Modelo.getTipoVehiculo_transporte();
        
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuario = new Usuarios();
                 
         int idsUsuario = usuario.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambio = "Vehiculo " + txtNombreRecurso + " Ingresado en el sistema"; // Descripción del cambio
        
        CambioSistema cambiosSistema = new CambioSistema();
        
        cambiosSistema.insertarCambio(idsUsuario, descripcionCambio);
        
        System.out.println("El nombre del Vehiculo es: " + txtNombreRecurso);
                  
           
           } 
            

            


           
   
        frmVerRegistroTransporter frmRegistro = frmVerRegistroTransporter.getInstance();
        if (frmRegistro != null) {
            Modelo.Mostrar(frmRegistro.jtTransportes);
        }
           
 if(e.getSource() == VistasverRegistroTransporter.btnMenu) {
            Drawer.getInstance().showDrawer();
        }
       
       if(e.getSource()== VistasverRegistroTransporter.btnVerRegistro){
                   frmVerRegistroTransporter.initFrmVerRegistroTransportes();                  
                   VistasverRegistroTransporter.dispose();   
    }
       }      
       
          
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
