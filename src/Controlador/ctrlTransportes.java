package Controlador;

import Modelo.Transportes;
import Vistas.frmAgregarTransportes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlTransportes implements MouseListener{
    
    private Transportes Modelo;
    private frmAgregarTransportes Vistas;
    
    public ctrlTransportes (Transportes modelo, frmAgregarTransportes vistas){
    
        this.Modelo = modelo;
        this.Vistas = vistas;
        
        vistas.btnAgregar.addMouseListener(this);
       
        
        Vistas.cmbAgregarTransporte.addMouseListener(this);
        Vistas.cmbDisponibilidad.addMouseListener(this);
        
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vistas.btnAgregar) {
            Transportes tipoTransportes = (Transportes) Vistas.cmbAgregarTransporte.getSelectedItem();
            int idTransporte = tipoTransportes.getId_transporte();
            System.out.println("el id del tipo de transporte seleccionado es: " + idTransporte);
            
            Transportes Disponibilidad = (Transportes) Vistas.cmbDisponibilidad.getSelectedItem();
            int idDisponibilidad = Disponibilidad.getId_transporte();
            System.out.println("el id del tipo de transporte seleccionado es: " + idDisponibilidad);
            
            
            
            Modelo.setPlaca_transporte(Vistas.txtPlaca.getText());
            
            Modelo.setNumero_transporte(Vistas.txtNumeroTransporte.getText());
            
            int capacidadTransporte = Integer.parseInt(Vistas.txtCapacidad.getText());
            Modelo.setCapacidad_transporte(capacidadTransporte);
            
            Modelo.setEstado_transporte(Vistas.txtEstado.getText());
            
            Modelo.Guardar();
            
            
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
