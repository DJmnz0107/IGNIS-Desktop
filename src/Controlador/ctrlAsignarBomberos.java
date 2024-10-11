    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Controlador;

import Modelo.BomberoDisplay;
    import Modelo.Bomberos;
import Modelo.CambioSistema;
import Modelo.MisionDisplay;
    import Modelo.Misiones;
    import Modelo.MisionesBomberos;
import Modelo.Usuarios;
import Vistas.frmAgregarMision;
    import Vistas.frmAsignarMisionesBomberos;
import Vistas.frmRegistroMisionesBomberos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
    import javax.swing.JOptionPane;

    /**
     *
     * @author danie
     */
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
    import javax.swing.JOptionPane;

    public class ctrlAsignarBomberos implements MouseListener {
        private frmAsignarMisionesBomberos vista;
        private MisionesBomberos modelo;

        public ctrlAsignarBomberos(frmAsignarMisionesBomberos vista, MisionesBomberos modelo) {
            this.modelo = modelo;
            this.vista = vista;
            this.vista.btnguardar.addMouseListener(this);
            this.vista.btnVerRegistros.addMouseListener(this);
            vista.imgBack.addMouseListener(this);
            
            modelo.obtenerBomberos(vista.cmbBombero);

            modelo.obtenerMisiones(vista.cmbMision);
            
            
       vista.cmbBombero.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        BomberoDisplay bomberoSeleccionado = (BomberoDisplay) vista.cmbBombero.getSelectedItem(); // Cambiar a BomberoDisplay
        if (bomberoSeleccionado != null) {
            Bomberos bombero = bomberoSeleccionado.getBombero(); // Obtener el objeto Bomberos
            System.out.println("Bombero seleccionado: " + bombero.getNombreCompleto());
            System.out.println("ID Bombero: " + bombero.getId_bombero());
        }
    }
});
       
     vista.cmbMision.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener el elemento seleccionado del JComboBox
        MisionDisplay misionSeleccionada = (MisionDisplay) vista.cmbMision.getSelectedItem();
        
        // Comprobar si hay una misión seleccionada
        if (misionSeleccionada != null) {
            // Obtener el objeto Misiones desde MisionDisplay
        Misiones mision = misionSeleccionada.getMision();
        
            
            // Ahora puedes usar los métodos de Misiones sin problemas
            System.out.println("Misión seleccionada: " + mision.getDescripcionMision());
            System.out.println("ID Misión: " + mision.getIdMision());
        }
    }
});


           
        }





        @Override
        public void mouseClicked(MouseEvent e) {
if (e.getSource() == vista.btnguardar) {
    
        if (vista.cmbMision.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir una misión nula, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (vista.cmbBombero.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "No se puede añadir un bombero nulo, asegurate que existan registros", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    
    BomberoDisplay bomberoSeleccionado = (BomberoDisplay) vista.cmbBombero.getSelectedItem();
    MisionDisplay misionSeleccionada = (MisionDisplay) vista.cmbMision.getSelectedItem();

    if (bomberoSeleccionado != null && misionSeleccionada != null) {
        int idBomberoSeleccionado = bomberoSeleccionado.getId_bombero();
        int idMisionSeleccionada = misionSeleccionada.getIdMision(); // Asegúrate que este método esté bien implementado

        System.out.println("ID Misión (para guardar): " + idMisionSeleccionada); // Verificación
        System.out.println("ID Bombero (para guardar): " + idBomberoSeleccionado); // Verificación

        // Verifica que el ID de misión y bombero son válidos
        if (idMisionSeleccionada > 0 && idBomberoSeleccionado > 0) {
            modelo.setId_bombero(idBomberoSeleccionado);
            modelo.setId_mision(idMisionSeleccionada);

            try {
                modelo.guardar(); // Asegúrate de que este método esté implementado correctamente
                JOptionPane.showMessageDialog(vista, "Información ingresada con éxito", "Agregar transporte", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace(); // Manejo de excepciones
                JOptionPane.showMessageDialog(vista, "Error al guardar la información: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("ID Misión o Bombero no válido.");
            JOptionPane.showMessageDialog(vista, "ID Misión o Bombero no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("No se ha seleccionado ningún bombero o misión.");
    }
    
            
        
        String nombreRecurso = ctrlLogin.nombreUsuario;   
                   
        Usuarios usuarios = new Usuarios();
                 
         int idsUsuario = usuarios.obtenerIdUsuario(nombreRecurso);
                  
        String descripcionCambios = "Se a asignado un bobmero a una mision"; // Descripción del cambio
        
        CambioSistema cambiosSistemas = new CambioSistema();
        
        cambiosSistemas.insertarCambio(idsUsuario, descripcionCambios);
        
    
}

if(e.getSource() == vista.imgBack) {
    frmAgregarMision.initFrmAgregarMision();
    vista.dispose();
}

if(e.getSource() == vista.btnVerRegistros) {
    frmRegistroMisionesBomberos.initfrmRegistroMisionesBomberos();
        vista.dispose();
}

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // Puedes dejarlo vacío si no necesitas implementar lógica aquí
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Puedes dejarlo vacío si no necesitas implementar lógica aquí
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Puedes dejarlo vacío si no necesitas implementar lógica aquí
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Puedes dejarlo vacío si no necesitas implementar lógica aquí
        }
    }













