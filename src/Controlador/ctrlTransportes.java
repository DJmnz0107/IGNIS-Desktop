package Controlador;

import Modelo.Transportes;
import Vistas.frmAgregarTransportes;
import Vistas.frmVerRegistroTransporter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlTransportes implements MouseListener{
    
    private Transportes Modelo;
    private frmVerRegistroTransporter verRegistroTransporter;
    private frmAgregarTransportes VistasverRegistroTransporter;
    
    public ctrlTransportes (Transportes modelo, frmAgregarTransportes VistasverRegistroTransporter, frmVerRegistroTransporter verRegistroTransporter){
    
        this.Modelo = modelo;
        this.verRegistroTransporter = verRegistroTransporter;
        this.VistasverRegistroTransporter = VistasverRegistroTransporter;

        
        modelo.Mostrar(verRegistroTransporter.jtTransportes);
        
         this.VistasverRegistroTransporter.btnAgregar.addMouseListener(this);
        
        
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
        
       if(e.getSource()== VistasverRegistroTransporter.btnAgregar){
                
           guardarTransporte();
           Modelo.Guardar();
           Modelo.Limpiar(VistasverRegistroTransporter);
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
